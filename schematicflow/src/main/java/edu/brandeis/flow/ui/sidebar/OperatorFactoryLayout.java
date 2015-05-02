package edu.brandeis.flow.ui.sidebar;

import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.GridLayout;

import edu.brandeis.flow.ui.operator.UIOperatorFactory;
import edu.brandeis.flow.ui.operator.filter.UIFilterFactory;
import edu.brandeis.flow.ui.operator.in.UIInFactory;
import edu.brandeis.flow.ui.operator.in.twitter.UITwitterInFactory;
import edu.brandeis.flow.ui.operator.join.UIJoinFactory;
import edu.brandeis.flow.ui.operator.map.UIMapFactory;
import edu.brandeis.flow.ui.operator.out.UIOutFactory;

public class OperatorFactoryLayout extends GridLayout {
	private final int numCols = 2;
	private final UIOperatorFactory uiOpFactories[] = new UIOperatorFactory[] {
			new UIFilterFactory(), new UIInFactory("http://developer.mbta.com/Data/Red.json",3000), new UIOutFactory(),
			new UITwitterInFactory(), new UIMapFactory(), new UIJoinFactory() };

	//new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory(),new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() ,new UIJoinFactory() };

	public OperatorFactoryLayout() {
		setSizeFull();
		setColumns(numCols);
		this.setMargin(true);
		this.setSpacing(true);
		for (UIOperatorFactory uiOp : uiOpFactories) {
			uiOp.setWidth(this.getWidth() / 2, this.getWidthUnits());
			uiOp.setHeight(this.getHeight() / 2, this.getHeightUnits());
			DragAndDropWrapper transferable = new DragAndDropWrapper(uiOp);
			transferable.setSizeUndefined();
			transferable.setDragStartMode(DragStartMode.WRAPPER);
			transferable.setData(uiOp);
			addComponent(transferable);
		}

	}

}
