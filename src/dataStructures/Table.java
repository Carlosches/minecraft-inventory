package dataStructures;

public interface Table<K,V> {
	
	/**
	 * This function gets the value of the key that arrives as a parameter.
	 * @param key The key used to obtain a value.
	 * @return The value obtained.
	 */
	public V get(K key);
	
	/**
	 * This function adds a new Hash node into the table.
	 * @param key The key of the hash node.
	 * @param value The value of the hash node.
	 */
	public void add(K key, V value);
	
	/**
	 * This function determines whether or not a key exists in the table.
	 * @param key The key to be judged.
	 * @return True if the table contains this key, false otherwise.
	 */ 
	public boolean containsKey(K key);
	
	/**
	 * This function obtains the number of elements in the table.
	 * @return The size of the table.
	 */
	public int size();
}
