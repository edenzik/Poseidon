/**
 * 
 */
package edu.brandeis.flow.core.operator.in.twitter;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterObjectFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.operator.Operator;
import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.server.source.Streamer;
import edu.brandeis.flow.server.source.JSONSource;
import edu.brandeis.flow.server.source.twitter.TwitterStreamSource;
import edu.brandeis.flow.server.stream.JSONThread;

/**
 * @author Yahui
 *
 */
public class TwitterIN extends JSONOperator{


	public TwitterIN(String name) throws Exception{
		super(name);
		
		//start Twitter server
		TwitterStreamSource twitter = new TwitterStreamSource();
		
		JSONThread thread = new JSONThread(this);
		thread.start();
	}
	
	public TwitterIN() throws Exception{
		this("TwitterIn");
	}

	@Override
	public void process() throws JSONException {
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
