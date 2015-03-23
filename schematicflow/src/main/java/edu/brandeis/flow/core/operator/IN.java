package edu.brandeis.flow.core.operator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.flow.server.stream.JSONStream;
import com.vaadin.ui.UI;

/**
 * 
 * @author Yahui
 *
 */
public class IN extends JSONOperator{
	JSONStream inStream;

	protected IN(String name) throws JSONException, IOException {
		super(name);
		inStream = new JSONStream("localhost", 5050);	
		setupBuffer();
	}
	
	
	public void setupBuffer() throws JSONException, IOException{
		Set<JSONObject> tmp = inStream.read();
		for(JSONObject json : tmp) {
			receive(json);
			//System.out.println(json.toString());
		}

	}

	@Override
	public void process() {
		JSONObject top;
		while((top = read())!= null){
			//send(top);
			System.out.println(top.toString());
		}
	}
	
	public static void main(String[] args) throws Exception {
		IN test = new IN("test");
		test.process();
	}
	
}
