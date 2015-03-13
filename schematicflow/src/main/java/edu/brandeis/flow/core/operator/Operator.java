package edu.brandeis.flow.core.operator;

import com.vaadin.ui.Image;

interface Operator<E> {
	void setName(String name);
	void setDescription(String description);
	void setImage(Image img);
	void addNext(Operator<E> op);
	void recieve(E obj);
	void send(E obj);
	void process();
	
}
