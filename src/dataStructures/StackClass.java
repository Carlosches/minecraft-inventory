package dataStructures;

public class StackClass<V> implements StackInterface<V> {
	
	private StackNode<V> top;
	
	public StackClass() {
		top = null;
	}
	
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void push(V value) {
		top = new StackNode<V>(value, top);
	}

	@Override
	public V top() {
		V value = null;
		if(!isEmpty()) {
			value = top.getValue();
		}
		
		return value;
	}

	@Override
	public V pop() {
		V value = null;
		if(!isEmpty()) {
			value = top.getValue();
			top = top.getNext();
		}
		return value;
	}

}