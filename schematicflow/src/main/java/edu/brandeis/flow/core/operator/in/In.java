package edu.brandeis.flow.core.operator.in;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

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
	String source = "";
	public In(String name, String sr) throws JSONException, IOException {
		super(name);
		//feed JSON from its source(e.g. twitter/url) to server
		source = sr;
		new Thread(new JSONSource(source)).start();
		
		//feed JSON from server to In
		JSONThread thread = new JSONThread(this);
		thread.start();
	}
	

	public In(String sr) throws JSONException, IOException {
		this("In", sr);
	}

	@Override
	public void process() {

		while (true) {
			JSONObject top;
			if ((top = read()) != null) {
				System.out.println("IN:::" + top);
				send(top);
			}

		}
	}
	
	protected void setSource(String s) {
		this.source = s;
	}

}
