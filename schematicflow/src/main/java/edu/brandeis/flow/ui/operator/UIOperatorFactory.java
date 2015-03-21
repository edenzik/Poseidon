package edu.brandeis.flow.ui.operator;

import com.vaadin.server.Resource;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public abstract class UIOperatorFactory extends Image{
	public UIOperatorFactory(String string, Resource resource) {super(string, resource);}

	public abstract UIOperator makeUIOperator();
}
