/**
 * 
 */
package edu.brandeis.flow.ui.operator;

import java.io.IOException;

import org.json.JSONException;

import com.vaadin.ui.UI;

import edu.brandeis.flow.core.operator.IN;
import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author Yahui
 *
 */
public final class UIIN extends UIOperator {

	protected UIIN() throws JSONException, IOException {
		super(new IN("in"));
		setImage("./VAADIN/images/in-1.svg");
		//UI.getCurrent().push();
	}
	
	

}
