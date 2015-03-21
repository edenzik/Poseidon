package edu.brandeis.flow.ui.main;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.InspectorSidebar;
import edu.brandeis.flow.ui.operator.StateSidebar;
import edu.brandeis.ui.storyboard.StoryBoard;

public class MainLayout extends HorizontalLayout {
	private static final long serialVersionUID = 3402991554451061045L;

	public MainLayout(){
		setSizeFull();
		
		Component inspector = new InspectorSidebar();
		Component story = new StoryBoard(new InspectorCallback(this));
		Component sidebar = new StateSidebar();
		
		addComponent(sidebar);
		this.setExpandRatio(sidebar, (float) 15.0);

		addComponent(story);
		this.setExpandRatio(story, (float) 55.0);
		

	}
	
	public class InspectorCallback{
		Inspector inspector = null;
		final HorizontalLayout layout;
		
		InspectorCallback(HorizontalLayout layout){this.layout = layout;}
		public void setInspector(Inspector inspector){
			if (this.inspector!=null) layout.removeComponent(this.inspector);
			this.inspector = inspector;
			layout.addComponent(inspector);
			layout.setExpandRatio(inspector, (float) 20.0);
		}
	}
}
