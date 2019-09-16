package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> implements Table<K,V> {
	
	/**
	 * The list of hash nodes that represent all the keys and values of this hash table.
	 */
	private List<HashNode<K,V>> nodes;
	
	/**
	 * The current holding capacity of this hash table.
	 */
	private int capacity; 
	  
	/**
	 * The size of this hash table.
	 */
	private int numNodes;
	
	/**
	 * This function initializes a new Hash Table with generics.
	 */
	public HashTable() {
		capacity = 10;
		nodes = new ArrayList<>();
		
		for (int i = 0; i < capacity; i++) {
			nodes.add(null);
		}
	}

	/* (non-Javadoc)
	 * @see dataStructures.Table#get(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see dataStructures.Table#add(java.lang.Object, java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see dataStructures.Table#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {
		int index = getIndex(key, 0);
		boolean contains = false;	
			if(nodes.get(index)!=null) {
				contains = true;
			}
				
		return contains;
	}

	/* (non-Javadoc)
	 * @see dataStructures.Table#size()
	 */
	@Override
	public int size() {
		return numNodes;
	}
	
	
	/**
	 * This function hashes the key in order to obtain the position where the key is to be inserted or obtained from.
	 * @param key The key to be hashed.
	 * @param counter The counter which is auxiliary in the hash function.
	 * @return The index that this key is hashed to.
	 */
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
