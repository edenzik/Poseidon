/**
 * 
 */
package edu.brandeis.flow.core.operator.map;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

import org.json.JSONException;
import edu.brandeis.flow.core.json.JSONObject;

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
		if(key.equalsIgnoreCase("TS")){
			runTS();
		}else {
			runKV();
		}
	}
	
	public void runTS(){
		JSONObject top;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		while(true){
			if((top = read())!= null) {
				try {
					top.put("TimeStamp", sdf.format(new Date()));
					send(top);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void runKV() {
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
				System.out.println(top);
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

