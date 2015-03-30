package edu.brandeis.flow.core.operator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.annotations.Push;
import com.vaadin.ui.UI;

import edu.brandeis.flow.server.stream.JSONStream;
import edu.brandeis.flow.server.stream.JSONThread;

/**
 * 
 * @author Yahui
 *
 */
@Push
public class In extends JSONOperator{
	public In(String name) throws JSONException, IOException {
		super(name);
		JSONThread thread = new JSONThread(this);
		thread.start();
	}
	
	public In() throws JSONException, IOException {
		this("In");
	}

	@Override
	public void process() {
//		JSONObject top;
//		while((top = read())!= null){
//			//send(top);
//			System.out.println(top.toString());
//		}
		int count = 0;
		while(true) {
			JSONObject top;
			if((top = read()) != null) {
				System.out.println(top);
				//send(top);
				
			}
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
//	
//
//	
	public static void main(String[] args) throws Exception {
		In test = new In("test");
		test.process();
	}
	
}
