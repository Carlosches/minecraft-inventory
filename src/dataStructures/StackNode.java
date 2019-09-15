package dataStructures;

public class StackNode<V> {
	
	private V value;
	private StackNode<V> next;
	
	public StackNode(V value, StackNode<V> next) {
		this.value = value;
		this.next = next;
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}


	/**
	 * @return the next
	 */
	public StackNode<V> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(StackNode<V> next) {
		this.next = next;
	}
	
	
}
