package edu.brandeis.ui.storyboard;

import com.vaadin.ui.Panel;

import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagramDragAndDrop;

public class StoryBoard extends Panel {
	public StoryBoard() {
		setContent(new UIOperatorNetworkDiagramDragAndDrop());
		setSizeFull();	
	}
}
