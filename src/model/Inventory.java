package model;

import java.util.ArrayList;
import java.util.List;


public class Inventory {
	
	public static final int ROWS = 4;
	public static final int COLUMNS = 9;
	
	private Slot[][] matrix;
	
	int nextEmptySlotRow;
	int nextEmptySlotColumn;
	
	private Table<String, List<Slot>> inventoryTable;
	
	public Inventory() {
		matrix = new Slot[ROWS][COLUMNS];
		inventoryTable = new HashTable<>();
	}

	
	
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
				if(nextEmptySlotRow<=ROWS-2 || nextEmptySlotColumn <=  COLUMNS-1) {
					Slot add = new Slot(nextEmptySlotRow,nextEmptySlotColumn, quantity);
					add.setBlock(new Block(type));
					matrix[nextEmptySlotRow][nextEmptySlotColumn] = add;
					list.add(add);
					
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
			if(nextEmptySlotRow<=ROWS-2 || nextEmptySlotColumn <= COLUMNS-1) {
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



	/**
	 * @param nextEmptySlotRow the nextEmptySlotRow to set
	 */
	public void setNextEmptySlotRow(int nextEmptySlotRow) {
		this.nextEmptySlotRow = nextEmptySlotRow;
	}



	/**
	 * @param nextEmptySlotColumn the nextEmptySlotColumn to set
	 */
	public void setNextEmptySlotColumn(int nextEmptySlotColumn) {
		this.nextEmptySlotColumn = nextEmptySlotColumn;
	}
	
	
	
}
