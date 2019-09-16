package dataStructures;

public class StackNode<V> {
	
	/**
	 * The value of the node.
	 */
	private V value;
	
	/**
	 * The next stack node in the stack.
	 */
	private StackNode<V> next;
	
	/**
	 * This function initializes a new stack node.
	 * @param value The value of this stack node.
	 */
	public StackNode(V value, StackNode<V> next) {
		this.value = value;
		this.next = next;
	}

	/**
	 * This function obtains the value of this stack node.
	 * @return the value of this stack node.
	 */
	public V getValue() {
		return value;
	}

	/**
	 * This function obtains the next element in the stack.
	 * @return the next Stack node in the stack.
	 */
	public StackNode<V> getNext() {
		return next;
	}

	/**
	 * This function modifies the next element in the stack.
	 * @param next the next stack node to be set.
	 */
	public void setNext(StackNode<V> next) {
		this.next = next;
	}
	
	
}
