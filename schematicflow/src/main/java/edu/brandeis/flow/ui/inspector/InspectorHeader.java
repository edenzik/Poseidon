package edu.brandeis.flow.ui.inspector;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

public class InspectorHeader extends VerticalLayout {
	final TextField name;
	final TextArea desc;
	
	public InspectorHeader (String opName) {
		name = new TextField("Name");
		
		desc = new TextArea("Description");
//		Button apply = new Button("Apply");
		
		Label title = new Label("<h2>" + opName + "</h2>");
		title.setHeight("10%");
		title.setContentMode(ContentMode.HTML);
		
		
		//title.setSizeUndefined();
		this.setSpacing(false);
	
//		Image image = new Image(null, new ThemeResource("../images/" + opName+ ".svg"));
		name.setWidth("95%");
		desc.setWidth("95%");
		desc.setHeight("150%");
		
		this.getMargin().setMargins(true, true, false, true);
		addComponent(title);
//		addComponent(image);
		addComponent(name);
		addComponent(desc);
		this.setComponentAlignment(title, Alignment.TOP_CENTER);
		
//		setComponentAlignment(title, Alignment.TOP_CENTER);
//		setComponentAlignment(image, Alignment.TOP_LEFT);
//		setComponentAlignment(name, Alignment.MIDDLE_CENTER);
//		setComponentAlignment(desc, Alignment.BOTTOM_CENTER);
//		this.setSpacing(true);
		
		
	}
}

