package model;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> implements Table<K,V> {
	
	private List<HashNode<K,V>> nodes;
	
	private int capacity; 
	  
	private int numNodes;
	
	
	
	/**
	 * @param nodes
	 * @param capacity
	 * @param numNodes
	 */
	public HashTable() {
		capacity = 10;
		nodes = new ArrayList<>();
		
		for (int i = 0; i < capacity; i++) {
			nodes.add(null);
		}
	}

	@Override
	public V get(K key) {
		
		V value = null;
		int counter = 0;
		boolean found = false;
		
		while( !found && counter<capacity) {
			
			int index = getIndex(key, counter);
		
			if(nodes.get(index)!= null && nodes.get(index).getKey().equals(key)) {
				found = true;
				value = nodes.get(index).getValue();
			}
			
			counter++;
		}
		
			return value;
	}

	@Override
	public void add(K key, V value) {
		
		boolean found = false;
		int counter = 0;
		while( !found && counter<capacity) {
			int index = getIndex(key, counter);
			
			if(nodes.get(index)==null) {
				found = true;
				nodes.remove(index);
				nodes.add(index, new HashNode<K, V>(key, value));
				numNodes++;
			}
			
			counter++;
			
			if(counter==capacity && !found) {
				capacity*=2;
				
				for (int i = counter; i < capacity; i++) {
					nodes.add(null);
				}
			}
		}
		
	}

	@Override
	public boolean containsKey(K key) {
		int index = getIndex(key, 0);
		boolean contains = false;	
			if(nodes.get(index)!=null) {
				contains = true;
			}
				
		return contains;
	}

	@Override
	public int size() {

		return numNodes;
	}
	
	
	private int getIndex(K key, int counter) {
		int index = 0;
		
		int hashCode = Math.abs(key.hashCode());
		
		double A = (Math.sqrt(5) - 1 )/ 2;
		int h1 = (int) Math.floor(capacity*(A*hashCode% 1));
		
		int h2 = hashCode % capacity;
		
		index = (h1 + h2*counter)%capacity;
		return index;
	}
	
	
}
