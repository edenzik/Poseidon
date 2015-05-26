package edu.brandeis.flow.ui.operator.in.twitter;

import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UITwitterInFactory extends UIOperatorFactory {

	public UITwitterInFactory() {
		super("Twitter", "twitter.svg");
	}

	@Override
	public UIOperator makeUIOperator(UIOperatorNetworkDiagram nd) throws Exception {
		return new UITwitterIn(nd);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Twitter";
	}

}
