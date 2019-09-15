package model;

public interface StackInterface<V> {
	public boolean isEmpty();
	public void push(V value);
	public V top();
	public void pop();
}