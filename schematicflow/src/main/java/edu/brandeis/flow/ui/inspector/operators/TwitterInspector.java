package edu.brandeis.flow.ui.inspector.operators;

import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.PropertyTab;
import edu.brandeis.flow.ui.operator.UIOperator;


public class TwitterInspector extends Inspector {

	public TwitterInspector(UIOperator op) {
		super(op);
		TwitterIN in = (TwitterIN) this.op.getJSONOp();
        PropertyTab properties = new TwitterPropertyTab(in);
        this.tabs.setProperties(properties);
        this.tabs.addTab(tabs.properties, "Properties");
        this.tabs.addTab(tabs.connect, "Connect");
        this.tabs.addTab(tabs.iotab, "Live View");
	}

}
