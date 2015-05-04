package edu.brandeis.flow.ui.inspector.operators;

import java.io.IOException;

import org.json.JSONException;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
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
	final Button button;
	
	public InPropertyTab(In in) {
		
		combobox = new ComboBox("Select API");
		combobox.setWidth("90%");
		combobox.setInvalidAllowed(false);
        combobox.setNullSelectionAllowed(false);
        combobox.addItem("Dummy");
		combobox.addItem("MBTA Red Line");
		combobox.addItem("MBTA Orange Line");
		combobox.addItem("Twitter");
		button = new Button("Start", new Button.ClickListener() {
		    @Override
		    public void buttonClick(ClickEvent event) {
		    	if (combobox.getValue().equals("Dummy")) {
		        	try {
						in.startRequest();
						new Thread(in).start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		    	} else if (combobox.getValue().equals("MBTA Red Line")) {
		        	try {
						in.setURL("http://developer.mbta.com/Data/Red.json",6000);
						in.startRequest();
						new Thread(in).start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        } else if (combobox.getValue().equals("MBTA Orange Line")) {
		        	try {
						in.setURL("http://developer.mbta.com/Data/Orange.json",5000);
						in.startRequest();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        } else if (combobox.getValue().equals("Twitter")) {
		        	try {
		        		TwitterIN twitterIn = new TwitterIN();
						twitterIn.startRequest();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    } 
		  });
		addComponent(combobox);
		addComponent(button);
		setComponentAlignment(combobox, Alignment.TOP_CENTER);
		this.setSpacing(true);
		
	}

}
