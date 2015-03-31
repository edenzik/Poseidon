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

	public Out() {
		this("Out");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void process() throws JSONException {
		while (true) {
			if (!bufferIsEmpty()) {
				System.out.println("OUT:::" + read());
			}
		}
	}

}
