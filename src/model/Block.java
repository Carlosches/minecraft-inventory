package model;

public class Block {

	public static final String WOOD = "Wood";
	public static final String ANDESITE = "Andesite";
	public static final String BRICK = "Brick";
	public static final String COBBLESTONE = "Cobblestone";
	public static final String DIORITE = "Diorite";
	public static final String DIRT = "Dirt";
	public static final String GOLD_ORE = "Gold ore";
	public static final String GRANITE = "Granite";
	public static final String GRAVEL = "Gravel";
	public static final String IRON_ORE = "Iron ore";
	public static final String OBSIDIAN = "Obsidian";
	public static final String SAND = "Sand";
	public static final String STONE = "Stone";
	public static final String TNT = "Tnt";
	public static final String WOODPLANKS = "Wood planks";
	public static final String WOODI = "resources/Wood.png";
	public static final String ANDESITEI = "resources/Andesite.png";
	public static final String BRICKI = "resources/Brick_(Block).png";
	public static final String COBBLESTONEI = "resources/Cobblestone.png";
	public static final String DIORITEI = "resources/Diorite.png";
	public static final String DIRTI = "resources/Dirt.png";
	public static final String GOLD_OREI = "resources/Gold_Ore.png";
	public static final String GRANITEI = "resources/Granite.png";
	public static final String GRAVELI = "resources/Gravel.png";
	public static final String IRON_OREI = "resources/Iron_Ore.png";
	public static final String OBSIDIANI = "resources/Obsidian.png";
	public static final String SANDI = "resources/Sand.png";
	public static final String STONEI = "resources/Stone.png";
	public static final String TNTI = "resources/TNT.png";
	public static final String WOODPLANKSI = "resources/Wood planks.png";
	private String image;
	private String type;
	/**
	 * @param image
	 * @param type
	 */
	public Block(String image, String type) {
		this.image = image;
		this.type = type;
	}
	
	
	
}
