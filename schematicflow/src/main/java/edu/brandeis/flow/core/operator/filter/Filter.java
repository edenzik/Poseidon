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
		super();
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



	@Override
	public void run() {
		JSONObject top;
		while (true) {
			if ((top = read()) != null) {
				if (!top.has(key))
					send(top);
				else
					try {
						if (!term.equals("") && !top.getString(key).contains(term)) {
							send(top);
						}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
	}

}
