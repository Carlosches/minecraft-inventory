package dataStructures;

public interface QueueInterface<V> {
	
	public boolean isEmpty();
	public void enqueue(V value);
	public V dequeue();
	public V front();
}
