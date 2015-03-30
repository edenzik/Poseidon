package edu.brandeis.flow.ui.operator.filter;

import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;

import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIFilterFactory extends UIOperatorFactory {
	
	public UIFilterFactory(){
		super("Filter", "filter.svg");
		
	}

	@Override
	public UIOperator makeUIOperator() {
		return new UIFilter();
	}

}
