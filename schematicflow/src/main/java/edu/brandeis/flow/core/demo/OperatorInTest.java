package edu.brandeis.flow.core.demo;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.core.operator.out.Out;

public class OperatorInTest {

		public OperatorInTest() throws Exception {
			
			In in = new In("http://developer.mbta.com/Data/Red.json",6000);
			Out out = new Out();
			
			in.addNext(out);
			
			OpThread threadIn = new OpThread(in);
			new Thread(threadIn).start();
			
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
				op.run();
			}
			

		}
		
		public static void main(String[] args) throws Exception{
			OperatorInTest demo = new OperatorInTest();
		}


}
