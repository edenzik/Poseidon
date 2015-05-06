package edu.brandeis.flow.core.operator.in;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.json.JSONArray;
import org.json.JSONException;
import edu.brandeis.flow.core.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.annotations.Push;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.server.source.JSONSource;
import edu.brandeis.flow.server.stream.JSONThread;

/**
 * 
 * @author Yahui
 *
 */
@Push
public class In extends JSONOperator {
	String url;
	
	public In() {
		super();
		url = null;
	}
	public void setURL(String url)  {
		this.url = url;
	}
	
	@Override
	public void run() {
		while (true) {
				System.out.print("");
				if (url==null) continue;
				
				try {
					JSONArray arr = Unirest.get(url).asJson().getBody().getArray();
					for (int i = 0; i < arr.length(); i++) {
						  send(new JSONObject(arr.getJSONObject(i)));
					}
					Thread.sleep(1);

				} catch (InterruptedException e) {
					break;
				} catch (Exception e) {}

				
			
			
		}

	}

}
