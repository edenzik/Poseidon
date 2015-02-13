package com.flow.server.source.twitter;

import java.io.IOException;

import com.flow.server.source.Streamer;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


public final class TwitterStreamSource {
    
    public static void main(String[] args) throws TwitterException, IOException {
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	final Streamer streamer = new Streamer(5050);
        cb.setDebugEnabled(false)
          .setOAuthConsumerKey("OiXPmaK5iF9InAsjUY3cpAIBi")
          .setJSONStoreEnabled(true)
          .setOAuthConsumerSecret("nDbaKfCzh7gnxsVqVGihd3GwkbIGqAmxsejgwsrNo4XaEum772")
          .setOAuthAccessToken("3018770327-MdYABjcFvagY2yNQnjoUEOuUwM9QfwafnjbTP9v")
          .setOAuthAccessTokenSecret("6y5vUF8TLfRC6P8tNiD1KeDNnzeBYzYNxnx12NqIEQkAv");
        
        
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        StatusListener listener = new StatusListener(){

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
				//System.out.println("hello");
				//TwitterStreamFactor.getRawJSON(arg0.getTw)
				System.out.println(TwitterObjectFactory.getRawJSON(arg0));
				//System.out.println ("Tweet From: " + arg0.getUser().getScreenName() + " Says: "+ arg0.getText());
				try {
					streamer.send(TwitterObjectFactory.getRawJSON(arg0));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub
				
			}};
        twitterStream.addListener(listener);
       // twitterStream.
        twitterStream.sample();
    }
}