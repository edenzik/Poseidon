package edu.brandeis.flow.core.operator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.flow.server.stream.JSONStream;
import com.vaadin.annotations.Push;
import com.vaadin.ui.UI;

/**
 * 
 * @author Yahui
 *
 */
@Push
public class In extends JSONOperator{
	JSONStream inStream;

	public In(String name) throws JSONException, IOException {
		super(name);
		inStream = new JSONStream("localhost", 5050);	
		setupBuffer();
	}
	
	public In() throws JSONException, IOException {
		this("In");
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
	
//	class JsonThread extends Thread{
//		@Override
//		public void run(){
//			try{
//				while(true) {
//					Thread.sleep(1000);
//					UI.getCurrent().access(new Runnable() {
//                        @Override
//                        public void run() {
//                            JSONStream inStream = null;
//							try {
//								inStream = new JSONStream("localhost", 5050);
//							} catch (MalformedURLException e) {
//								e.printStackTrace();
//							}
//                            Set<JSONObject> tmp = null;
//							try {
//								tmp = inStream.read();
//							} catch (JSONException | IOException e) {
//								e.printStackTrace();
//							}
//                    		for(JSONObject json : tmp) {
//                    			//send to buffer
//                    			System.out.println(json.toString());
//                    		}
//                        }
//                    });
//				}
//			}catch(Exception e){
//				
//			}
//		}
//	}
//	
//	public static void main(String[] args) throws Exception {
//		IN test = new IN("test");
//		test.process();
//	}
//	
}
