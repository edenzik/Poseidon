/**
 * 
 */
package edu.brandeis.flow.core.operator.in.twitter;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.core.operator.in.In;

/**
 * @author Yahui
 *
 */
public final class TwitterIN extends In {

	public TwitterIN() throws JSONException, IOException {
		super("TwitterIN");
	}
	//
	// public static void main(String[] args) throws JSONException, IOException
	// {
	// TwitterIN test = new TwitterIN("test");
	// System.out.println(test.read().toString());
	// }

}
