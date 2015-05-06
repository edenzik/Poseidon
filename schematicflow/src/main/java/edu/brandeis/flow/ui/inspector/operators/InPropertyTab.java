package edu.brandeis.flow.ui.inspector.operators;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.vaadin.teemu.jsoncontainer.JsonContainer;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;

import edu.brandeis.flow.core.demo.OperatorInTest;
import edu.brandeis.flow.core.operator.in.In;
import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;
import edu.brandeis.flow.ui.inspector.PropertyTab;

public class InPropertyTab extends PropertyTab {
	final ComboBox combobox;
	final TextField addName;
	final TextField addUrl;
	
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
		addName = new TextField("Add new sources here");
		addUrl = new TextField("Add new URL and press enter");
		
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
		
		
		addUrl.addValueChangeListener(new ValueChangeListener(){

			@Override
			public void valueChange(ValueChangeEvent event) {
				combobox.addItem(new InType(addName.getValue(), event.getProperty().getValue().toString()));
				Notification.show("Source Added",
		                  "New source URL for " + addName.getValue() + " added.",
		                  Notification.Type.TRAY_NOTIFICATION);
			}
			
		});
		Component addBox = new HorizontalSplitPanel(addName,addUrl);
		addComponent(addBox);
		setComponentAlignment(combobox, Alignment.TOP_CENTER);
		setComponentAlignment(addBox, Alignment.TOP_CENTER);
		this.setSpacing(true);
		
	}
	

}
