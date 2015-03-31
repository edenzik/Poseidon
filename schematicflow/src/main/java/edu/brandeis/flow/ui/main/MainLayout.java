package edu.brandeis.flow.ui.main;

import java.util.HashSet;
import java.util.Set;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.InspectorSidebar;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.sidebar.OperatorFactoryDescriptionSidebar;
import edu.brandeis.ui.storyboard.StoryBoard;

public class MainLayout extends HorizontalLayout {
	private static final long serialVersionUID = 3402991554451061045L;

	public MainLayout(){
		setSizeFull();
		UIOperator.ic = new InspectorCallback(this);
		Component story = new StoryBoard();
		Component sidebar = new OperatorFactoryDescriptionSidebar();
		
		addComponent(sidebar);
		this.setExpandRatio(sidebar, (float) 15.0);

		addComponent(story);
		this.setExpandRatio(story, (float) 55.0);
		

	}
	
	public class InspectorCallback{
		Inspector inspector = null;
		boolean enabled = true;
		final HorizontalLayout layout;
		
		InspectorCallback(HorizontalLayout layout){this.layout = layout;}
		public void setInspector(Inspector inspector){
			if (!enabled) return;
			if (this.inspector!=null) layout.removeComponent(this.inspector);
			this.inspector = inspector;
			layout.addComponent(inspector);
			layout.setExpandRatio(inspector, (float) 20.0);
		}
	}
}
