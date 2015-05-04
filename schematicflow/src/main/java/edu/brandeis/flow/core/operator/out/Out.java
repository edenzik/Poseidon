/**
 * 
 */
package edu.brandeis.flow.core.operator.out;

import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author Yahui
 *
 */
public final class Out extends JSONOperator {

	/**
	 * @param name
	 */
	public Out() {
		super();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void run() {
		JSONObject s;
		while(true) {
			if ((s = read()) != null) {
				try {
					Unirest.post("http://localhost:8000")
					  .queryString("name", "Mark")
					  .field("last", "Polo")
					  .asJson();
				} catch (UnirestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
