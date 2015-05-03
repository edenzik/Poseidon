package edu.brandeis.flow.ui.inspector;

import org.vaadin.addons.d3Gauge.Gauge;
import org.vaadin.addons.d3Gauge.GaugeConfig;
import org.vaadin.addons.d3Gauge.GaugeStyle;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.ui.inspector.io.table.LiveViewTable;
import edu.brandeis.flow.ui.operator.UIOperator;

public class IOTab extends VerticalLayout {

	public IOTab(UIOperator op) {
		
		
		GaugeConfig config = new GaugeConfig(); 
		config.setStyle(GaugeStyle.STYLE_DARK.toString());
		config.setMax(30000);
		Gauge gauge = new Gauge("Content",200,200, config);
		UI ui = UI.getCurrent();
		Runnable s = new Runnable() {
		    @Override
		    public void run() {
		    	while (true){
		    		int v = gauge.getValue();
		    		int newVal = op.operator.buffer.size();
		    		if (v!= newVal) {
		    			gauge.setValue(newVal);
		    			ui.push();
		    		}
		    		
		        try {
					Thread.sleep(1000);
				} catch (Error e) {
					e.printStackTrace();
				} catch (Exception e) {

				}
		    	}
		    }
		};
		
		new Thread(s).start();
		addComponent(gauge); 
		//gauge.setWidth(10, Unit.CM);
		//gauge.setHeight(10, Unit.CM);
		this.setComponentAlignment(gauge, Alignment.BOTTOM_CENTER);
		//gauge.setHeight(50, Unit.PERCENTAGE);
		

	}

	// private final Button propertiesButton;
	// private final Button IOButton;
	// private final Button functionButton;
	// private final Button liveButton;
	//
	// public InspectorTabs(){
	// propertiesButton = new Button("Properties");
	// IOButton = new Button("I/O");
	// functionButton = new Button("Function");
	// liveButton = new Button("Live");
	// this.addComponent(propertiesButton);
	// this.addComponent(IOButton);
	// this.addComponent(functionButton);
	// this.addComponent(liveButton);
	// }

}
