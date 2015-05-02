/**
 * 
 */
package edu.brandeis.flow.core.operator.out;

import org.json.JSONObject;

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
//				System.out.println("OUT:::" + s.toString());
			}
		}
		
	}

}
