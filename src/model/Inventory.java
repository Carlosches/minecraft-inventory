//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to multiply matrices and finding prime numbers. 
 */

package model;

//______________________________________________________IMPORTS___________________________________________________________

import java.util.ArrayList;
import java.util.List;

//______________________________________________________THE CLASS__________________________________________________________

/**
* This class defines the necessary methods to multiply matrices and finding prime numbers. 
* @author
*/

public class Inventory {
	
//______________________________________________________CONSTANTS___________________________________________________________	

	public static final int ROWS = 4;
	public static final int COLUMNS = 9;

//______________________________________________________ATTRIBUTES___________________________________________________________

	private Slot[][] matrix;
	
	int nextEmptySlotRow;
	int nextEmptySlotColumn;
	
	private Table<String, List<Slot>> inventoryTable;

//______________________________________________________METHODS___________________________________________________________

	public Inventory() {
		matrix = new Slot[ROWS-1][COLUMNS];
		inventoryTable = new HashTable<>();
	}

//________________________________________________________________________________________________________________
	
	public boolean addBlock(String type, int quantity){
		boolean possible = true;
		List<Slot> list = inventoryTable.get(type);
		int copy = quantity;
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
	 * @return the matrix
	 */
	public Slot[][] getMatrix() {
		return matrix;
	}

//________________________________________________________________________________________________________________

	/**
	 * @return the inventoryTable
	 */
	public Table<String, List<Slot>> getInventoryTable() {
		return inventoryTable;
	}

//________________________________________________________________________________________________________________

	/**
	 * @param nextEmptySlotRow the nextEmptySlotRow to set
	 */
	public void setNextEmptySlotRow(int nextEmptySlotRow) {
		this.nextEmptySlotRow = nextEmptySlotRow;
	}

//________________________________________________________________________________________________________________
	
	/**
	 * @param nextEmptySlotColumn the nextEmptySlotColumn to set
	 */
	public void setNextEmptySlotColumn(int nextEmptySlotColumn) {
		this.nextEmptySlotColumn = nextEmptySlotColumn;
	}

	/**
	 * @return the nextEmptySlotRow
	 */
	public int getNextEmptySlotRow() {
		return nextEmptySlotRow;
	}

	/**
	 * @return the nextEmptySlotColumn
	 */
	public int getNextEmptySlotColumn() {
		return nextEmptySlotColumn;
	}
	
//________________________________________________________________________________________________________________
	
	
	
}
