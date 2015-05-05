package edu.brandeis.flow.ui.inspector.operators;

import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.PropertyTab;
import edu.brandeis.flow.ui.operator.UIOperator;


public class TwitterInspector extends Inspector {

	public TwitterInspector(UIOperator op) {
		super(op);
		//TwitterIn in = (TwitterIn) this.op.getJSONOp();
		//PropertyTab properties = new InPropertyTab(in);
		//this.tabs.setProperties(properties);
		this.tabs.addTab(tabs.connect, "Connect");
		this.tabs.addTab(tabs.iotab, "Live View");
	}

}
