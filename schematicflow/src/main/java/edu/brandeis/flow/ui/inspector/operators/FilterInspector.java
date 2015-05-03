package edu.brandeis.flow.ui.inspector.operators;

import edu.brandeis.flow.core.operator.filter.Filter;
import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.ui.inspector.FilterPropertyTab;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.PropertyTab;
import edu.brandeis.flow.ui.operator.UIOperator;

public final class FilterInspector extends Inspector {
	public FilterInspector(UIOperator op) {
		super(op);
		Filter filter = (Filter) this.op.getJSONOp();
		PropertyTab properties = new FilterPropertyTab(filter);
		this.tabs.setProperties(properties);
		this.tabs.setTabs();
		
	}

}
