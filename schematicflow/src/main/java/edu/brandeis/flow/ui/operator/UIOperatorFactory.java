package edu.brandeis.flow.ui.operator;

import java.io.IOException;

import org.json.JSONException;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public abstract class UIOperatorFactory extends Image{
	public UIOperatorFactory(String string, String image) {
		super(string, new ThemeResource("img/"+image));
	}

	public abstract UIOperator makeUIOperator() throws JSONException, IOException;
}
