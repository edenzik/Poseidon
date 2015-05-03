package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

import edu.brandeis.flow.core.operator.filter.Filter;

public class FilterPropertyTab extends PropertyTab {
//	final TextField key;
//	final TextField term;
	final Button button;
	final CheckBox numerical;
	final CheckBox regex;
	final TextField key;
	final ComboBox combobox;
	final TextField criterion;
	
	public FilterPropertyTab(Filter filter) {
		key = new TextField("Key");
		criterion = new TextField("Criterion");
		combobox = new ComboBox("Relational Operator");
		regex = new CheckBox("Regular Expression");
		numerical = new CheckBox("Numerical");
		regex.setValue(true);

		regex.addValueChangeListener(event -> // Java 8
		    numerical.setValue(! regex.getValue()));
		numerical.addValueChangeListener(event -> // Java 8
		    regex.setValue(! numerical.getValue()));
		
		combobox.addItem("=");
		combobox.addItem("<");
		combobox.addItem(">");
		
		button = new Button("Submit", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
					if (numerical.getValue())	{ //if use numerical model
						filter.setup(key.getValue(),criterion.getValue(),"numerical",combobox.getValue().toString());
					}else {
						System.out.println(filter.getKey());

						filter.setup(key.getValue(),criterion.getValue(),"regex","");
						
						System.out.println(filter.getKey());

					}
					new Thread(filter).start();
			}
		});

		addComponent(regex);
		addComponent(numerical);
		addComponent(key);
		addComponent(combobox);
		addComponent(criterion);
		addComponent(button);
////		System.out.println("\n\n\n\n\n\n FOUND \n\n\n\n\n\n");
//		key = new TextField("Key");
//		term = new TextField("Term");
//		Button accept = new Button("Accept");
//
//		key.setWidth("90%");
//		term.setWidth("90%");
//
//		addComponent(key);
//		addComponent(term);
//		addComponent(accept);
//
//		setComponentAlignment(key, Alignment.TOP_CENTER);
//		setComponentAlignment(term, Alignment.TOP_CENTER);
//		setComponentAlignment(accept, Alignment.BOTTOM_CENTER);
//		this.setSpacing(true);
	}

}
