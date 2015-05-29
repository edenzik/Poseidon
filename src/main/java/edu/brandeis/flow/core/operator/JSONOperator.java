package edu.brandeis.flow.core.operator;



import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONException;

import edu.brandeis.flow.core.json.JSONObject;

/**
 *
 * JSONOperator is the abstract class implemented from Operator interface.
 * It should be extended by all operators that process JSON object. 
 *
 * @author edenzik
 *
 */

public abstract class JSONOperator implements Operator<JSONObject> {
	public final ConcurrentLinkedQueue<JSONObject> buffer; // hold all received JSON streams
	protected final Set<Operator<JSONObject>> next; // a set of operators that the
													// current operator will
													// send data to.
	public final ConcurrentLinkedQueue<JSONObject> previewOut;
	public final AtomicInteger size;
	public final long time;
	public final Thread thread;
	
	/**
	 * Constructor
	 * Initializes all elements, and starts itself
	 */
	protected JSONOperator() {
		size = new AtomicInteger(0);
		time = System.currentTimeMillis();
		this.buffer = new ConcurrentLinkedQueue<JSONObject>();
		this.previewOut = new ConcurrentLinkedQueue<JSONObject>();
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
			obj.changeAnnotation(this.getCurrTag());
			boolean forwarded = false;
			previewOut.clear();
			previewOut.add(obj);
			for (Operator<JSONObject> op : next){
					op.receive(obj);
					forwarded = true;
			}
			if (!forwarded){
				buffer.add(obj);
			}
			
			size.incrementAndGet();
			
	}
	
	/**
	 * Previews the last outgoing object
	 * 
	 * @param obj
	 *            JSONObject needs to be send to next operators
	 */
	public JSONObject preview() {
		JSONObject temp = previewOut.poll();
		if (temp!=null){
			previewOut.add(temp);
		}
		
		return previewOut.peek();
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
		if (buffer.size()==0){
			size.decrementAndGet();
		}
		int diff = (int) (System.currentTimeMillis() - time);
		diff = diff+1;
		int result = (1000*size.get())/diff;
		if (result<0){
			return 0;
		}
		return result;
		
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getName();
	}
	

	/**
	 * @return if the buffer is currently empty
	 */
	public boolean bufferIsEmpty() {
		return buffer.isEmpty();
	}
	
	/**
	 * @return returns the tag of the JSON
	 */
	public String getCurrTag() {
		return Integer.toString(this.hashCode());
	}

}
