package edu.brandeis.flow.ui.operator.in;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIInFactory extends UIOperatorFactory {

	public UIInFactory() {
		super("In", "in.svg");
	}

	@Override
	public UIOperator makeUIOperator() throws JSONException, IOException {
		return new UIIn();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "In";
	}

}
