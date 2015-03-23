package edu.brandeis.flow.ui.operator.in;

import edu.brandeis.flow.core.operator.Filter;
import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIIn extends UIOperator {

	protected UIIn() {
		super(new Filter());
		setImage("./VAADIN/images/filter.svg");
	}

}
