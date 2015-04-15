package edu.brandeis.flow.core.demo;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.operator.filter.Filter;
import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;
import edu.brandeis.flow.core.operator.join.Join;
import edu.brandeis.flow.core.operator.map.Map;
import edu.brandeis.flow.core.operator.out.Out;

public class OperatorDemo {

		public OperatorDemo() throws JSONException, IOException {
			TwitterIN in = new TwitterIN();
			Out out = new Out();
			Filter filter = new Filter();
			Map map = new Map();
			Join join = new Join();
			
			filter.setKey("delete");
			filter.setTerm("status");
			
			in.addNext(filter);
			filter.addNext(out);
			
			OpThread threadIn = new OpThread(in);
			new Thread(threadIn).start();
			
			OpThread threadFilter = new OpThread(filter);
			new Thread(threadFilter).start();
			
			OpThread threadOut = new OpThread(out);
			new Thread(threadOut).start();
			
		}
		
		public class OpThread implements Runnable {
			JSONOperator op;
			public OpThread(JSONOperator op) {
				this.op = op;
			}
			
			@Override
			public void run() {
				
			}
			

		}
		
		public static void main(String[] args) throws Exception{
			OperatorDemo demo = new OperatorDemo();
		}


}
