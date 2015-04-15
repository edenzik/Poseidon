/**
 * 
 */
package edu.brandeis.flow.core.operator.out;

import org.json.JSONException;

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
		while (true) {
			System.out.println(this.read());
		}
	}

}
