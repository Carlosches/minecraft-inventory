package model;

public class Slot {
	
	public final static int MAX_VALUE = 64;
	private int posRow;
	private int posColumn;
	private int quantity;
	
	private Block block;

	/**
	 * @param posRow
	 * @param posColumn
	 * @param quantity
	 */
	public Slot(int posRow, int posColumn, int quantity) {
		this.posRow = posRow;
		this.posColumn = posColumn;
		this.quantity = quantity;
		
		
	}

	/**
	 * @return the posRow
	 */
	public int getPosRow() {
		return posRow;
	}

	/**
	 * @param posRow the posRow to set
	 */
	public void setPosRow(int posRow) {
		this.posRow = posRow;
	}

	/**
	 * @return the posColumn
	 */
	public int getPosColumn() {
		return posColumn;
	}

	/**
	 * @param posColumn the posColumn to set
	 */
	public void setPosColumn(int posColumn) {
		this.posColumn = posColumn;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the block
	 */
	public Block getBlock() {
		return block;
	}

	/**
	 * @param block
	 */
	public void addBlock(Block block, int quant) {
		this.block = block;
		quantity+=quant;
	}

	public void setBlock(Block b) {
		this.block = b;
	}
	
	
	
}
