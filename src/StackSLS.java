/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Completed and throughly tested
 * Last update: 10/05/20
 * Submitted:  10/05/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.10.03
 */
public class StackSLS<T> implements StackInterface<T>{

	protected Node<T> top;
	
	public StackSLS() {
		top = null;
	}
	
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void popAll() {
		top = null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void push(Object newItem) throws StackException {
		Node<T> newTop = new Node<T>((T) newItem, top);
		top = newTop;
	}

	@Override
	public T pop() throws StackException {
		if(top != null) {
			T result = top.getItem();
			top = top.getNext();
			return result;
		}
		else {
			throw new StackException("There must be elements in the collection!");
		}
	}

	@Override
	public T peek() throws StackException {
		if(top != null) {
			return top.getItem();
		}
		else {
			throw new StackException("There must be elements in the collection!");
		}
	}
	
	public String toString() {
		String theList = "";
		Node<T> current = top;
		
		while(current != null) {
			theList = theList.concat(current.getItem() + " ");
			current = current.getNext();
		}
		return theList;
	}

}
