package edu.brandeis.flow.ui.operator;

import java.io.IOException;

import org.json.JSONException;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;

import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;

public abstract class UIOperatorFactory extends Image {
	public UIOperatorFactory(String string, String image) {
		super(string, new ThemeResource("img/" + image));
	}

	public abstract String getType();

	public abstract UIOperator makeUIOperator(UIOperatorNetworkDiagram nd) throws JSONException,
			IOException, Exception;
}
