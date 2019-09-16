package dataStructures;

public class QueueClass<V> implements QueueInterface<V> {
	
	/**
	 * The first element in the queue (front of the queue).
	 */
	private QueueNode<V> first;
	
	/**
	 * The last element in the queue (back of the queue).
	 */
	private QueueNode<V> last;
	
	
	/**
	 * This function initializes a new Queue.
	 */
	public QueueClass() {
		first = null;
		last = null;
	}
	
	
	/* (non-Javadoc)
	 * @see dataStructures.QueueInterface#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return last==null;
	}
	
	/* (non-Javadoc)
	 * @see dataStructures.QueueInterface#enqueue(java.lang.Object)
	 */
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
	
	/* (non-Javadoc)
	 * @see dataStructures.QueueInterface#dequeue()
	 */
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
	
	/* (non-Javadoc)
	 * @see dataStructures.QueueInterface#front()
	 */
	@Override
	public V front() {
		V value = null;
		if(!isEmpty())
			value = first.getValue();
		
		return value;
	}
	
	
}
