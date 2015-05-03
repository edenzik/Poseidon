/**
 * 
 */
package edu.brandeis.flow.core.operator.in.twitter;

import org.json.JSONObject;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.server.source.twitter.TwitterStreamSource;
import edu.brandeis.flow.server.stream.JSONThread;

/**
 * @author Yahui
 *
 */
public class TwitterIN extends JSONOperator{


	public TwitterIN() {

		
	}
	
	public void startRequest() throws Exception {
		//start Twitter server
		TwitterStreamSource twitter = new TwitterStreamSource();
		
		JSONThread thread = new JSONThread(this, 5050);
		thread.start();
	}
	
	

	@Override
	public void run() {
		while (true) {
			JSONObject top;
			if ((top = read()) != null) {
				System.out.println("TwitterIN:::" + top);
				send(top);
			}

		}
	}

//	 public static void main(String[] args) throws Exception
//	 {
//		 TwitterIN test = new TwitterIN("test");
//		 test.process();
//	 }

}
