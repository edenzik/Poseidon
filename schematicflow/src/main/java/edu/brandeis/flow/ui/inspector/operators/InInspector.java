package edu.brandeis.flow.ui.inspector.operators;

import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.ui.inspector.FilterPropertyTab;
import edu.brandeis.flow.ui.inspector.InPropertyTab;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.PropertyTab;
import edu.brandeis.flow.ui.operator.UIOperator;

public class InInspector extends Inspector {
	public InInspector(UIOperator op) {
		super(op);
		In in = (In) this.op.getJSONOp();
		PropertyTab properties = new InPropertyTab(in);
		this.tabs.setProperties(properties);
		this.tabs.setTabs();
	}
	
	
}
