package edu.brandeis.flow.core.operator;


/**
 * Operator is the interface designed for all stream operators. 
 */
import java.util.Set;

import com.vaadin.ui.Image;

interface Operator<E> {
	void addNextOperator(Operator<E> op);
	void recieve(E obj);
	void send(E obj);
	void process() throws Exception;
	Set<Operator<E>> getNextOperator();
	E read();
}
