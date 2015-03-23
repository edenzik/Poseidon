package edu.brandeis.flow.ui.operator.join;

import com.vaadin.server.ThemeResource;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIJoinFactory extends UIOperatorFactory {
	
	public UIJoinFactory(){
		super("Filter", new ThemeResource("../runo/icons/64/arrow-down.png"));
	}

	@Override
	public UIOperator makeUIOperator() {
		return new UIJoin();
	}

}
