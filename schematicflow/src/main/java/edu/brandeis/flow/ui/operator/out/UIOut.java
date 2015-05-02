package edu.brandeis.flow.ui.operator.out;

import edu.brandeis.flow.core.operator.out.Out;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIOut extends UIOperator {

	protected UIOut() {
		super(new Out(), "out.svg");
	}

	@Override
	protected Inspector makeInspector() {
		return new FilterInspector(this);
	}

}
