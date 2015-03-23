/**
 * 
 */
package edu.brandeis.flow.ui.operator;

import java.io.IOException;

import org.json.JSONException;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;

/**
 * @author Yahui
 *
 */
public final class UIINFactory extends UIOperatorFactory {

	/**
	 * @param string
	 * @param resource
	 */
	public UIINFactory() {
		super("IN", new ThemeResource("../runo/icons/64/arrow-down.png"));
	}

	/* (non-Javadoc)
	 * @see edu.brandeis.flow.ui.operator.UIOperatorFactory#makeUIOperator()
	 */
	@Override
	public UIOperator makeUIOperator(){
		//return new UIIN();
		return null;
	}

}
