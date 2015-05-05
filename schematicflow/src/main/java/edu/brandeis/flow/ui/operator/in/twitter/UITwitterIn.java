package edu.brandeis.flow.ui.operator.in.twitter;

import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.inspector.operators.TwitterInspector;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UITwitterIn extends UIOperator {

	protected UITwitterIn(UIOperatorNetworkDiagram nd) throws Exception {
		super(new TwitterIN(), "twitter.svg", nd);
	}

	@Override
	protected Inspector makeInspector() {
		return new TwitterInspector(this);
	}
	
	@Override
	public String getOpName() {
		return "Twitter";
	}
	

}
