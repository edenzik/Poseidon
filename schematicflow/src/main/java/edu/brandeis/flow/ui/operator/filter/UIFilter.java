package edu.brandeis.flow.ui.operator.filter;

import edu.brandeis.flow.core.operator.Filter;
import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIFilter extends UIOperator {

	protected UIFilter() {
		super(new Filter(), "filter.svg");
	}

}
