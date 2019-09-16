package dataStructures;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class QueueClassTest {

//________________________________________________ATTRIBUTES________________________________________________________________

	private QueueClass<Integer> queue;
	
//________________________________________________STAGES________________________________________________________________

	private void stage1() {
		
	}
	
	private void stage2() {
		
		queue = new QueueClass<Integer>();
		
	}
	
	private void stage3() {
		
		queue = new QueueClass<Integer>();
		for (int i = 0; i < 100000; i++) {
			queue.enqueue(i);
		}
		
	}

//________________________________________________TEST METHODS________________________________________________________________
	
	@Test
	public void testQueueClass() {
		
		stage1();
		
		queue = new QueueClass<Integer>();
		
		assertTrue("The queue was not created", queue != null);
		
	}

//________________________________________________________________________________________________________________
	
	@Test
	public void testEnqueue_StandarCase() {
		
		stage2();
		
		queue.enqueue(10);
		queue.enqueue(150);
		
		Integer value = queue.front();
		
		assertTrue("The element was not added to the queue", value == 10);
		
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testEnqueue_LimitCase() {
		
		stage2();
		
		boolean enqueued = true;
		
		for (int i = 0; i < 100000; i++) {
			queue.enqueue(i);
			
			if (queue.front() != 0) {
				enqueued = false;
			}
			
		}
		
		assertTrue("The last element was added in the front of the queue", enqueued);
		
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testDequeue_StandarCase() {
		
		stage3();
		
		queue.dequeue();
		
		assertTrue("The front element was not removed", queue.front() == 1);
		
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testDequeue_LimitCase() {
		
		stage3();
		
		for (int i = 0; i < 99999; i++) {
			queue.dequeue();
		}
		
		
		
		assertTrue("The front element was not removed", queue.front() == 99999);
		
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testIsEmpty() {
		
		stage2();
		
		assertTrue("The queue is not empty", queue.isEmpty() == true);
		
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testFront() {
		
		stage3();
		
		assertTrue("The front is not the expected value", queue.front() == 0);
		
	}
}











