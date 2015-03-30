package edu.brandeis.flow.ui.inspector;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class InspectorHeader extends VerticalLayout {
	final TextField name;
	final TextArea desc;
	
	public InspectorHeader () {
		name = new TextField("Name");
		desc = new TextArea("Description");
//		Button apply = new Button("Apply");
		
		Label title = new Label("<h2>Map</h2>");
		title.setContentMode(ContentMode.HTML);
	
	
		Image image = new Image(null, new ThemeResource("../runo/icons/64/arrow-down.png"));
		name.setWidth("95%");
		desc.setWidth("95%");
		
//		apply.setWidth("95%");
		
		addComponent(title);
		addComponent(image);
		addComponent(name);
		addComponent(desc);
//		addComponent(apply);
	
		
		setComponentAlignment(title, Alignment.TOP_CENTER);
		setComponentAlignment(image, Alignment.TOP_LEFT);
		setComponentAlignment(name, Alignment.TOP_CENTER);
		setComponentAlignment(desc, Alignment.TOP_CENTER);
//		setComponentAlignment(apply, Alignment.MIDDLE_CENTER);
		this.setSpacing(true);
		
		
	}
}
