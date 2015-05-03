package edu.brandeis.flow.ui.inspector.operators;

import edu.brandeis.flow.core.operator.filter.Filter;
import edu.brandeis.flow.ui.inspector.FilterPropertyTab;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.PropertyTab;
import edu.brandeis.flow.ui.operator.UIOperator;


public class OutInspector extends Inspector {

		public OutInspector(UIOperator op) {
			super(op);
			PropertyTab properties = new PropertyTab();
			this.tabs.setProperties(properties);
			this.tabs.setTabs();
			
		}

}
