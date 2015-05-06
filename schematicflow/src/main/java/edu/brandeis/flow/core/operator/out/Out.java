/**
 * 
 */
package edu.brandeis.flow.core.operator.out;

import edu.brandeis.flow.core.json.JSONObject;

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
					System.out.println("OUT:::"+s);
					Thread.sleep(1);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
		
	}

}
