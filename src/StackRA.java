/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Completed and throughly tested
 * Last update: 10/05/20
 * Submitted:  10/05/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.10.03
 */
public class StackRA<T> implements StackInterface<T> {

	protected T items[];
	protected int top;

	@SuppressWarnings("unchecked")
	public StackRA() {
		top = -1;
		items = (T[]) new Object[3];	
	}
	
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public void push(T newItem) throws StackException {
		if(top == (items.length - 1) ) {
			resizeArray();
		}
		items[top+1] = (T) newItem;
		top++;
	}
	
	@Override
	public void popAll() {
		if(top != -1) {	
			items[top] = null;
			top = -1;
		}
		else {
			throw new StackException("Please enter elements to the stack before proceeding.");
		}
	}

	@Override
	public T pop() throws StackException {
		T result;
		if(top != -1) {
			result = items[top];
			items[top--] = null;
		}
		else {
			throw new StackException("Please enter elements to the stack before proceeding.");
		}
		return result;
	}

	@Override
	public T peek() throws StackException {
		T result;
		if(top != -1) {
			result = items[top];
		}
		else {
			throw new StackException("Please fill the stack with elements before proceeding.");
		}
		return result;
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void resizeArray() {
		int numItems = items.length;
		T[] temp = (T[]) new Object[numItems * 2];
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}
	
	/**
	 * 
	 */
	public String toString() {
		String toReturn = "";
		for(int i = top; i >= 0; i--) {
			toReturn = toReturn.concat(items[i] + " ");
		}
		return toReturn;
	}

}
