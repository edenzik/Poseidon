package edu.brandeis.flow.core.operator;

/**
 * JSONOperator is the abstract class implemented from Operator interface.
 * It should be extended by all operators that process JSON object. 
 */

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.json.JSONObject;

import com.vaadin.ui.Image;

abstract class JSONOperator implements Operator<JSONObject> {
	
	private final Queue<JSONObject> buffer; // hold all received JSON streams
	private Set<Operator<JSONObject>> next; // a set of operators that the current operator will send data to.
	private String name;
	private String description;
	private Image img; //icon
	
	/**
	 * Constructor
	 */
	private JSONOperator(){
		this.buffer = new ConcurrentLinkedQueue<JSONObject>();
	}
	
	/**
	 * Receive JSON object as input
	 * @param obj JSONObject need to be received
	 */
	public void recieve(JSONObject obj) {
		buffer.add(obj);
	}

	/**
	 * Send processed JSON object to all its next operators
	 * @param obj JSONObject needs to be send to next operators
	 */
	public void send(JSONObject obj) {
		for (Operator<JSONObject> op : next)op.recieve(obj);
	}

	/**
	 * Process input JSON. Need to be implemented by every opeartor
	 */
	public abstract void process();

	/**
	 * Set the name of operator
	 */
	public void setName(String name) {
		this.name = name;
		
	}

	/**
	 * Set the description of operator
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Set the icon of operator
	 */
	public void setImage(Image img) {
		this.img = img;
		
	}

	/**
	 * Add the next operator to its set
	 * @param op the next operator need to be added
	 */
	public void addNext(Operator<JSONObject> op) {
		next.add(op);
	}


	public Set<Operator<JSONObject>> getNext() {return this.next;}


	public String getName() {return this.name;}

	public String getDescription() {return this.description;}

	public Image getImage() {return this.img;}
	
}
