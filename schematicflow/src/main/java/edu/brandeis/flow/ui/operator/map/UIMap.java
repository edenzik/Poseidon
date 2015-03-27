package edu.brandeis.flow.ui.operator.map;

import edu.brandeis.flow.core.operator.Filter;
import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.operator.Map;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIMap extends UIOperator {

	protected UIMap() {
		super(new Map());
		setImage("./VAADIN/images/map.svg");
	}

}