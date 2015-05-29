package edu.brandeis.flow.core.json;

import org.json.JSONException;


/**
 * @author edenzik
 * The main class shadowing the underlying JSONObject class, 
 * which allows us to annotate each JSONObject with some string, which can be useful for
 * determining its origin node or eliminating duplicate data.
 *
 */
public class JSONObject extends org.json.JSONObject {
	String annotation;

	/**
	 * Constructor allows us to annotate the object
	 * @param msg is the annotation for the object. Currently not used
	 * @throws JSONException
	 */
	public JSONObject(String msg) throws JSONException {
		super(msg);
		String annotation = "";
	}

	/**
	 * Returns a JSONObject (shadowed) from an underlying JSONObject.
	 * @param jsonObject
	 */
	public JSONObject(org.json.JSONObject jsonObject) {
		super(jsonObject);
	}
	
	/**
	 * Adds annotation to object
	 * @param hashcode
	 */
	public void addAnnotation(String hashcode) {
		this.annotation = hashcode;
	}
	
	/**
	 * Modifies an annotation
	 * @param hashcode
	 */
	public void changeAnnotation(String hashcode) {
		this.annotation = hashcode;
	}
	
	/**
	 * Getter for the annotation
	 * @return the JSON's annotation
	 */
	public String getAnnotation() {
		return this.annotation;
	}
	
	/**
	 * Determines equality for annotation
	 * @param json
	 * @return true or false, if identity is true
	 */
	public boolean equalAnnotation(JSONObject json) {
		return getAnnotation().equals(json.getAnnotation());
	}

}
