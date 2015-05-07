package edu.brandeis.flow.ui.operator.map;

import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIMapFactory extends UIOperatorFactory {

	public UIMapFactory() {
		super("Map", "map.svg");
	}

	@Override
	public UIOperator makeUIOperator(UIOperatorNetworkDiagram nd) {
		return new UIMap(nd);
	}

	@Override
	public String getType() {

		return "Map";
	}

}
