package edu.brandeis.flow.ui.operator.join;

import com.vaadin.server.ThemeResource;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIJoinFactory extends UIOperatorFactory {
	
	public UIJoinFactory(){
		super("Join", "join.svg");
	}

	@Override
	public UIOperator makeUIOperator() {
		return new UIJoin();
	}

	@Override
	public String getType() {
		
		return "Join";
	}

}
