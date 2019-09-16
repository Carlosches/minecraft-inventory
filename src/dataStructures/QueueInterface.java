package dataStructures;

public interface QueueInterface<V> {
	
	/**
	 * This function determines whether or not the queue is empty.
	 * @return True if the queue is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * This function adds a new item into the queue.
	 * @param value The item to be added.
	 */
	public void enqueue(V value);
	
	/**
	 * This function removes the item at the front of the queue.
	 * @return The value that was just removed.
	 */
	public V dequeue();
	
	/**
	 * This function obtains the value at the front of the queue.
	 * @return The value that was just obtained.
	 */
	public V front();
}
