package edu.brandeis.flow.ui.operator.out;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIOutFactory extends UIOperatorFactory {

	public UIOutFactory() {
		super("Out", "out.svg");
	}

	@Override
	public UIOperator makeUIOperator() {
		return new UIOut();
	}

	@Override
	public String getType() {

		return "Out";
	}

}
