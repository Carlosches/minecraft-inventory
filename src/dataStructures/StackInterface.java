package dataStructures;

public interface StackInterface<V> {
	
	/**
	 * This function determines whether or not the stack is empty.
	 * @return True if the stack is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * This function adds a new item into the stack.
	 * @param value The item to be added.
	 */
	public void push(V value);
	
	/**
	 * This function obtains the value at the top of the stack.
	 * @return The value that was just obtained.
	 */
	public V top();
	
	/**
	 * This function removes the item at the top of the stack.
	 * @return The value that was just removed.
	 */
	public V pop();
}
