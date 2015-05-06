package edu.brandeis.flow.core.json;

import org.json.JSONException;


public class JSONObject extends org.json.JSONObject {

	public JSONObject(String msg) throws JSONException {
		super(msg);
	}

	public JSONObject(org.json.JSONObject jsonObject) {
		super(jsonObject);
	}

}
