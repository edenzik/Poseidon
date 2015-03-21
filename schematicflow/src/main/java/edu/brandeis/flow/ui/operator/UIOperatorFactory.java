package edu.brandeis.flow.ui.operator;

import com.vaadin.ui.Label;

public abstract class UIOperatorFactory extends Label{
	public UIOperatorFactory(String string) {super(string);}

	public abstract UIOperator makeUIOperator();
}
