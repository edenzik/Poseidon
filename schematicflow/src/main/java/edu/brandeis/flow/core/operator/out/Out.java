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
	public Out(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void process() throws JSONException {
		System.out.println(read());
	}

}
