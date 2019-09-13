package model;

public interface Table<K,V> {
	
	public V get(K key);
	public void add(K key, V value);
	public boolean containsKey(K key);
	public int size();
}
