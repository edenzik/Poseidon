/**
 * 
 */
package edu.brandeis.flow.core.operator.join;

import java.util.Iterator;

import org.json.JSONException;
import edu.brandeis.flow.core.json.JSONObject;

import com.google.common.collect.Iterables;

import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author Yahui
 *
 */
public final class Join extends JSONOperator {
	JSONObject first;
	JSONObject second;
	String key;
	/**
	 * @param name
	 */
	public Join() {
		super();
	}
	
	public void setup(String key){
		this.key = key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.brandeis.flow.core.operator.JSONOperator#process()
	 */
	@Override
	public void run() {
		while(true) {
			if((first = read()) != null && (second = read())!= null) {
				try {
					if (canJoin()) {
						send(addTag(makeJoin()));
//					System.out.println(makeJoin());
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public boolean canJoin() throws JSONException {
		if(sameTag() &&first.has(key) && second.has(key)) {
			first = removeTag(first);
			second = removeTag(second);
			if (first.get(key).equals(second.get(key))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean sameTag() {
		return getTag(first).equals(getTag(second));
	}
	
	public JSONObject makeJoin(){
		Iterator keys_second = second.keys();
		while(keys_second.hasNext()) {
			String key = keys_second.next().toString();
			if (!first.has(key)) {
				try {
					first.put(key, second.get(key));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return first;
	}
	
//	public boolean canJoin(){
//		Iterator keys_first = first.keys();
//		Iterator keys_second;
//		int count = 0;
//		int total = 0;
//		while(keys_first.hasNext()){
//			++total;
//			keys_second = second.keys();
//			String tmp1 = keys_first.next().toString();
//			while(keys_second.hasNext()) {
//				String tmp2 = keys_second.next().toString();
////				System.out.println(tmp1 + "  " + tmp2);
//				if(tmp1.equalsIgnoreCase(tmp2)) {
//					++count;
//				}
//			}
//		}
//		return 2*count <= total;
//
//	}
//	
//	public static void main(String[] args) throws JSONException {
//		JSONObject first = new JSONObject("{1: lol, 2:lol, 3:lol, 4:lol, 5:lol}");
//		JSONObject second = new JSONObject("{3: lol, 4:lol, 7:lol, 8:lol, 9:lol}");
//		JSONObject third = new JSONObject("{1: lol, 2:lol, 5:lol, 4:lol, 3:lol}");
//		JSONObject fourth = new JSONObject("{1: lol, 9:lol, 6:lol, 412:lol, 777:lol}");
//		Join test = new Join();
//		test.receive(first);
//		test.receive(second);
//		test.receive(third);
//		test.receive(fourth);
//		new Thread(test).start();
//
//	}

}
