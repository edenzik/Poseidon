package edu.brandeis.flow.ui.operator.in.twitter;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UITwitterInFactory extends UIOperatorFactory {

	public UITwitterInFactory() {
		super("Twitter", "twitter.svg");
	}

	@Override
	public UIOperator makeUIOperator() throws Exception {
		return new UITwitterIn();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Twitter";
	}

}
