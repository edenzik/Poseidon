/**
 * 
 */
package edu.brandeis.flow.core.operator.filter;

import org.json.JSONException;
import org.json.JSONObject;

import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author edenzik
 *
 */
public final class Filter extends JSONOperator {
	String key;
	String term;

	public Filter() {
		super("Filter");
		this.key = "";
		this.term = "";
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void process() throws JSONException {
		JSONObject top;
		while (true) {
			if ((top = read()) != null) {
				if (!top.has(key))
					send(top);
				else if (!term.equals("") && !top.getString(key).contains(term)) {
					send(top);
				}
			}
		}
	}

}
