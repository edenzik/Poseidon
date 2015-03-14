package edu.brandeis.flow.ui.inspector;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class InspectorTabs extends VerticalLayout {
	
	public InspectorTabs(String name) {
		if (name.equals("IO")) {
			Panel dataSource = new Panel("Data Source");
			dataSource.setContent(new Label("Getting data from Twitter"));
			dataSource.setHeight(4, Unit.CM);
			
			Panel in = new Panel("In Stream");
			in.setContent(new Label("Here prints the input stream"));
			in.setHeight(8, Unit.CM);
			
			Panel out = new Panel("Out Stream");
			out.setContent(new Label("Here prints the output stream"));
			out.setHeight(8, Unit.CM);
			
			this.addComponent(dataSource);
			this.addComponent(in);
			this.addComponent(out);
		}else {
			Panel currList = new Panel("Current Operators");
			currList.setContent(new Label("In\nUnion\nFilter\n...", ContentMode.PREFORMATTED));
			currList.setHeight(10, Unit.CM);
			this.addComponent(currList);
		}
	}
//	private final Button propertiesButton;
//	private final Button IOButton;
//	private final Button functionButton;
//	private final Button liveButton;
//	
//	public InspectorTabs(){
//		propertiesButton = new Button("Properties");
//		IOButton = new Button("I/O");
//		functionButton = new Button("Function");
//		liveButton = new Button("Live");
//		this.addComponent(propertiesButton);
//		this.addComponent(IOButton);
//		this.addComponent(functionButton);
//		this.addComponent(liveButton);
//	}
	
	

}
