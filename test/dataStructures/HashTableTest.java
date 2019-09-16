package dataStructures;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class HashTableTest {

//________________________________________________ATTRIBUTES________________________________________________________________

	private HashTable<Integer, String> hashTable;
	
//________________________________________________STAGES________________________________________________________________

	private void stage1() {
		
	}
	
	private void stage2() {
		hashTable = new HashTable<Integer, String>();
	}
	
	private void stage3() {
		
		hashTable = new HashTable<Integer, String>();
		
		for (int i = 0; i < 10000; i++) {
			hashTable.add(i, "stage3, test value: " + i);
		}
	}
	
//________________________________________________TEST METHODS________________________________________________________________
	
	@Test
	public void testHashTable() {
		
		stage1();
		
		hashTable = new HashTable<Integer, String>();
		
		assertTrue("The hash table could not be create", hashTable != null);
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testAdd_StandarCase() {
		
		stage2();
		
		hashTable.add(1, "test add method");
		
		assertTrue("The new element was not added", hashTable.size() != 0 && hashTable.get(1).equals("test add method"));
		
	}
	
//________________________________________________________________________________________________________________

	@Test
	public void testAdd_LimitCase() {
		
		stage2();
		
		for (int i = 0; i < 10000; i++) {
			
			hashTable.add(i, "limit case "+ i);
			
		}
		
		assertTrue("The elements were not added", hashTable.size() == 10000);
		
	}

//________________________________________________________________________________________________________________


	@Test
	public void testGet_StandarCase() {
		
		stage3();
		
		String value = "stage3, test value: 19";
		
		assertTrue("The element in the table was not found", hashTable.get(19).equals(value));
		
	}
	
//________________________________________________________________________________________________________________
	
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
	
	@Test
	public void testContainsKey_StandarCase() {
		
		stage3();
		
		boolean found = hashTable.containsKey(112);
		
		assertTrue("the key in the table was not found", found);
		
	}
	
//________________________________________________________________________________________________________________
	
}
