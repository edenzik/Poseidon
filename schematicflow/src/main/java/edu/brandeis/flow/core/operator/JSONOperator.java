package edu.brandeis.flow.core.operator;

/**
 * JSONOperator is the abstract class implemented from Operator interface.
 * It should be extended by all operators that process JSON object. 
 */

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.ui.Image;

public abstract class JSONOperator implements Operator<JSONObject> {
	
	private final Queue<JSONObject> buffer; // hold all received JSON streams
	private final Set<Operator<JSONObject>> next; // a set of operators that the current operator will send data to.
	private String name;
	private String description;
	private Image img; //icon
	
	/**
	 * Constructor
	 */
	protected JSONOperator(){
		this.buffer = new ConcurrentLinkedQueue<JSONObject>();
		this.next = null;
	}
	
	/**
	 * Receive JSON object as input
	 * @param obj JSONObject need to be received
	 */
	public void recieve(JSONObject obj) {buffer.add(obj);}

	/**
	 * Send processed JSON object to all its next operators
	 * @param obj JSONObject needs to be send to next operators
	 */
	public void send(JSONObject obj) {for (Operator<JSONObject> op : next)op.recieve(obj);}

	/**
	 * Process input JSON. Need to be implemented by every opeartor
	 * @throws JSONException 
	 */
	public abstract void process() throws JSONException;

	/**
	 * Add the next operator to its set
	 * 
	 * @param op the next operator need to be added
	 */
	public void addNextOperator(Operator<JSONObject> op) {next.add(op);}
	
	/**
	 * Get the next operator in the list
	 * 
	 * @return Set<Operator<JSONObject>> next operator(s), which returns more than one
	 * operation when implement Split operator
	 */
	public Set<Operator<JSONObject>> getNextOperator() {return this.next;}
	
	/**
	 * Get the name of the current operator
	 * 
	 * @return String name
	 */
	public String getName() {return this.name;}

	/**
	 * Get the description of the current operator
	 * 
	 * @return String descroption
	 */
	public String getDescription() {return this.description;}
	
	/**
	 * Get the image of the current oeprator
	 * 
	 * @return Image image
	 */
	public Image getImage() {return this.img;}

	/**
	 * Read the first JSONObject that is need to be processed
	 * 
	 * @return JSONObject processed JSONObject
	 * 
	 */
	public JSONObject read() {return buffer.poll();}
	
}
