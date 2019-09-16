package dataStructures;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class HashTableTest {

//________________________________________________ATTRIBUTES________________________________________________________________

	/**
	 * The hash table that is to be tested.
	 */
	private HashTable<Integer, String> hashTable;
	
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
		hashTable = new HashTable<Integer, String>();
	}
	
	/**
	 * This function initializes a new test scenario.
	 */
	private void stage3() {
		
		hashTable = new HashTable<Integer, String>();
		
		for (int i = 0; i < 10000; i++) {
			hashTable.add(i, "stage3, test value: " + i);
		}
	}
	
//________________________________________________TEST METHODS________________________________________________________________
	
	/**
	 * This function tests the hash table constructor.
	 */
	@Test
	public void testHashTable() {
		
		stage1();
		
		hashTable = new HashTable<Integer, String>();
		
		assertTrue("The hash table could not be create", hashTable != null);
	}
	
//________________________________________________________________________________________________________________

	/**
	 * This function tests the hash table adding operation with a standard case.
	 */
	@Test
	public void testAdd_StandarCase() {
		
		stage2();
		
		hashTable.add(1, "test add method");
		
		assertTrue("The new element was not added", hashTable.size() != 0 && hashTable.get(1).equals("test add method"));
		
	}
	
//________________________________________________________________________________________________________________

	/**
	 * This function tests the hash table adding operation with a limit case.
	 */
	@Test
	public void testAdd_LimitCase() {
		
		stage2();
		
		for (int i = 0; i < 10000; i++) {
			
			hashTable.add(i, "limit case "+ i);
			
		}
		
		assertTrue("The elements were not added", hashTable.size() == 10000);
		
	}

//________________________________________________________________________________________________________________

	/**
	 * This function tests the hash table get operation with a standard case.
	 */
	@Test
	public void testGet_StandarCase() {
		
		stage3();
		
		String value = "stage3, test value: 19";
		
		assertTrue("The element in the table was not found", hashTable.get(19).equals(value));
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This function tests the hash table get operation with a limit case.
	 */
	@Test
	public void testGet_LimitCase() { //problems
		
		stage3();
		
		boolean added = true;
		
		for (int i = 0; i < 100; i++) {
			if (hashTable.get(i) != null) {
				if (!hashTable.get(i).equals("stage3, test value: " + i)) {
					added = false;
				}
			}
		}
		
		assertTrue("The elements were not found", added);
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This function tests the hash table contains key operation with a standard case.
	 */
	@Test
	public void testContainsKey_StandarCase() {
		
		stage3();
		
		boolean found = hashTable.containsKey(112);
		
		assertTrue("the key in the table was not found", found);
		
	}
	
//________________________________________________________________________________________________________________
	
}
