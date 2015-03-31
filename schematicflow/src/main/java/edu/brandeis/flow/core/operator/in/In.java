package edu.brandeis.flow.core.operator.in;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.annotations.Push;
import com.vaadin.ui.UI;

import edu.brandeis.flow.core.operator.JSONOperator;
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
	}
	
	public In() throws JSONException, IOException {
		this("In");
	}

	@Override
	public void process() {
		
	}

	
}
