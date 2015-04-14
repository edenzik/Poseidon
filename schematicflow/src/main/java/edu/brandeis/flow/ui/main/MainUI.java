package edu.brandeis.flow.ui.main;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * @author edenzik Main UI class which receives a stream of data from back end
 *         and displays it
 *
 */
@Push()
@SuppressWarnings("serial")
@Theme("valo")
public class MainUI extends UI {

	@WebServlet(value = { "/*" }, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = true, ui = MainUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		setContent(new MainLayout());
	}

}