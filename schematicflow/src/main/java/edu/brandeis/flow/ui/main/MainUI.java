package edu.brandeis.flow.ui.main;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

import javax.servlet.annotation.WebServlet;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.RequestHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import edu.brandeis.flow.server.stream.JSONStream;
import edu.brandeis.flow.ui.sidebar.OperatorFactoryDescriptionSidebar;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;


/**
 * @author edenzik
 * Main UI class which receives a stream of data from back end and displays it
 *
 */
@Push()
@SuppressWarnings("serial")
@Theme("valo")
public class MainUI extends UI {

	@WebServlet(value = {"/*"}, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = true, ui = MainUI.class)
	public static class Servlet extends VaadinServlet {}

	@Override
	protected void init(VaadinRequest request) {
		setContent(new MainLayout());
	}


}