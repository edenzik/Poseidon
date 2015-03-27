package edu.brandeis.flow.ui.operator.in.twitter;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.core.operator.Filter;
import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.core.operator.TwitterIN;
import edu.brandeis.flow.ui.inspector.operators.FilterInspector;
import edu.brandeis.flow.ui.operator.UIOperator;

final class UITwitterIn extends UIOperator {

	protected UITwitterIn() throws JSONException, IOException {
		super(new TwitterIN());
		setImage("./VAADIN/images/twitter.svg");
	}

}
