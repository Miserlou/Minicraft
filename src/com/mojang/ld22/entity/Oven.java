package com.mojang.ld22.entity;

import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.screen.CraftingMenu;

public class Oven extends Furniture {
	public Oven() {
		super("Oven");
		col = Color.get(-1, 000, 332, 442);
		sprite = 2;
		xr = 3;
		yr = 2;
	}

	public boolean use(Player player, int attackDir) {
		player.game.setMenu(new CraftingMenu(Crafting.ovenRecipes, player));
		return true;
	}
}