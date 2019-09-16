package model;

public class Slot {
	
	/**
	 * The max value of blocks allowed in a slot.
	 */
	public final static int MAX_VALUE = 64;
	
	/**
	 * The row position of this slot in the inventory matrix.
	 */
	private int posRow;
	
	/**
	 * The column position of this slot in the inventory matrix.
	 */
	private int posColumn;
	
	/**
	 * The quantity of blocks in this slot.
	 */
	private int quantity;
	
	/**
	 * The block that this slot is holding.
	 */
	private Block block;

	/**
	 * This function initializes a new slot in the inventory.
	 * @param posRow The row position of this slot in the inventory matrix.
	 * @param posColumn The column position of this slot in the inventory matrix.
	 * @param quantity The quantity of blocks in this slot.
	 */
	public Slot(int posRow, int posColumn, int quantity) {
		this.posRow = posRow;
		this.posColumn = posColumn;
		this.quantity = quantity;
		
		
	}

	/**
	 * This function obtains the row position of this slot in the inventory matrix.
	 * @return The row position of this slot in the inventory matrix.
	 */
	public int getPosRow() {
		return posRow;
	}

	/**
	 * This function modifies the row position of this slot in the inventory matrix.
	 * @param posRow the posRow to set.
	 */
	public void setPosRow(int posRow) {
		this.posRow = posRow;
	}

	/**
	 * This function obtains the column position of this slot in the inventory matrix.
	 * @return The column position of this slot in the inventory matrix.
	 */
	public int getPosColumn() {
		return posColumn;
	}

	/**
	 * This function modifies the column position of this slot in the inventory matrix.
	 * @param posColumn the posColumn to set.
	 */
	public void setPosColumn(int posColumn) {
		this.posColumn = posColumn;
	}

	/**
	 * This function obtains the amount of blocks in this slot.
	 * @return The quantity of blocks in this slot.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * This function modifies the amount of blocks in this slot.
	 * @param quantity the quantity of blocks to set.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * This function obtains the block held by this slot.
	 * @return The block that this slot is holding.
	 */
	public Block getBlock() {
		return block;
	}

	/**
	 * This function adds a new block with a specified quantity to this slot.
	 * @param block The block to be added to.
	 * @param quant The amount of blocks to be added.
	 */
	public void addBlock(Block block, int quant) {
		this.block = block;
		quantity+=quant;
	}

	/**
	 * This function modifies the block being held by this slot.
	 * @param b The new block of this slot.
	 */
	public void setBlock(Block b) {
		this.block = b;
	}
	
	
	
}
