package edu.brandeis.flow.core.demo;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.operator.filter.Filter;
import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;
import edu.brandeis.flow.core.operator.join.Join;
import edu.brandeis.flow.core.operator.map.Map;
import edu.brandeis.flow.core.operator.out.Out;

public class OperatorDemo {

		public OperatorDemo() throws Exception {
			TwitterIN in = new TwitterIN();
			Out out = new Out();
			
			Filter filter = new Filter();
			filter.setup("in_reply_to_status_id_str", ".*", "regex", "");
			
			in.addNext(filter);
			filter.addNext(out);
			
			new Thread(in).start();
			new Thread(filter).start();
			new Thread(out).start();
			
		}

		
		public static void main(String[] args) throws Exception{
			OperatorDemo demo = new OperatorDemo();
		}


}

