/**
 * 
 */
package edu.brandeis.flow.core.operator.in.twitter;

import java.io.IOException;
import java.net.MalformedURLException;

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
import edu.brandeis.flow.core.operator.Operator;
import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.server.source.Streamer;

/**
 * @author Yahui
 *
 */
public final class TwitterIN extends In implements Runnable {
	public ConfigurationBuilder cb = new ConfigurationBuilder();
	public TwitterStream twitterStream;
	public StatusListener listener;

	public TwitterIN() throws JSONException, IOException {
		super("TwitterIN");
		setUpBuilder();
		twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		
	}
	
	public void setUpBuilder() {
		cb.setDebugEnabled(false)
		.setOAuthConsumerKey("OiXPmaK5iF9InAsjUY3cpAIBi")
		.setJSONStoreEnabled(true)
		.setOAuthConsumerSecret("nDbaKfCzh7gnxsVqVGihd3GwkbIGqAmxsejgwsrNo4XaEum772")
		.setOAuthAccessToken("3018770327-MdYABjcFvagY2yNQnjoUEOuUwM9QfwafnjbTP9v")
		.setOAuthAccessTokenSecret("6y5vUF8TLfRC6P8tNiD1KeDNnzeBYzYNxnx12NqIEQkAv");
	}
	
	public void setUpListener() {
		
			Operator<JSONObject> op = this;
			listener = new StatusListener(){
			
						public void onException(Exception arg0) {
							// TODO Auto-generated method stub
							
						}
			
						public void onDeletionNotice(StatusDeletionNotice arg0) {
							//System.out.println("Deletion notice from" + arg0.getUserId());
							
						}
			
						public void onScrubGeo(long arg0, long arg1) {
							// TODO Auto-generated method stub
							
						}
			
						public void onStallWarning(StallWarning arg0) {
							// TODO Auto-generated method stub
							
						}
			
						public void onStatus(Status arg0) {
							//TwitterStreamFactor.getRawJSON(arg0.getTw)
							try {
								op.send(new JSONObject(TwitterObjectFactory.getRawJSON(arg0)));
								System.out.println("Tada!");
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
			
						public void onTrackLimitationNotice(int arg0) {
							// TODO Auto-generated method stub
							
						}
		};
	}

	@Override
	public void run() {
		while (true){
			setUpListener();
			twitterStream.addListener(listener);
			twitterStream.sample();
			
		}
		
	}

}
