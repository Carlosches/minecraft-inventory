package dataStructures;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class StackClassTest {

//________________________________________________ATTRIBUTES________________________________________________________________

	/**
	 * The stack that is to be tested.
	 */
	private StackClass<Integer> stack;
	
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
		
		stack = new StackClass<Integer>();
		
	}
	
	/**
	 * This function initializes a new test scenario.
	 */
	private void stage3() {
		
		stack = new StackClass<Integer>();
		for (int i = 0; i < 100000; i++) {
			stack.push(i);
		}
		
	}
	
//________________________________________________TEST METHODS________________________________________________________________

	/**
	 * This function tests the stack's constructor.
	 */
	@Test
	public void testStackClass() {
		
		stage1();
		
		stack = new StackClass<Integer>();
		
		assertTrue("The stack was not created", stack != null);
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This function tests the stack's pushing operation with a standard case.
	 */
	@Test
	public void testPush_StandarCase() {
		
		stage2();
		
		stack.push(10);
		
		Integer value = stack.top();
		
		assertTrue("The element was not added to the stack", value == 10);
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This function tests the stack's pushing operation with a limit case.
	 */
	@Test
	public void testPush_LimitCase() {
		
		stage2();
		
		boolean pushed = true;
		
		for (int i = 0; i < 100000; i++) {
			stack.push(i);
			
			if (stack.top() != i) {
				pushed = false;
			}
			
		}
		
		assertTrue("The last element added does not match with the top", pushed);
		
	}
	
//________________________________________________________________________________________________________________

	/**
	 * This function tests the stack's popping operation with a standard case.
	 */
	@Test
	public void testPop_StandarCase() {
		
		stage3();
		
		stack.pop();
		
		assertTrue("The top element was not removed", stack.top() == 99998);
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This function tests the stack's popping operation with a limit case.
	 */
	@Test
	public void testPop_LimitCase() {
		
		stage3();
		
		for (int i = 0; i < 99999; i++) {
			stack.pop();
		}
		
		
		
		assertTrue("The top element was not removed", stack.top() == 0);
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This function tests the stack's top operation with a standard case.
	 */
	@Test 
	public void testTop_StandarCase() {
		
		stage3();
		
		assertTrue("The top element is not the correct one", stack.top() == 99999);
		
	}
	
//________________________________________________________________________________________________________________

	/**
	 * This function tests the stack's top operation with a limit case.
	 */
	@Test
	public void testTop_LimitCase() {
		
		stage3();
		
		boolean correctTop = true;
		
		for (int i = 99998; i >= 0 && correctTop; i--) {
			
			stack.pop();
			if (stack.top() != i) {
				correctTop = false;
			}
			
		}
		
		assertTrue("The top is not the expected element", correctTop);
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This function tests the stack's is empty operation with a standard case.
	 */
	@Test
	public void testIsEmpty() {
		
		stage2();
		
		assertTrue("The stack is not empty", stack.isEmpty() == true);
		
	}

}





















