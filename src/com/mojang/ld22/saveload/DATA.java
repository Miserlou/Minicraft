package com.mojang.ld22.saveload;

import java.util.ArrayList;
import java.util.List;

import com.mojang.ld22.entity.AirWizard;
import com.mojang.ld22.entity.Anvil;
import com.mojang.ld22.entity.Chest;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Furnace;
import com.mojang.ld22.entity.Lantern;
import com.mojang.ld22.entity.Oven;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.entity.Slime;
import com.mojang.ld22.entity.Workbench;
import com.mojang.ld22.entity.Zombie;
import com.mojang.ld22.item.FurnitureItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.PowerGloveItem;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.resource.Resource;

public class DATA {
    public static String OPERATING_SYSTEM = System.getProperty("os.name").toLowerCase();
    public static String location = "";
    public static String extention = ".palm";
    public static double version = 1.0;

    public static Entity getEntity(String string, Player player) {
        if (string.equals("Zombie"))
            return new Zombie(0);
        if (string.equals("Slime"))
            return new Slime(0);
        if (string.equals("Workbench"))
            return new Workbench();
        if (string.equals("AirWizard"))
            return new AirWizard();
        if (string.equals("Chest"))
            return new Chest();
        if (string.equals("Anvil"))
            return new Anvil();
        if (string.equals("Furnace"))
            return new Furnace();
        if (string.equals("Oven"))
            return new Oven();
        if (string.equals("Lantern"))
            return new Lantern();
        if (string.equals("Player"))
            return player;
        else
            return new Entity();
    }



    public static List < Item > items = new ArrayList < Item > ();

    public static Item powglove = (new PowerGloveItem()).addItem();
    public static Item workbench = (new FurnitureItem(new Workbench())).addItem();
    public static Item oven = (new FurnitureItem(new Oven())).addItem();
    public static Item furnace = (new FurnitureItem(new Furnace())).addItem();
    public static Item anvil = (new FurnitureItem(new Anvil())).addItem();
    public static Item chest = (new FurnitureItem(new Chest())).addItem();
    public static Item lantern = (new FurnitureItem(new Lantern())).addItem();
    public static Item cloth;
    public static Item wood;
    public static Item stone;
    public static Item flower;
    public static Item acorn;
    public static Item dirt;
    public static Item sand;
    public static Item cactusFlower;
    public static Item seeds;
    public static Item wheat;
    public static Item bread;
    public static Item apple;
    public static Item coal;
    public static Item ironOre;
    public static Item goldOre;
    public static Item ironIngot;
    public static Item goldIngot;
    public static Item slime;
    public static Item glass;
    public static Item cloud;
    public static Item gem;
    public static Item woodshvl;
    public static Item woodhoe;
    public static Item woodswrd;
    public static Item woodpick;
    public static Item woodaxe;
    public static Item rockshvl;
    public static Item rockhoe;
    public static Item rockswrd;
    public static Item rockpick;
    public static Item rockaxe;
    public static Item ironshvl;
    public static Item ironhoe;
    public static Item ironswrd;
    public static Item ironpick;
    public static Item ironaxe;
    public static Item goldshvl;
    public static Item goldhoe;
    public static Item goldswrd;
    public static Item goldpick;
    public static Item goldaxe;
    public static Item gemshvl;
    public static Item gemhoe;
    public static Item gemswrd;
    public static Item gempick;
    public static Item gemaxe;

    static {
        cloth = (new ResourceItem(Resource.cloth)).addItem();
        wood = (new ResourceItem(Resource.wood)).addItem();
        stone = (new ResourceItem(Resource.stone)).addItem();
        flower = (new ResourceItem(Resource.flower)).addItem();
        acorn = (new ResourceItem(Resource.acorn)).addItem();
        dirt = (new ResourceItem(Resource.dirt)).addItem();
        sand = (new ResourceItem(Resource.sand)).addItem();
        cactusFlower = (new ResourceItem(Resource.cactusFlower)).addItem();
        seeds = (new ResourceItem(Resource.seeds)).addItem();
        wheat = (new ResourceItem(Resource.wheat)).addItem();
        bread = (new ResourceItem(Resource.bread)).addItem();
        apple = (new ResourceItem(Resource.apple)).addItem();
        coal = (new ResourceItem(Resource.coal)).addItem();
        ironOre = (new ResourceItem(Resource.ironOre)).addItem();
        goldOre = (new ResourceItem(Resource.goldOre)).addItem();
        ironIngot = (new ResourceItem(Resource.ironIngot)).addItem();
        goldIngot = (new ResourceItem(Resource.goldIngot)).addItem();
        slime = (new ResourceItem(Resource.slime)).addItem();
        glass = (new ResourceItem(Resource.glass)).addItem();
        cloud = (new ResourceItem(Resource.cloud)).addItem();
        gem = (new ResourceItem(Resource.gem)).addItem();
        woodshvl = (new ToolItem(ToolType.shovel, 0)).addItem();
        woodhoe = (new ToolItem(ToolType.hoe, 0)).addItem();
        woodswrd = (new ToolItem(ToolType.sword, 0)).addItem();
        woodpick = (new ToolItem(ToolType.pickaxe, 0)).addItem();
        woodaxe = (new ToolItem(ToolType.axe, 0)).addItem();
        rockshvl = (new ToolItem(ToolType.shovel, 1)).addItem();
        rockhoe = (new ToolItem(ToolType.hoe, 1)).addItem();
        rockswrd = (new ToolItem(ToolType.sword, 1)).addItem();
        rockpick = (new ToolItem(ToolType.pickaxe, 1)).addItem();
        rockaxe = (new ToolItem(ToolType.axe, 1)).addItem();
        ironshvl = (new ToolItem(ToolType.shovel, 2)).addItem();
        ironhoe = (new ToolItem(ToolType.hoe, 2)).addItem();
        ironswrd = (new ToolItem(ToolType.sword, 2)).addItem();
        ironpick = (new ToolItem(ToolType.pickaxe, 2)).addItem();
        ironaxe = (new ToolItem(ToolType.axe, 2)).addItem();
        goldshvl = (new ToolItem(ToolType.shovel, 3)).addItem();
        goldhoe = (new ToolItem(ToolType.hoe, 3)).addItem();
        goldswrd = (new ToolItem(ToolType.sword, 3)).addItem();
        goldpick = (new ToolItem(ToolType.pickaxe, 3)).addItem();
        goldaxe = (new ToolItem(ToolType.axe, 3)).addItem();
        gemshvl = (new ToolItem(ToolType.shovel, 4)).addItem();
        gemhoe = (new ToolItem(ToolType.hoe, 4)).addItem();
        gemswrd = (new ToolItem(ToolType.sword, 4)).addItem();
        gempick = (new ToolItem(ToolType.pickaxe, 4)).addItem();
        gemaxe = (new ToolItem(ToolType.axe, 4)).addItem();
    }
}
