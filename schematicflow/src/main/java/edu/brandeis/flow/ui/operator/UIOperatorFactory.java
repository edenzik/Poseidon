package edu.brandeis.flow.ui.operator;

import java.io.IOException;

import org.json.JSONException;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;

public abstract class UIOperatorFactory extends Image {
	public UIOperatorFactory(String string, String image) {
		super(string, new ThemeResource("img/" + image));
	}

	public abstract String getType();

	public abstract UIOperator makeUIOperator() throws JSONException,
			IOException, Exception;
}
