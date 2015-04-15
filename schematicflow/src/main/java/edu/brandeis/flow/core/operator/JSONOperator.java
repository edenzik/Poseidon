package edu.brandeis.flow.core.operator;

/**
 * JSONOperator is the abstract class implemented from Operator interface.
 * It should be extended by all operators that process JSON object. 
 */

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.ui.UI;

public abstract class JSONOperator implements Operator<JSONObject> {
	protected final BlockingQueue<JSONObject> buffer; // hold all received JSON streams
	protected final Set<Operator<JSONObject>> next; // a set of operators that the
													// current operator will
													// send data to.

	/**
	 * Constructor
	 */
	protected JSONOperator() {
		this.buffer = new LinkedBlockingQueue<JSONObject>();
		this.next = new HashSet<Operator<JSONObject>>();
		new Thread(this).start();
	}

	/**
	 * Receive JSON object as input
	 * 
	 * @param obj
	 *            JSONObject need to be received
	 */
	public void receive(JSONObject obj) {
		System.out.println("Added it to here!");
		buffer.add(obj);
	}

	/**
	 * Send processed JSON object to all its next operators
	 * 
	 * @param obj
	 *            JSONObject needs to be send to next operators
	 */
	public void send(JSONObject obj) {
		System.out.println("Starting tsend" + hashCode());
		for (Operator<JSONObject> op : next){
			op.receive(obj);
			System.out.println("sent stuff to" + op);
		}
			
	}

	/**
	 * Add the next operator to its set
	 * 
	 * @param op
	 *            the next operator need to be added
	 */
	public void addNext(Operator<JSONObject> op) {
		next.add(op);
		
		System.out.println("Added " +  hashCode());
	}

	/**
	 * Add the next operator to its set
	 * 
	 * @param op
	 *            the next operator need to be added
	 */
	public void removeNext(Operator<JSONObject> op) {
		next.remove(op);
	}

	/**
	 * Get the next operator in the list
	 * 
	 * @return Set<Operator<JSONObject>> next operator(s), which returns more
	 *         than one operation when implement Split operator
	 */
	public Set<Operator<JSONObject>> getNext() {
		return this.next;
	}

	/**
	 * Read the first JSONObject that is need to be processed
	 * 
	 * @return JSONObject processed JSONObject
	 * 
	 */
	public JSONObject read() {
		try {
			return buffer.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}


	public boolean bufferIsEmpty() {
		return buffer.isEmpty();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	

}
