package com.mojang.ld22.item;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;
import com.mojang.ld22.saveload.DATA;
import com.mojang.ld22.screen.ListItem;

public class Item implements ListItem {
	public int getColor() {
		return 0;
	}

	public int getSprite() {
		return 0;
	}
	public Item addItem()
    {
        DATA.items.add(this);
        return this;
    }

    public static Item getItem(String name)
    {
        Item newItem = DATA.cloth;
        for(int i = 0; i < DATA.items.size(); i++){
            if(((Item)DATA.items.get(i)).getName().replaceAll(" ", "").equalsIgnoreCase(name.replaceAll(" ", ""))){
                newItem = (Item)DATA.items.get(i);
            }
        }

        return newItem;
    }
	public void onTake(ItemEntity itemEntity) {
	}

	public void renderInventory(Screen screen, int x, int y) {
	}

	public boolean interact(Player player, Entity entity, int attackDir) {
		return false;
	}

	public void renderIcon(Screen screen, int x, int y) {
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		return false;
	}
	
	public boolean isDepleted() {
		return false;
	}

	public boolean canAttack() {
		return false;
	}

	public int getAttackDamageBonus(Entity e) {
		return 0;
	}

	public String getName() {
		return "";
	}

	public boolean matches(Item item) {
		return item.getClass() == getClass();
	}
	
    
}
