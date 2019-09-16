package dataStructures;

public class StackClass<V> implements StackInterface<V> {
	
	/**
	 * The last element in the stack (Top of the stack).
	 */
	private StackNode<V> top;
	
	/**
	 * This function initializes a new Stack.
	 */
	public StackClass() {
		top = null;
	}
	
	/* (non-Javadoc)
	 * @see dataStructures.StackInterface#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	/* (non-Javadoc)
	 * @see dataStructures.StackInterface#push(java.lang.Object)
	 */
	@Override
	public void push(V value) {
		top = new StackNode<V>(value, top);
	}

	/* (non-Javadoc)
	 * @see dataStructures.StackInterface#top()
	 */
	@Override
	public V top() {
		V value = null;
		if(!isEmpty()) {
			value = top.getValue();
		}
		
		return value;
	}

	/* (non-Javadoc)
	 * @see dataStructures.StackInterface#pop()
	 */
	@Override
	public V pop() {
		V value = null;
		if(!isEmpty()) {
			value = top.getValue();
			top = top.getNext();
		}
		return value;
	}

}
