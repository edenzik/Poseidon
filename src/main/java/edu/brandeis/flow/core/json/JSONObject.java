package edu.brandeis.flow.core.json;

import org.json.JSONException;


public class JSONObject extends org.json.JSONObject {
	String annotation;

	public JSONObject(String msg) throws JSONException {
		super(msg);
		String annotation = "";
	}

	public JSONObject(org.json.JSONObject jsonObject) {
		super(jsonObject);
	}
	
	public void addAnnotation(String hashcode) {
		this.annotation = hashcode;
	}
	
	public void changeAnnotation(String hashcode) {
		this.annotation = hashcode;
	}
	
	public String getAnnotation() {
		return this.annotation;
	}
	
	public boolean equalAnnotation(JSONObject json) {
		return getAnnotation().equals(json.getAnnotation());
	}

}
