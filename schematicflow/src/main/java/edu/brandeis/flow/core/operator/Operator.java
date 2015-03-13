package edu.brandeis.flow.core.operator;


/**
 * Operator is the interface designed for all stream operators. 
 * It can 
 */
import java.util.Set;

import com.vaadin.ui.Image;

interface Operator<E> {
	void setName(String name);
	void setDescription(String description);
	void setImage(Image img);
	void addNextOperator(Operator<E> op);
	void recieve(E obj);
	void send(E obj);
	void process() throws Exception;
	String getName();
	String getDescription();
	Image getImage();
	Set<Operator<E>> getNextOperator();
	E read();
}
