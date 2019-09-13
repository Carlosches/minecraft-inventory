package model;

import java.util.List;

public class Inventory {
	
	public static final int ROWS = 4;
	public static final int COLUMNS = 9;
	
	private Slot[][] matrix;
	
	private Table<String, List<Slot>> inventoryTable;
	
	public Inventory() {
		matrix = new Slot[ROWS][COLUMNS];
		inventoryTable = new HashTable<>();
	}

	
	
	public boolean addBlock(String type, int quantity){
		boolean possible = false;
		
		
		
		
		
		
		
		
		return possible;
	}
	
	
	
	
	/**
	 * @return the matrix
	 */
	public Slot[][] getMatrix() {
		return matrix;
	}

	/**
	 * @return the inventoryTable
	 */
	public Table<String, List<Slot>> getInventoryTable() {
		return inventoryTable;
	}
	
	
	
}
