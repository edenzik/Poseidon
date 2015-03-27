/**
 * 
 */
package edu.brandeis.flow.core.operator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Yahui
 *
 */
public final class Join extends JSONOperator {
	String key;
	/**
	 * @param name
	 */
	public Join() {
		super("Join");
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}

	/* (non-Javadoc)
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void process() throws JSONException {
		JSONObject top;
		JSONObject merged = read();
		while((top =read()) != null) {
			//merge 'top' with 'merged'
			merged.put(key, top.get(key));
		}
		
		//send
		send(merged);
	}

}
