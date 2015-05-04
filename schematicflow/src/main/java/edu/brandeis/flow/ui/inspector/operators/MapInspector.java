package edu.brandeis.flow.ui.inspector.operators;

import edu.brandeis.flow.core.operator.filter.Filter;
import edu.brandeis.flow.core.operator.map.Map;
import edu.brandeis.flow.ui.inspector.FilterPropertyTab;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.inspector.MapPropertyTab;
import edu.brandeis.flow.ui.inspector.PropertyTab;
import edu.brandeis.flow.ui.operator.UIOperator;

public class MapInspector extends Inspector {

	public MapInspector(UIOperator op) {
		super(op);
		Map map = (Map) this.op.getJSONOp();
		PropertyTab properties = new MapPropertyTab(map);
		this.tabs.setProperties(properties);
		this.tabs.setTabs();	
	}

}
