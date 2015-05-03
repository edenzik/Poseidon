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
import edu.brandeis.flow.server.source.Streamer;
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
		TwitterStreamSource();
		
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
	
	public ConfigurationBuilder cb = new ConfigurationBuilder();
	public TwitterStream twitterStream;
	public StatusListener listener;

	public void TwitterStreamSource() throws Exception {
		setUpBuilder();
		twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		setUpListener();
		
		twitterStream.addListener(listener);
		twitterStream.sample();
	}

	public void setUpBuilder() {
		cb.setOAuthConsumerKey("OiXPmaK5iF9InAsjUY3cpAIBi")
				.setOAuthConsumerSecret(
						"nDbaKfCzh7gnxsVqVGihd3GwkbIGqAmxsejgwsrNo4XaEum772")
				.setOAuthAccessToken(
						"3018770327-MdYABjcFvagY2yNQnjoUEOuUwM9QfwafnjbTP9v")
				.setOAuthAccessTokenSecret(
						"6y5vUF8TLfRC6P8tNiD1KeDNnzeBYzYNxnx12NqIEQkAv");
	}

	public void setUpListener() {
		listener = new StatusListener() {

			@Override
			public void onException(Exception arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice arg0) {
				// System.out.println("Deletion notice from" +
				// arg0.getUserId());

			}

			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStatus(Status arg0) {
				// TwitterStreamFactor.getRawJSON(arg0.getTw)
				try {
					System.out.println("wow");
					send(new JSONObject(TwitterObjectFactory.getRawJSON(arg0)));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			@Override
			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub

			}
		};
	}

//	 public static void main(String[] args) throws Exception
//	 {
//		 TwitterIN test = new TwitterIN("test");
//		 test.process();
//	 }

}
