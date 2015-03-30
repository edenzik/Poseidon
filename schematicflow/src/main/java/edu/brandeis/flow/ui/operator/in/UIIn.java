package edu.brandeis.flow.ui.operator.in;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.core.operator.Filter;
import edu.brandeis.flow.core.operator.In;
import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UIIn extends UIOperator {

	protected UIIn() throws JSONException, IOException {
		super(new In(), "in.svg");
	}

}
