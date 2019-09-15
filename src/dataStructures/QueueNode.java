package dataStructures;

public class QueueNode<V> {
		
	private V value;
	private QueueNode<V> next;
	
	public QueueNode(V value) {
		this.value = value;
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
	public QueueNode<V> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(QueueNode<V> next) {
		this.next = next;
	}
	
	
}
