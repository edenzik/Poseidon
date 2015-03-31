/**
 * 
 */
package edu.brandeis.flow.core.operator.in.twitter;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.server.source.JSONSource;
import edu.brandeis.flow.server.stream.JSONThread;

/**
 * @author Yahui
 *
 */
public final class TwitterIN extends In {

	public TwitterIN(String name) throws JSONException, IOException {
		super(name, "twitter");
	}
	
	public TwitterIN() throws JSONException, IOException{
		this("TwitterIn");
	}

//	 public static void main(String[] args) throws JSONException, IOException
//	 {
//		 TwitterIN test = new TwitterIN("test");
//		 test.process();
//	 }

}
