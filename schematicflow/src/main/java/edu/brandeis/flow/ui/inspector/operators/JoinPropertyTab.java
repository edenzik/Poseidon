package edu.brandeis.flow.ui.inspector.operators;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

import edu.brandeis.flow.core.operator.join.Join;
import edu.brandeis.flow.ui.inspector.PropertyTab;

public class JoinPropertyTab extends PropertyTab{
	TextField key;
	Button button;
	public JoinPropertyTab(Join join)   {
		// TODO Auto-generated constructor stub
		key = new TextField("Key: ");
		
		button = new Button("Submit", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				join.setup(key.getValue());
			}
		});
		addComponent(key);
		addComponent(button);
		setComponentAlignment(button, Alignment.TOP_CENTER);
		setComponentAlignment(key, Alignment.TOP_CENTER);
	}

}
