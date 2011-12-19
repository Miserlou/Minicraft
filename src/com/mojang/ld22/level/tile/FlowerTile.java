package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.level.Level;

public class FlowerTile extends GrassTile {
	public FlowerTile(int id) {
		super(id);
		tiles[id] = this;
		connectsToGrass = true;
	}

	public void render(Screen screen, Level level, int x, int y) {
		super.render(screen, level, x, y);

		int data = level.getData(x, y);
		int shape = (data / 16) % 2;
		int flowerCol = Color.get(10, level.grassColor, 555, 440);

		if (shape == 0) screen.render(x * 16 + 0, y * 16 + 0, 1 + 1 * 32, flowerCol, 0);
		if (shape == 1) screen.render(x * 16 + 8, y * 16 + 0, 1 + 1 * 32, flowerCol, 0);
		if (shape == 1) screen.render(x * 16 + 0, y * 16 + 8, 1 + 1 * 32, flowerCol, 0);
		if (shape == 0) screen.render(x * 16 + 8, y * 16 + 8, 1 + 1 * 32, flowerCol, 0);
	}

	public boolean interact(Level level, int x, int y, Player player, Item item, int attackDir) {
		if (item instanceof ToolItem) {
			ToolItem tool = (ToolItem) item;
			if (tool.type == ToolType.shovel) {
				if (player.payStamina(4 - tool.level)) {
					level.add(new ItemEntity(new ResourceItem(Resource.flower), x * 16 + random.nextInt(10) + 3, y * 16 + random.nextInt(10) + 3));
					level.add(new ItemEntity(new ResourceItem(Resource.flower), x * 16 + random.nextInt(10) + 3, y * 16 + random.nextInt(10) + 3));
					level.setTile(x, y, Tile.grass, 0);
					return true;
				}
			}
		}
		return false;
	}

	public void hurt(Level level, int x, int y, Mob source, int dmg, int attackDir) {
		int count = random.nextInt(2) + 1;
		for (int i = 0; i < count; i++) {
			level.add(new ItemEntity(new ResourceItem(Resource.flower), x * 16 + random.nextInt(10) + 3, y * 16 + random.nextInt(10) + 3));
		}
		level.setTile(x, y, Tile.grass, 0);
	}
}