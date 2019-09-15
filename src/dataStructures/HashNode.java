package dataStructures;

public class HashNode<K,V> {
	
	private K key;
	private V value;

	/**
	 * @param key
	 * @param value
	 * @param next
	 */
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public K getKey() {
		return key;
	}
	
	
	
	
}
