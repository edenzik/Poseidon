package edu.brandeis.flow.ui.inspector;

import org.json.JSONObject;
import org.vaadin.addons.d3Gauge.Gauge;
import org.vaadin.addons.d3Gauge.GaugeConfig;
import org.vaadin.addons.d3Gauge.GaugeStyle;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import edu.brandeis.flow.ui.inspector.io.table.LiveViewTable;
import edu.brandeis.flow.ui.operator.UIOperator;

public class IOTab extends VerticalLayout {

	public IOTab(UIOperator op) {
		
		
		GaugeConfig config = new GaugeConfig(); 
		//config.setStyle(GaugeStyle.STYLE_DARK.toString());
		config.setMax(100);
		
		Button sample = new Button("Sample Data");
		sample.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				JSONObject top = op.operator.buffer.peek();
				if (top==null) return;
				Notification.show("Sample",
		                  top.toString(),
		                  Notification.Type.HUMANIZED_MESSAGE);
				
				
			}
		});
		Gauge gauge = new Gauge("Rate",0,300, config);
		UI ui = UI.getCurrent();
		Runnable s = new Runnable() {
		    @Override
		    public void run() {
		    	int val = 0;
		    	while (true){
		    		val = op.operator.getRate();
		    		if (gauge.getValue()!=val){
		    			gauge.setValue(val);
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
		addComponent(sample);
		 
		this.setMargin(true);
		this.setSpacing(true);

		this.setSizeFull();
		this.setComponentAlignment(sample, Alignment.BOTTOM_CENTER);
		this.setComponentAlignment(gauge, Alignment.MIDDLE_CENTER);
		

	}


}
