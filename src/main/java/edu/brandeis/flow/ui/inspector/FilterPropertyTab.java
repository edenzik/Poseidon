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
	final CheckBox not;
	final TextField key;
	final ComboBox combobox;
	final TextField criterion;
	
	public FilterPropertyTab(Filter filter) {
		key = new TextField("Key");
		not = new CheckBox("NOT");
		not.setValue(false);
		criterion = new TextField("Criterion");
		combobox = new ComboBox("Relational Operator");
		regex = new CheckBox("Regular Expression");
		numerical = new CheckBox("Numerical");
		regex.setValue(true);

		regex.addValueChangeListener(event -> // Java 8
		    numerical.setValue(! regex.getValue()));
		numerical.addValueChangeListener(event -> // Java 8
		    regex.setValue(! numerical.getValue()));
//		not.addValueChangeListener(event -> not.setValue(!not.getValue()));
		
		combobox.addItem("=");
		combobox.addItem("<");
		combobox.addItem(">");
		
		button = new Button("Submit", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
					if (numerical.getValue())	{ //if use numerical model
						filter.setup(key.getValue(),criterion.getValue(),"numerical",combobox.getValue().toString(), not.getValue());
					}else {
						filter.setup(key.getValue(),criterion.getValue(),"regex","", not.getValue());
					}
					new Thread(filter).start();
			}
		});

		addComponent(regex);
		addComponent(numerical);
		addComponent(not);
		addComponent(key);
		addComponent(combobox);
		addComponent(criterion);
		addComponent(button);
		setComponentAlignment(not, Alignment.TOP_LEFT);
		setComponentAlignment(combobox, Alignment.TOP_CENTER);
		setComponentAlignment(regex, Alignment.TOP_LEFT);
		setComponentAlignment(key, Alignment.TOP_CENTER);
		setComponentAlignment(criterion, Alignment.TOP_CENTER);
		setComponentAlignment(numerical, Alignment.TOP_LEFT);
		setComponentAlignment(button, Alignment.TOP_CENTER);
		this.setSpacing(true);
	}

}
