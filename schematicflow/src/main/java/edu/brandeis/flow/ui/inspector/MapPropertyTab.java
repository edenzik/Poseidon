package edu.brandeis.flow.ui.inspector;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

import edu.brandeis.flow.core.operator.map.Map;

public class MapPropertyTab extends PropertyTab {
	
	final Button button;
	final CheckBox timestamp;
	final TextField key;
	final TextField value;

	public MapPropertyTab(Map map) {
		timestamp = new CheckBox("Demo: ");
		//timestamp.addValueChangeListener(listener);
		key = new TextField("Key: ");
		value = new TextField("Value: ");
		button = new Button("Submit", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Object keyValue = key.getValue();
				String valueV = value.getValue();
				if(keyValue != null && valueV != null) {
					if (timestamp.getValue()) {
						map.setup("TS", "");
					}else {
						map.setup((String)keyValue, valueV);
					}
					new Thread(map).start();
				}
			}
		});
		
		addComponent(timestamp);
		addComponent(key);
		addComponent(value);
		
		addComponent(button);
		setComponentAlignment(timestamp, Alignment.TOP_LEFT);
		setComponentAlignment(key, Alignment.TOP_CENTER);
		setComponentAlignment(value, Alignment.TOP_CENTER);
		setComponentAlignment(button, Alignment.TOP_CENTER);

	}

}
