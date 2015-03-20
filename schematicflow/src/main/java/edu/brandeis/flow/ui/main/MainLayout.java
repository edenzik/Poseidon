package edu.brandeis.flow.ui.main;

import com.vaadin.ui.Component;

import com.vaadin.ui.HorizontalLayout;

import edu.brandeis.flow.ui.inspector.InspectorSidebar;
import edu.brandeis.flow.ui.operator.StateSidebar;
import edu.brandeis.ui.storyboard.StoryBoard;

public class MainLayout extends HorizontalLayout {
	private static final long serialVersionUID = 3402991554451061045L;

	public MainLayout(){
		setSizeFull();
		
		Component sidebar = new StateSidebar();
		addComponent(sidebar);
		this.setExpandRatio(sidebar, (float) 15.0);
		
		Component story = new StoryBoard();
		addComponent(story);
		this.setExpandRatio(story, (float) 55.0);
		
		Component inspector = new InspectorSidebar();
		addComponent(inspector);
		this.setExpandRatio(inspector, (float) 20.0);

	}
}
