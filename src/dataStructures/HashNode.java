package dataStructures;

public class HashNode<K,V> {
	
	/**
	 * The key value of this hash node.
	 */
	private K key;
	
	/**
	 * The value that this hash node holds.
	 */
	private V value;

	/**
	 * This function initializes a new hash node.
	 * @param key The key value of this hash node.
	 * @param value The value that this hash node holds.
	 */
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * This function obtains the value that this hash node holds.
	 * @return The value that this hash node holds.
	 */
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	/**
	 * This function obtains this hash node's key value.
	 * @return The key value of this hash node.
	 */
	public K getKey() {
		return key;
	}
	
	
	
	
}
