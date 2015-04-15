package edu.brandeis.flow.ui.operator.in;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIIn extends UIOperator {

	protected UIIn() throws JSONException, IOException {
		super(new In(), "in.svg", new FilterInspector());
	}

	@Override
	protected Inspector makeInspector() {
		return new FilterInspector();
	}

}
