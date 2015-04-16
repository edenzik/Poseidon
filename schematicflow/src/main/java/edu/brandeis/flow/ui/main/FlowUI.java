package edu.brandeis.flow.ui.main;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import edu.brandeis.flow.core.operator.JSONOperator;
import edu.brandeis.flow.ui.inspector.Inspector;
import edu.brandeis.flow.ui.storyboard.Mode;

/**
 * @author edenzik Main UI class which receives a stream of data from back end
 *         and displays it
 *
 */
@Push()
@SuppressWarnings("serial")
@Theme("valo")
public class FlowUI extends UI {
	public MainLayout layout;
	
	

	@WebServlet(value = { "/*" }, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = true, ui = FlowUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		layout = new MainLayout();
		setContent(layout);
	}
	
	public void removeInspector(){
		layout.removeInspector();
	}
	

}