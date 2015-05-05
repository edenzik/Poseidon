package edu.brandeis.flow.ui.inspector.operators;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;

import edu.brandeis.flow.core.demo.OperatorInTest;
import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;
import edu.brandeis.flow.ui.inspector.PropertyTab;

public class InPropertyTab extends PropertyTab {
	final ComboBox combobox;
	
	class InType{
		final String url;
		final String name;
		InType(String name, String url){
			this.name = name;
			this.url = url;
		}
		@Override
		public String toString() {
			return name;
		}
		
		
		
	}
	
	public InPropertyTab(In in) {

		
		combobox = new ComboBox("Select API");
		combobox.setWidth("90%");
		combobox.setInvalidAllowed(false);
        combobox.setNullSelectionAllowed(false);
		combobox.addItem(new InType("MBTA Red Line","http://developer.mbta.com/Data/Red.json"));
		combobox.addItem(new InType("MBTA Orange Line","http://developer.mbta.com/Data/Orange.json"));
		combobox.addValueChangeListener(new ValueChangeListener(){

			@Override
			public void valueChange(ValueChangeEvent event) {
				System.out.println(event.getProperty().getValue());
				in.setURL(((InType) event.getProperty().getValue()).url);
				
			}
			
		});

		addComponent(combobox);
		setComponentAlignment(combobox, Alignment.TOP_CENTER);
		this.setSpacing(true);
		
	}

}
