package edu.brandeis.flow.ui.operator.in;

import java.io.IOException;

import org.json.JSONException;

import edu.brandeis.flow.ui.network.UIOperatorNetworkDiagram;
import edu.brandeis.flow.ui.operator.UIOperator;
import edu.brandeis.flow.ui.operator.UIOperatorFactory;

public final class UIInFactory extends UIOperatorFactory {

	int port;
	String url;
	
	public UIInFactory(String url, int port) {
		super("In", "in.svg");
	}

	@Override
	public UIOperator makeUIOperator(UIOperatorNetworkDiagram nd) throws JSONException, IOException  {
		return new UIIn(nd);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "In";
	}

}
