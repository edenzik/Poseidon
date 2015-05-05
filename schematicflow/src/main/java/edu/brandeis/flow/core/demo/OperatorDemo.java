package edu.brandeis.flow.core.demo;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.operator.filter.Filter;
import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;
import edu.brandeis.flow.core.operator.join.Join;
import edu.brandeis.flow.core.operator.map.Map;
import edu.brandeis.flow.core.operator.out.Out;

public class OperatorDemo {

		public OperatorDemo() throws Exception {
			In RedIn = new In();
			RedIn.setURL("http://developer.mbta.com/Data/Red.json");
			
			In OrangeIn = new In();
			OrangeIn.setURL("http://developer.mbta.com/Data/Orange.json");
			Out out = new Out();
			
			Filter filter = new Filter();
			filter.setup("PlatformKey", "^(?!RHARS$).*$", "regex", "");
			
			RedIn.addNext(filter);
			OrangeIn.addNext(filter);
			filter.addNext(out);
			
			new Thread(RedIn).start();
			new Thread(OrangeIn).start();
			new Thread(filter).start();
			new Thread(out).start();
			
		}

		
		public static void main(String[] args) throws Exception{
			OperatorDemo demo = new OperatorDemo();
		}


}

