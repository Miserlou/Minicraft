package com.mojang.ld22.level.tile;

import java.util.Random;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.level.Level;

public class Tile {
	public static int tickCount = 0;
	protected Random random = new Random();

	public static Tile[] tiles = new Tile[256];
	public static Tile grass = new GrassTile(0);
	public static Tile rock = new RockTile(1);
	public static Tile water = new WaterTile(2);
	public static Tile flower = new FlowerTile(3);
	public static Tile tree = new TreeTile(4);
	public static Tile dirt = new DirtTile(5);
	public static Tile sand = new SandTile(6);
	public static Tile cactus = new CactusTile(7);
	public static Tile hole = new HoleTile(8);
	public static Tile treeSapling = new SaplingTile(9, grass, tree);
	public static Tile cactusSapling = new SaplingTile(10, sand, cactus);
	public static Tile farmland = new FarmTile(11);
	public static Tile wheat = new WheatTile(12);
	public static Tile lava = new LavaTile(13);
	public static Tile stairsDown = new StairsTile(14, false);
	public static Tile stairsUp = new StairsTile(15, true);
	public static Tile infiniteFall = new InfiniteFallTile(16);
	public static Tile cloud = new CloudTile(17);
	public static Tile hardRock = new HardRockTile(18);
	public static Tile ironOre = new OreTile(19, Resource.ironOre);
	public static Tile goldOre = new OreTile(20, Resource.goldOre);
	public static Tile gemOre = new OreTile(21, Resource.gem);
	public static Tile cloudCactus = new CloudCactusTile(22);

	public final byte id;

	public boolean connectsToGrass = false;
	public boolean connectsToSand = false;
	public boolean connectsToLava = false;
	public boolean connectsToWater = false;

	public Tile(int id) {
		this.id = (byte) id;
		if (tiles[id] != null) throw new RuntimeException("Duplicate tile ids!");
		tiles[id] = this;
	}

	public void render(Screen screen, Level level, int x, int y) {
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		return true;
	}

	public int getLightRadius(Level level, int x, int y) {
		return 0;
	}

	public void hurt(Level level, int x, int y, Mob source, int dmg, int attackDir) {
	}

	public void bumpedInto(Level level, int xt, int yt, Entity entity) {
	}

	public void tick(Level level, int xt, int yt) {
	}

	public void steppedOn(Level level, int xt, int yt, Entity entity) {
	}

	public boolean interact(Level level, int xt, int yt, Player player, Item item, int attackDir) {
		return false;
	}

	public boolean use(Level level, int xt, int yt, Player player, int attackDir) {
		return false;
	}

	public boolean connectsToLiquid() {
		return connectsToWater || connectsToLava;
	}
}