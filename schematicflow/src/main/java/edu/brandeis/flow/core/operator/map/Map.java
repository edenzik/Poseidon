/**
 * 
 */
package edu.brandeis.flow.core.operator.map;

import java.util.function.Function;

import org.json.JSONException;
import org.json.JSONObject;

import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author Yahui
 *
 */
public final class Map extends JSONOperator {
	String key = "";
//	Function<Double, Double> func;
	String term = "";

	/**
	 * Constructor
	 */
	public Map() {
		super();
	}
	
	public void setup(String key, String term){
		this.key = key;
		this.term = term;
	}
	
	public void run(){
		JSONObject top;
		while(true){
			if((top = read())!= null) {
				if(top.has(key))
					try {
						top.append(key, term);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else
					try {
						top.put(key, term);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				send(top);
			}
		}
	}

	/**
	 * Set JSON key
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get JSON key
	 * 
	 * @return String key
	 */
	public String getKey() {
		return key;
	}
	
	public void setTerm(String term){
		this.term = term;
	}
	
	public String getTerm() {
		return term;
	}


}

