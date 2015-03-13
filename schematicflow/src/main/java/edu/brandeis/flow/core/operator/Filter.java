/**
 * 
 */
package edu.brandeis.flow.core.operator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author edenzik
 *
 */
final class Filter extends JSONOperator {
	String key;
	String term;
	
	public Filter(String key, String term){
		this.key = key;
		this.term = term;
	}

	/* (non-Javadoc)
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void process() throws JSONException {
		JSONObject top = read();
		if (!top.getString(key).contains(term)) send(top);
	}

}
