/**
 * 
 */
package edu.brandeis.flow.core.operator;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.ui.Image;

/**
 * @author edenzik
 *
 */
public final class Filter extends JSONOperator {
	String key;
	String term;
	
	public Filter(){
		super("Filter");
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



	/* (non-Javadoc)
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void process() throws JSONException {
		JSONObject top = read();
		if (!top.getString(key).contains(term)) send(top);
	}

}
