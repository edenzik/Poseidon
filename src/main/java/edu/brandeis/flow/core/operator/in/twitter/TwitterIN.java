/**
 * 
 */
package edu.brandeis.flow.core.operator.in.twitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.json.JSONException;

import edu.brandeis.flow.core.json.JSONObject;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.endpoint.StatusesFirehoseEndpoint;
import com.twitter.hbc.core.endpoint.StatusesSampleEndpoint;
import com.twitter.hbc.core.event.Event;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

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

	Client hosebirdClient;
	BlockingQueue<String> msgQueue;
	StatusesFilterEndpoint hosebirdEndpoint;
	ClientBuilder builder;
	
	public TwitterIN() {
		super();
	}
	
	public void setup(){
		/** Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
		msgQueue = new LinkedBlockingQueue<String>(100000);
		BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>(1000);

		/** Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
		Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
		StatusesSampleEndpoint endpoint = new StatusesSampleEndpoint();
		// Optional: set up some followings and track terms
		//List<Long> followings = Lists.newArrayList(1234L, 566788L);
		//hosebirdEndpoint.followings(followings);
		//hosebirdEndpoint.trackTerms(Lists.newArrayList("wow"));


		// These secrets should be read from a config file
		Authentication hosebirdAuth = new OAuth1("TTBE60eAPTsAXmlbbI40rLghJ", "PWpwNjRO7kbudahmo2iDkE8oleS1DYaIGXUolcUoYyARGN4Puc", "74636828-F2loUl3xriqQ2rzd6rljQHHU5PkDTtu54LHlO8w1E", "rtdw5lXoXWEUyI2cREJWZy3ma8jvZCESA8EYHl8FHKTgW");
		builder = new ClientBuilder()
		  .name("Hosebird-Client-01")                              // optional: mainly for the logs
		  .hosts(hosebirdHosts)
		  .authentication(hosebirdAuth)
		  .endpoint(endpoint)
		  .processor(new StringDelimitedProcessor(msgQueue))
		  .eventMessageQueue(eventQueue);                          // optional: use this if you want to process client events
		hosebirdClient = builder.build();
		// Attempts to establish a connection.
		hosebirdClient.connect();
		
	}
	
	public void clear(){
		hosebirdClient.stop();
		setup();
	}
	
	public void resetParam(List<String> params){
		//hosebirdClient.stop();
		/** Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
		msgQueue = new LinkedBlockingQueue<String>(100000);
		BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>(1000);

		/** Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
		Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
		hosebirdEndpoint = new StatusesFilterEndpoint();
		// Optional: set up some followings and track terms
		//List<Long> followings = Lists.newArrayList(1234L, 566788L);
		List<String> terms = params;
		//hosebirdEndpoint.followings(followings);
		hosebirdEndpoint.trackTerms(terms);
		

		// These secrets should be read from a config file
		
		Authentication hosebirdAuth = new OAuth1("NB4qEM6mFsomiOI26Sp8BQ", "bTSpDvixWSpiYyZ5HaEp2KJYZsggKL7DnDZGbh7r8", "414557955-kkVlvRvQNUDXKMKsv1E6odOgpyjjEDTj374kbG1S", "IEMyckpYCWtOfLRIzaMy82KVhmnAWzNml8sHoGjAIGO9u");
		builder = new ClientBuilder()
		  .name("Hosebird-Client-01")                              // optional: mainly for the logs
		  .hosts(hosebirdHosts)
		  .authentication(hosebirdAuth)
		  .endpoint(hosebirdEndpoint)
		  .processor(new StringDelimitedProcessor(msgQueue))
		  .eventMessageQueue(eventQueue);                          // optional: use this if you want to process client events
		hosebirdClient = builder.build();
		// Attempts to establish a connection.
		hosebirdClient.connect();
		
	}
	
	

	
	

	@Override
	public void run() {
		setup();

		String msg;
		while (true) {
			  
			try {
				msg = msgQueue.take();
				
				//System.out.println(msg);
				send(new JSONObject(msg));
				
				
			} catch (InterruptedException e) {
				hosebirdClient.stop();
				break;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		}
	}
	
	
	


}
