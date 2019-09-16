package model;

public class Block {

	/**
	 * Represents a type of block.
	 */
	public static final String WOOD = "Wood";
	
	/**
	 * Represents a type of block.
	 */
	public static final String ANDESITE = "Andesite";
	
	/**
	 * Represents a type of block.
	 */
	public static final String BRICK = "Brick";
	
	/**
	 * Represents a type of block.
	 */
	public static final String COBBLESTONE = "Cobblestone";
	
	/**
	 * Represents a type of block.
	 */
	public static final String DIORITE = "Diorite";
	
	/**
	 * Represents a type of block.
	 */
	public static final String DIRT = "Dirt";
	
	/**
	 * Represents a type of block.
	 */
	public static final String GOLD_ORE = "Gold ore";
	
	/**
	 * Represents a type of block.
	 */
	public static final String GRANITE = "Granite";
	
	/**
	 * Represents a type of block.
	 */
	public static final String GRAVEL = "Gravel";
	
	/**
	 * Represents a type of block.
	 */
	public static final String IRON_ORE = "Iron ore";

	/**
	 * Represents a type of block.
	 */
	public static final String OBSIDIAN = "Obsidian";
	
	/**
	 * Represents a type of block.
	 */
	public static final String SAND = "Sand";
	
	/**
	 * Represents a type of block.
	 */
	public static final String STONE = "Stone";
	
	/**
	 * Represents a type of block.
	 */
	public static final String TNT = "Tnt";
	
	/**
	 * Represents a type of block.
	 */
	public static final String WOODPLANKS = "Wood planks";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String WOODI = "resources/Wood.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String ANDESITEI = "resources/Andesite.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String BRICKI = "resources/Brick_(Block).png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String COBBLESTONEI = "resources/Cobblestone.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String DIORITEI = "resources/Diorite.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String DIRTI = "resources/Dirt.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String GOLD_OREI = "resources/Gold_Ore.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String GRANITEI = "resources/Granite.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String GRAVELI = "resources/Gravel.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String IRON_OREI = "resources/Iron_Ore.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String OBSIDIANI = "resources/Obsidian.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String SANDI = "resources/Sand.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String STONEI = "resources/Stone.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String TNTI = "resources/TNT.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	public static final String WOODPLANKSI = "resources/Wood planks.png";
	
	/**
	 * Represents the location of the block's image.
	 */
	private String image;
	
	/**
	 * Represents the type of block of this instance.
	 */
	private String type;
	
	/**
	 * This function initializes a new Block.
	 * @param type The type of block to be initialized.
	 */
	public Block(String type) {
		this.type = type;
		switch(type) {
			case WOOD:
				image = WOODI;
			break;
			case ANDESITE:
				image = ANDESITEI;
			break;
			case BRICK:
				image = BRICKI;
			break;
			case COBBLESTONE:
				image = COBBLESTONEI;
			break;
			case DIORITE:
				image = DIORITEI;
			break;
			case DIRT:
				image = DIRTI;
			break;
			case GOLD_ORE:
				image = GOLD_OREI;
			break;
			case GRANITE:
				image = GRANITEI;
			break;
			case GRAVEL:
				image = GRAVELI;
			break;
			case IRON_ORE:
				image = IRON_OREI;
			break;
			case OBSIDIAN:
				image = OBSIDIANI;
			break;
			case SAND:
				image = SANDI;
			break;
			case STONE:
				image = STONEI;
			break;
			case TNT:
				image = TNTI;
			break;
			case WOODPLANKS:
				image = WOODPLANKSI;
			break;
		}
	}
	
	/**
	 * This function obtains the image of this block.
	 * @return The graphical image of this block.
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * This function obtains the type of block this class represents.
	 * @return The type of block.
	 */
	public String getType() {
		return type;
	}
	
}
