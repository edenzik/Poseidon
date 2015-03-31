package edu.brandeis.flow.core.operator;

/**
 * Operator is the interface designed for all stream operators. 
 */
import java.util.Set;

public interface Operator<E> {
	void addNext(Operator<E> op);

	void removeNext(Operator<E> op);

	void receive(E obj);

	void send(E obj);

	void process() throws Exception;

	Set<Operator<E>> getNext();

	E read();
}
