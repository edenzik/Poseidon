package edu.brandeis.flow.ui.inspector.operators;

import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.core.operator.join.Join;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.PropertyTab;
import edu.brandeis.flow.ui.operator.UIOperator;

public class JoinInspector extends Inspector {

	public JoinInspector(UIOperator op) {
		super(op);
		this.tabs.setTabs();
	}

}
