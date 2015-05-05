package edu.brandeis.flow.ui.operator.in;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.InInspector;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIIn extends UIOperator {

	protected UIIn(UIOperatorNetworkDiagram nd) throws JSONException, IOException {
		super(new In(), "in.svg", nd);
	}

	@Override
	protected Inspector makeInspector() {
		return new InInspector(this);
	}
	
	@Override
	public String getOpName() {
		return "In";
	}
	

}
