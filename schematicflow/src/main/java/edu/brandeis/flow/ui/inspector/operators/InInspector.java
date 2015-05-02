package edu.brandeis.flow.ui.inspector.operators;

import edu.brandeis.flow.ui.inspector.FilterPropertyTab;
import edu.brandeis.flow.ui.inspector.InPropertyTab;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.PropertyTab;
import edu.brandeis.flow.ui.operator.UIOperator;

public class InInspector extends Inspector {
	public InInspector(UIOperator op) {
		super(op);
		PropertyTab properties = new InPropertyTab();
		this.tabs.setProperties(properties);
		this.tabs.setTabs();
	}
	
	
}
