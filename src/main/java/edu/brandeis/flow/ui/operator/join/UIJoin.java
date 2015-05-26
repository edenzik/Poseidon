package edu.brandeis.flow.ui.operator.join;

import edu.brandeis.flow.core.operator.join.Join;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.inspector.operators.JoinInspector;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIJoin extends UIOperator {

	protected UIJoin(UIOperatorNetworkDiagram nd) {
		super(new Join(), "join.svg", nd);
	}

	@Override
	protected Inspector makeInspector() {
		return new JoinInspector(this);
	}
	
	@Override
	public String getOpName() {
		return "Join";
	}
	

}
