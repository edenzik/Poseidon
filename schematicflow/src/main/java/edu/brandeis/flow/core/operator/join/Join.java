/**
 * 
 */
package edu.brandeis.flow.core.operator.join;

import org.json.JSONException;
import org.json.JSONObject;

import edu.brandeis.flow.core.operator.JSONOperator;

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
		super();
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void run() {
		JSONObject top;
		JSONObject merged = read();
		while ((top = read()) != null) {
			// merge 'top' with 'merged'
			try {
				merged.put(key, top.get(key));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// send
		send(merged);
	}

}
