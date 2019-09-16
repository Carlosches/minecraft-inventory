package dataStructures;

public class QueueNode<V> {
		
	/**
	 * The value of the node.
	 */
	private V value;
	
	/**
	 * The next queue node in the queue.
	 */
	private QueueNode<V> next;
	
	/**
	 * This function initializes a new queue node.
	 * @param value The value of this queue node.
	 */
	public QueueNode(V value) {
		this.value = value;
	}

	/**
	 * This function obtains the value of this queue node.
	 * @return the value of this queue node.
	 */
	public V getValue() {
		return value;
	}

	/**
	 * This function obtains the next element in the queue.
	 * @return the next Queue node in the queue.
	 */
	public QueueNode<V> getNext() {
		return next;
	}

	/**
	 * This function modifies the next element in the queue.
	 * @param next the next queue node to be set.
	 */
	public void setNext(QueueNode<V> next) {
		this.next = next;
	}
	
	
}
