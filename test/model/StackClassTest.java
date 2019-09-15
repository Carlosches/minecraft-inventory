package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackClassTest {

//________________________________________________ATTRIBUTES________________________________________________________________

	private StackClass<Integer> stack;
	
//________________________________________________STAGES________________________________________________________________

	private void stage1() {
		
	}
	
	private void stage2() {
		
		stack = new StackClass<Integer>();
		
	}
	
	private void stage3() {
		
		stack = new StackClass<Integer>();
		for (int i = 0; i < 1000; i++) {
			stack.push(i);
		}
		
	}
	
//________________________________________________TEST METHODS________________________________________________________________

	@Test
	public void testStackClass() {
		
		stage1();
		
		stack = new StackClass<Integer>();
		
		assertTrue("The stack was not created", stack != null);
		
	}
	
//________________________________________________________________________________________________________________
	
	@Test
	public void testPush_StandarCase() {
		
		stage2();
		
		stack.push(10);
		
		Integer value = stack.top();
		
		assertTrue("The element was not added to the stack", value == 10);
		
	}
	
//________________________________________________________________________________________________________________
	
	@Test
	public void testPush_LimitCase() {
		
		stage2();
		
		boolean pushed = true;
		
		for (int i = 0; i < 1000; i++) {
			stack.push(i);
			
			if (stack.top() != i) {
				pushed = false;
			}
			
		}
		
		assertTrue("The last element added does not match with the top", pushed);
		
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testPop_StandarCase() {
		
		stage3();
		
		stack.pop();
		
		assertTrue("The top element was not removed", stack.top() == 998);
		
	}
	
//________________________________________________________________________________________________________________
	
	@Test
	public void testPop_LimitCase() {
		
		stage3();
		
		for (int i = 0; i < 999; i++) {
			stack.pop();
		}
		
		
		
		assertTrue("The top element was not removed", stack.top() == 0);
		
	}
	
//________________________________________________________________________________________________________________
	
	@Test 
	public void testTop_StandarCase() {
		
		stage3();
		
		assertTrue("The top element is not the correct one", stack.top() == 999);
		
	}
}










