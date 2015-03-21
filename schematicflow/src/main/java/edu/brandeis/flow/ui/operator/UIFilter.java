package edu.brandeis.flow.ui.operator;

import edu.brandeis.flow.core.operator.Filter;
import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;

final class UIFilter extends UIOperator {

	protected UIFilter() {
		super(new Filter());
		setImage("./VAADIN/images/filter.svg");
	}

}
