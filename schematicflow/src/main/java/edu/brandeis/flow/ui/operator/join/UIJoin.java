package edu.brandeis.flow.ui.operator.join;

import edu.brandeis.flow.core.operator.join.Join;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIJoin extends UIOperator {

	protected UIJoin() {
		super(new Join(), "join.svg");
	}

	@Override
	protected Inspector makeInspector() {
		return new FilterInspector(this);
	}

}
