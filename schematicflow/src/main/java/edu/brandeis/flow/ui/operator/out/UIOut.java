package edu.brandeis.flow.ui.operator.out;

import edu.brandeis.flow.core.operator.Filter;
import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.operator.Map;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIOut extends UIOperator {

	protected UIOut() {
		super(new Map(), "out.svg");
	}

}
