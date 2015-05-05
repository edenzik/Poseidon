package edu.brandeis.flow.ui.operator.filter;

import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIFilterFactory extends UIOperatorFactory {

	public UIFilterFactory() {
		super("Filter", "filter.svg");

	}

	@Override
	public UIOperator makeUIOperator(UIOperatorNetworkDiagram nd) {
		return new UIFilter(nd);
	}

	@Override
	public String getType() {

		return "Filter";
	}

}
