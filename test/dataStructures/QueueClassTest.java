package dataStructures;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class QueueClassTest {

//________________________________________________ATTRIBUTES________________________________________________________________

	/**
	 * The queue that is to be tested.
	 */
	private QueueClass<Integer> queue;
	
//________________________________________________STAGES________________________________________________________________

	/**
	 * This function initializes a new test scenario.
	 */
	private void stage1() {
		
	}
	
	/**
	 * This function initializes a new test scenario.
	 */
	private void stage2() {
		
		queue = new QueueClass<Integer>();
		
	}
	
	/**
	 * This function initializes a new test scenario.
	 */
	private void stage3() {
		
		queue = new QueueClass<Integer>();
		for (int i = 0; i < 100000; i++) {
			queue.enqueue(i);
		}
		
	}

//________________________________________________TEST METHODS________________________________________________________________
	
	/**
	 * This function tests the queue's constructor.
	 */
	@Test
	public void testQueueClass() {
		
		stage1();
		
		queue = new QueueClass<Integer>();
		
		assertTrue("The queue was not created", queue != null);
		
	}

//________________________________________________________________________________________________________________
	
	/**
	 * This function tests the queue's enqueueing operation with a standard case.
	 */
	@Test
	public void testEnqueue_StandarCase() {
		
		stage2();
		
		queue.enqueue(10);
		queue.enqueue(150);
		
		Integer value = queue.front();
		
		assertTrue("The element was not added to the queue", value == 10);
		
	}
	
//________________________________________________________________________________________________________________

	/**
	 * This function tests the queue's enqueueing operation with a limit case.
	 */
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

	/**
	 * This function tests the queue's dequeueing operation with a standard case.
	 */
	@Test
	public void testDequeue_StandarCase() {
		
		stage3();
		
		queue.dequeue();
		
		assertTrue("The front element was not removed", queue.front() == 1);
		
	}
	
//________________________________________________________________________________________________________________

	/**
	 * This function tests the queue's dequeueing operation with a limit case.
	 */
	@Test
	public void testDequeue_LimitCase() {
		
		stage3();
		
		for (int i = 0; i < 99999; i++) {
			queue.dequeue();
		}
		
		
		
		assertTrue("The front element was not removed", queue.front() == 99999);
		
	}
	
//________________________________________________________________________________________________________________

	/**
	 * This function tests the queue's is empty operation with a standard case.
	 */
	@Test
	public void testIsEmpty() {
		
		stage2();
		
		assertTrue("The queue is not empty", queue.isEmpty() == true);
		
	}
	
//________________________________________________________________________________________________________________

	/**
	 * This function tests the queue's front operation with a standard case.
	 */
	@Test
	public void testFront() {
		
		stage3();
		
		assertTrue("The front is not the expected value", queue.front() == 0);
		
	}
}











