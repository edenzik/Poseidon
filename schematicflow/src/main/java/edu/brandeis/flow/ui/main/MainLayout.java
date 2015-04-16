package edu.brandeis.flow.ui.main;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.sidebar.OperatorFactoryDescriptionSidebar;
import edu.brandeis.flow.ui.storyboard.StoryBoard;
import edu.brandeis.flow.ui.network.*;

public class MainLayout extends HorizontalLayout {
	private static final long serialVersionUID = 3402991554451061045L;
	Inspector inspector;
	public final StoryBoard storyBoard;
	final OperatorFactoryDescriptionSidebar sidebar;

	public MainLayout(){
		setSizeFull();
		storyBoard = new StoryBoard();
		sidebar = new OperatorFactoryDescriptionSidebar();
		UIOperator.ic = new InspectorCallback(this);
		
		addComponent(sidebar);
		this.setExpandRatio(sidebar, (float) 12.0);

		addComponent(storyBoard);
		this.setExpandRatio(storyBoard, (float) 48.0);
		

	}
	
	protected void removeInspector(){
		if (inspector!=null) removeComponent(inspector);
	}
	
	public void setInspector(Inspector inspector){
		removeInspector();
		addInspector(inspector);
	}
	
	protected void addInspector(Inspector inspector){
		this.inspector = inspector;
		addComponent(inspector);
		setExpandRatio(inspector, (float) 20.0);
		storyBoard.markAsDirtyRecursive();
		//getUI().push();
	}
	
	public class InspectorCallback{
		Inspector inspector = null;
		public UIOperatorNetworkDiagram network = null;
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
