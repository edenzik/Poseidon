/**
 * 
 */
package edu.brandeis.flow.core.operator;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;

/**
 * @author Yahui
 *
 */
public final class TwitterIN extends In {

	protected TwitterIN() throws JSONException, IOException {
		super("TwitterIN");
	}
//	
//	public static void main(String[] args) throws JSONException, IOException {
//		TwitterIN test = new TwitterIN("test");
//		System.out.println(test.read().toString());
//	}

}
