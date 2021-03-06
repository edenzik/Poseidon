package edu.brandeis.flow.ui.operator.out;

import edu.brandeis.flow.core.operator.out.Out;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.inspector.operators.OutInspector;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIOut extends UIOperator {

	protected UIOut(UIOperatorNetworkDiagram nd) {
		super(new Out(), "out.svg", nd);
	}

	@Override
	protected Inspector makeInspector() {
		return new OutInspector(this);
	}
	
	@Override
	public String getOpName() {
		return "Out";
	}
	

}
