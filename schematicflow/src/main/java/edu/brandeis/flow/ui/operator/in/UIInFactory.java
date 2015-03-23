package edu.brandeis.flow.ui.operator.in;

import com.vaadin.server.ThemeResource;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIInFactory extends UIOperatorFactory {
	
	public UIInFactory(){
		super("Filter", new ThemeResource("../runo/icons/64/arrow-down.png"));
	}

	@Override
	public UIOperator makeUIOperator() {
		return new UIIn();
	}

}
