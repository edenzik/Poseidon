package edu.brandeis.flow.ui.operator;

final class UIFilterFactory extends UIOperatorFactory {
	
	public UIFilterFactory(){super("Filter");}

	@Override
	public UIOperator makeUIOperator() {
		return new UIFilter();
	}

}
