package com.mojang.ld22.item;

public class ToolType {
	public static ToolType shovel = new ToolType("Shvl", 0);
	public static ToolType hoe = new ToolType("Hoe", 1);
	public static ToolType sword = new ToolType("Swrd", 2);
	public static ToolType pickaxe = new ToolType("Pick", 3);
	public static ToolType axe = new ToolType("Axe", 4);

	public final String name;
	public final int sprite;

	private ToolType(String name, int sprite) {
		this.name = name;
		this.sprite = sprite;
	}
}
