package edu.brandeis.flow.ui.operator.map;

import edu.brandeis.flow.core.operator.map.Map;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIMap extends UIOperator {

	protected UIMap() {
		super(new Map(), "map.svg", new FilterInspector());
	}

	@Override
	protected Inspector makeInspector() {
		return new FilterInspector();
	}

}
