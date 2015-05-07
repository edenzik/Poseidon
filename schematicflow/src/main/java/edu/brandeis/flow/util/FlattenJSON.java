package edu.brandeis.flow.util;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;

public class FlattenJSON {
	public static void main(String[] args){
		System.out.println("hello");
		TwitterIN in = new TwitterIN();
		while (true){
			JSONObject recent = in.previewOut.poll();
		if (recent!=null){
			//System.out.println(recent);
			System.out.println(flatten(recent));
			return;
		}
		}
		
	}
	public static JSONObject flatten(JSONObject input){
		String result = "";
		JSONObject out = new JSONObject();
		Iterator<?> keys = input.keys();
		while (keys.hasNext()){
			String key = (String)keys.next();
			if (input.optJSONObject(key)!=null){
				result+=flatten(input.optJSONObject(key));
			} else {
				try {
					out.append(key, input.get(key));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return out;
	}
}

