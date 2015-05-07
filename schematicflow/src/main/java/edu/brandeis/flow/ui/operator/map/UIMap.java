package edu.brandeis.flow.ui.operator.map;

import edu.brandeis.flow.core.operator.map.Map;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.inspector.operators.MapInspector;
import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIMap extends UIOperator {

	protected UIMap(UIOperatorNetworkDiagram nd) {
		super(new Map(), "map.svg", nd);
	}

	@Override
	protected Inspector makeInspector() {
		return new MapInspector(this);
	}
	
	@Override
	public String getOpName() {
		return "Map";
	}
	

}
