package edu.brandeis.flow.ui.inspector.operators;


import java.util.ArrayList;
import java.util.Arrays;

import com.google.common.collect.Lists;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import edu.brandeis.flow.core.operator.in.twitter.TwitterIN;
import edu.brandeis.flow.ui.inspector.PropertyTab;

public class TwitterPropertyTab extends PropertyTab {
	Button searchButton;
	TextArea textarea;
	public TwitterPropertyTab(TwitterIN in) {
		
		Button searchButton = new Button("Search");
		
		TextArea textarea = new TextArea();
		
		textarea.setHeight(8, Unit.CM);
		textarea.setWidth(80, Unit.PERCENTAGE);
		addComponent(textarea);
		addComponent(searchButton);
		setComponentAlignment(textarea, Alignment.MIDDLE_CENTER);
		setComponentAlignment(searchButton, Alignment.MIDDLE_CENTER);
		this.setSpacing(true);
		
		searchButton.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	String[] strarr = textarea.getValue().split("\\s+");
		    	ArrayList<String> termsList = new ArrayList(Arrays.asList(strarr));
		    	in.filterEndpoint(termsList);
		    }
		});
	}

}
