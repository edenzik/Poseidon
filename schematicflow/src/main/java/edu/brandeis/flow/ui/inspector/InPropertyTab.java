package edu.brandeis.flow.ui.inspector;

import java.io.IOException;

import org.json.JSONException;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;

import edu.brandeis.flow.core.demo.OperatorInTest;
import edu.brandeis.flow.core.operator.in.In;

public class InPropertyTab extends PropertyTab {
	final ComboBox combobox;
	
	
	public InPropertyTab() {
		combobox = new ComboBox("Select API");
		combobox.setWidth("90%");
		combobox.setInvalidAllowed(false);
        combobox.setNullSelectionAllowed(false);
		combobox.addItem("MBTA");
		combobox.addItem("Twitter");
		addComponent(combobox);
		setComponentAlignment(combobox, Alignment.TOP_CENTER);
		this.setSpacing(true);
	}

}
