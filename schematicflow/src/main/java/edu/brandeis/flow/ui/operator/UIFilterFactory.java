package edu.brandeis.flow.ui.operator;

import com.vaadin.server.ThemeResource;

final class UIFilterFactory extends UIOperatorFactory {
	
	public UIFilterFactory(){
		super("Filter", new ThemeResource("../runo/icons/64/arrow-down.png"));
	}

	@Override
	public UIOperator makeUIOperator() {
		return new UIFilter();
	}

}
