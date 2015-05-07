package edu.brandeis.flow.ui.operator.join;

import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIJoinFactory extends UIOperatorFactory {

	public UIJoinFactory() {
		super("Join", "join.svg");
	}

	@Override
	public UIOperator makeUIOperator(UIOperatorNetworkDiagram nd) {
		return new UIJoin(nd);
	}

	@Override
	public String getType() {

		return "Join";
	}

}
