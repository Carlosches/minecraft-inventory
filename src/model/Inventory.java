//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to multiply matrices and finding prime numbers. 
 */

package model;

//______________________________________________________IMPORTS___________________________________________________________

import java.util.ArrayList;
import java.util.List;

import dataStructures.HashTable;
import dataStructures.Table;

//______________________________________________________THE CLASS__________________________________________________________

/**
* This class defines the necessary methods to multiply matrices and finding prime numbers. 
* @author
*/

public class Inventory {
	
//______________________________________________________CONSTANTS___________________________________________________________	

	/**
	 * The amount of rows in the inventory.
	 */
	public static final int ROWS = 4;
	
	/**
	 * The amount of columns in the inventory.
	 */
	public static final int COLUMNS = 9;

//______________________________________________________ATTRIBUTES___________________________________________________________

	/**
	 * The matrix of slots representing the minecraft inventory.
	 */
	private Slot[][] matrix;
	
	/**
	 * The next empty row position in the slot matrix.
	 */
	int nextEmptySlotRow;
	
	/**
	 * The next empty column position in the slot matrix.
	 */
	int nextEmptySlotColumn;
	
	private Table<String, List<Slot>> inventoryTable;

//______________________________________________________METHODS___________________________________________________________

	/**
	 * This function initializes a new inventory.
	 */
	public Inventory() {
		matrix = new Slot[ROWS-1][COLUMNS];
		inventoryTable = new HashTable<>();
	}

//________________________________________________________________________________________________________________
	
	/**
	 * This function adds a block into a new slot or to an existing slot if there is a block of the same type with enough space.
	 * @param type The type of block to be added.
	 * @param quantity The amount of blocks of this type to be added.
	 * @return A boolean value representing whether the block was added or not.
	 */
	public boolean addBlock(String type, int quantity){
		boolean possible = true;
		List<Slot> list = inventoryTable.get(type);
		if(list!=null) {
			
			for (int i = 0; i < list.size() && quantity>0; i++) {
				int cur = list.get(i).getQuantity();
				int dif = Slot.MAX_VALUE-cur;
				if(dif>= quantity) {
					list.get(i).setQuantity(cur+quantity);
					quantity=0;
				}else {
					list.get(i).setQuantity(Slot.MAX_VALUE);
					quantity-=dif;
				}
					
			}
			
			if(quantity>0) {
				if((nextEmptySlotRow<=ROWS-2 && nextEmptySlotColumn <=  COLUMNS-1) && matrix[nextEmptySlotRow][nextEmptySlotColumn] == null) {
					Slot add = new Slot(nextEmptySlotRow,nextEmptySlotColumn, quantity);
					add.setBlock(new Block(type));
					matrix[nextEmptySlotRow][nextEmptySlotColumn] = add;
					list.add(add);
					System.out.println("enter "+ type);
					nextEmptySlotColumn++;
					
					if(nextEmptySlotColumn==COLUMNS) {
						nextEmptySlotColumn = 0;
						nextEmptySlotRow++;
					}
					
				}else {
					possible = false;
				}
			}
		}else {
			

			if((nextEmptySlotRow<=ROWS-2 && nextEmptySlotColumn <= COLUMNS-1) && matrix[nextEmptySlotRow][nextEmptySlotColumn] == null) {

				Slot ad = new Slot(nextEmptySlotRow,nextEmptySlotColumn, quantity);
				ad.setBlock(new Block(type));
				matrix[nextEmptySlotRow][nextEmptySlotColumn] = ad ;
				List<Slot> li = new ArrayList<>();
				li.add(ad);
				inventoryTable.add(type,li);
				possible = true;
				
				nextEmptySlotColumn++;
				
				if(nextEmptySlotColumn==COLUMNS) {
					nextEmptySlotColumn = 0;
					nextEmptySlotRow++;
				}
			}else {
				possible = false;
			}
		}
		return possible;
	}
	
	
//________________________________________________________________________________________________________________
	
	/**
	 * This function obtains this inventory's matrix.
	 * @return the matrix of slots representing the inventory.
	 */
	public Slot[][] getMatrix() {
		return matrix;
	}

//________________________________________________________________________________________________________________

	/**
	 * This function obtains this inventory's hash table with the blocks that have been added to it.
	 * @return the inventoryTable of the inventory.
	 */
	public Table<String, List<Slot>> getInventoryTable() {
		return inventoryTable;
	}

//________________________________________________________________________________________________________________

	/**
	 * This function modifies the next empty row slot in the inventory.
	 * @param nextEmptySlotRow the nextEmptySlotRow to set.
	 */
	public void setNextEmptySlotRow(int nextEmptySlotRow) {
		this.nextEmptySlotRow = nextEmptySlotRow;
	}

//________________________________________________________________________________________________________________
	
	/**
	 * This function modifies the next empty column slot in the inventory.
	 * @param nextEmptySlotColumn the nextEmptySlotColumn to set.
	 */
	public void setNextEmptySlotColumn(int nextEmptySlotColumn) {
		this.nextEmptySlotColumn = nextEmptySlotColumn;
	}

	/**
	 * This function obtains the next empty row slot in the inventory.
	 * @return the nextEmptySlotRow in the inventory.
	 */
	public int getNextEmptySlotRow() {
		return nextEmptySlotRow;
	}

	/**
	 * This function obtains the next empty column slot in the inventory.
	 * @return the nextEmptySlotColumn in the inventory.
	 */
	public int getNextEmptySlotColumn() {
		return nextEmptySlotColumn;
	}
	
//________________________________________________________________________________________________________________
	
	
	
}
