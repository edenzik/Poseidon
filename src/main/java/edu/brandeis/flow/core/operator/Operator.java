package edu.brandeis.flow.core.operator;

/**
 * Operator is the interface designed for all stream operators. 
 */
import java.util.Set;

/**
 * @author edenzik
 *
 * @param <E>
 */
public interface Operator<E> extends Runnable{
	/**
	 * Adds the next operator to this operator
	 * @param op
	 */
	void addNext(Operator<E> op);

	/**
	 * Removes the next operator
	 * @param op
	 */
	void removeNext(Operator<E> op);

	/**
	 * Receives an object from a previous node
	 * @param obj
	 */
	void receive(E obj);

	
	/**
	 * Sends an object to all the next operators
	 * @param obj
	 */
	void send(E obj);

	/**
	 * Gets all of the next operators
	 * @return a set of the next operators
	 */
	Set<Operator<E>> getNext();

	/**
	 * Read the top of the buffer
	 * @return
	 */
	E read();
}
