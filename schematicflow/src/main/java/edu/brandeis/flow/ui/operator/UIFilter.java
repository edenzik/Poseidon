package edu.brandeis.flow.ui.operator;

import edu.brandeis.flow.core.operator.Filter;
import edu.brandeis.flow.core.operator.JSONOperator;

final class UIFilter extends UIOperator {

	protected UIFilter() {
		super(new Filter(), "Filter", "A filter operator filters on an attribute.");
		this.setImage("./VAADIN/images/filter.svg");
	}

	@Override
	public UIOperator copy() {
		return new UIFilter();
	}

}
