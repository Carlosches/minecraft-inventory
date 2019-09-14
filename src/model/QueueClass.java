package model;

public class QueueClass<V> implements QueueInterface<V> {
	
	private QueueNode<V> first;
	private QueueNode<V> last;
	
	
	public QueueClass() {
		first = null;
		last = null;
	}
	
	
	@Override
	public boolean isEmpty() {
		return last==null;
	}
	@Override
	public void enqueue(V value) {
		QueueNode<V> newNode = new QueueNode<V>(value);
		
		if (isEmpty()) { 			//insertion into empty queue
			first = newNode;		 // new node is referenced by first
		}						
		else {
			last.setNext(newNode);   //insertion into non-empty queue
			} 		
		last = newNode;
	}
	@Override
	public V dequeue() {
		V value = null;
		if (!isEmpty( )) {
			QueueNode<V> firstNode = first;
			
			if (first == last) {
				last = null;
			}
			else{
				first = first.getNext();
			}
			value = firstNode.getValue();
		}
		
		return value;
	}
	@Override
	public V front() {
		V value = null;
		if(!isEmpty())
			value = first.getValue();
		
		return value;
	}
	
	
}
