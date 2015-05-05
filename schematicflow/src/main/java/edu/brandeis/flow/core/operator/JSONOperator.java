package edu.brandeis.flow.core.operator;

/**
 * JSONOperator is the abstract class implemented from Operator interface.
 * It should be extended by all operators that process JSON object. 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONObject;

public abstract class JSONOperator implements Operator<JSONObject> {
	public final ConcurrentLinkedQueue<JSONObject> buffer; // hold all received JSON streams
	protected final Set<Operator<JSONObject>> next; // a set of operators that the
													// current operator will
													// send data to.
	public final AtomicInteger size;
	public final long time;
	public final Thread thread;
	/**
	 * Constructor
	 */
	protected JSONOperator() {
		size = new AtomicInteger(0);
		time = System.currentTimeMillis();
		this.buffer = new ConcurrentLinkedQueue<JSONObject>();
		this.next = new HashSet<Operator<JSONObject>>();
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Receive JSON object as input
	 * 
	 * @param obj
	 *            JSONObject need to be received
	 */
	@Override
	public void receive(JSONObject obj) {
		size.incrementAndGet();
		buffer.add(obj);
		
	}

	/**
	 * Send processed JSON object to all its next operators
	 * 
	 * @param obj
	 *            JSONObject needs to be send to next operators
	 */
	@Override
	public void send(JSONObject obj) {
			for (Operator<JSONObject> op : next){
					op.receive(obj);
			}
	}

	/**
	 * Add the next operator to its set
	 * 
	 * @param op
	 *            the next operator need to be added
	 */
	@Override
	public void addNext(Operator<JSONObject> op) {
		next.add(op);
	}

	/**
	 * Add the next operator to its set
	 * 
	 * @param op
	 *            the next operator need to be added
	 */
	@Override
	public void removeNext(Operator<JSONObject> op) {
		next.remove(op);
	}

	/**
	 * Get the next operator in the list
	 * 
	 * @return Set<Operator<JSONObject>> next operator(s), which returns more
	 *         than one operation when implement Split operator
	 */
	@Override
	public Set<Operator<JSONObject>> getNext() {
		return this.next;
	}
	
	public int getRate(){
		int diff = (int) (System.currentTimeMillis() - time);
		diff = diff/100;
		diff = diff+1;
		return size.get()/diff;
		
	}

	/**
	 * Read the first JSONObject that is need to be processed
	 * 
	 * @return JSONObject processed JSONObject
	 * 
	 */
	@Override
	public JSONObject read() {
		return buffer.poll();
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
	


	public boolean bufferIsEmpty() {
		return buffer.isEmpty();
	}


}
