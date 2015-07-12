package com.mojang.ld22.saveload;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mojang.ld22.Game;
import com.mojang.ld22.entity.Chest;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Inventory;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ResourceItem;

public class Save {
	String location = DATA.location;
	String extention = DATA.extention;
	
	private List<String> data = new ArrayList<String>();
	private List<String> inventory = new ArrayList<String>();
	private List<String> worlddata0 = new ArrayList<String>();
	private List<String> worlddata1 = new ArrayList<String>();
	private List<String> worlddata2 = new ArrayList<String>();
	private List<String> worlddata3 = new ArrayList<String>();
	private List<String> worlddata4 = new ArrayList<String>();
	private List<String> entities = new ArrayList<String>();
	@SuppressWarnings("unused")
	private Player player;
	
	public Save(String world, Player player){
		this.player = player;
		File folder = new File(location);
		folder.mkdirs();
		data.add(Game.tickCount + "");
		
		writeWorld();
		writeInventory();
		writeEntities();
		writeToFile(world);
	}
	private void writeInventory(){
		inventory.clear();
		for(int i = 0;i < Inventory.items1.size();i++){
			if (Inventory.items1.get(i) instanceof ResourceItem){
				if(!inventory.contains(Inventory.items1.get(i).getName() + ":" + Inventory.count1((Inventory.items1.get(i))))){
					inventory.add(Inventory.items1.get(i).getName() + ":" + Inventory.count1((Inventory.items1.get(i))));
				}else{
					System.out.println("Item duplicate: " + Inventory.items1.get(i).getName() + " Fixed!");
				}
			}else{
				inventory.add(Inventory.items1.get(i).getName() + ":" + "1");
			}
		}
	}
	private void writeToFile(String world) {
		File file = new File(location + world + extention);
		try {
			file.createNewFile();
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			br.write(data.toString());
			br.newLine();
			br.write(inventory.toString().replaceAll(" ", "").replaceAll("Powglove", "Pow glove")); // [test, Powglove, Test] will be [test,Pow glove,Test]
			br.newLine();
			br.write(worlddata0.toString().replaceAll(" ", ""));
			br.newLine();
			br.write(worlddata1.toString().replaceAll(" ", ""));
			br.newLine();
			br.write(worlddata2.toString().replaceAll(" ", ""));
			br.newLine();
			br.write(worlddata3.toString().replaceAll(" ", ""));
			br.newLine();
			br.write(worlddata4.toString().replaceAll(" ", ""));
			br.newLine();
			br.write(entities.toString().substring(1, entities.toString().length()-1).replaceAll(" ", ""));
			//System.out.println(entities);
			br.newLine();
			br.write("[");
			for (int i = 0; i < DATA.hasAchievements.length; i++) {
				br.write(DATA.hasAchievements[i] + ",");
			}
			br.write("]");
			
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeWorld(){
        for(int l = 0; l < Game.levels.length; l++)
        {
        	if(l == 0){
        		worlddata0.add((new StringBuilder(String.valueOf(Game.levels[l].w))).toString());
            	worlddata0.add((new StringBuilder(String.valueOf(Game.levels[l].h))).toString());
            	worlddata0.add((new StringBuilder(String.valueOf(Game.levels[l].depth))).toString());
                for(int i = 0; i < Game.levels[l].w; i++)
                {
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata0.add((new StringBuilder(String.valueOf(Game.levels[l].getTile(i, ii).id))).toString());

                }
        	}
        	if(l == 1){
        		worlddata1.add((new StringBuilder(String.valueOf(Game.levels[l].w))).toString());
            	worlddata1.add((new StringBuilder(String.valueOf(Game.levels[l].h))).toString());
            	worlddata1.add((new StringBuilder(String.valueOf(Game.levels[l].depth))).toString());
                for(int i = 0; i < Game.levels[l].w; i++)
                {
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata1.add((new StringBuilder(String.valueOf(Game.levels[l].getTile(i, ii).id))).toString());

                }
        	}
        	if(l == 2){
        		worlddata2.add((new StringBuilder(String.valueOf(Game.levels[l].w))).toString());
            	worlddata2.add((new StringBuilder(String.valueOf(Game.levels[l].h))).toString());
            	worlddata2.add((new StringBuilder(String.valueOf(Game.levels[l].depth))).toString());
                for(int i = 0; i < Game.levels[l].w; i++)
                {
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata2.add((new StringBuilder(String.valueOf(Game.levels[l].getTile(i, ii).id))).toString());

                }
        	}
        	if(l == 3){
        		worlddata3.add((new StringBuilder(String.valueOf(Game.levels[l].w))).toString());
            	worlddata3.add((new StringBuilder(String.valueOf(Game.levels[l].h))).toString());
            	worlddata3.add((new StringBuilder(String.valueOf(Game.levels[l].depth))).toString());
                for(int i = 0; i < Game.levels[l].w; i++)
                {
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata3.add((new StringBuilder(String.valueOf(Game.levels[l].getTile(i, ii).id))).toString());

                }
        	}
        	if(l == 4){
        		worlddata4.add((new StringBuilder(String.valueOf(Game.levels[l].w))).toString());
            	worlddata4.add((new StringBuilder(String.valueOf(Game.levels[l].h))).toString());
            	worlddata4.add((new StringBuilder(String.valueOf(Game.levels[l].depth))).toString());
                for(int i = 0; i < Game.levels[l].w; i++)
                {
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata4.add((new StringBuilder(String.valueOf(Game.levels[l].getTile(i, ii).id))).toString());

                }
        	}
        }

        for(int l = 0; l < Game.levels.length; l++)
        {
            for(int i = 0; i < Game.levels[l].w; i++)
            {
            	if (l == 0){
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata0.add((new StringBuilder(String.valueOf(Game.levels[l].getData(i, ii)))).toString());
            	}
            	if (l == 1){
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata1.add((new StringBuilder(String.valueOf(Game.levels[l].getData(i, ii)))).toString());
            	}
            	if (l == 2){
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata2.add((new StringBuilder(String.valueOf(Game.levels[l].getData(i, ii)))).toString());
            	}
            	if (l == 3){
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata3.add((new StringBuilder(String.valueOf(Game.levels[l].getData(i, ii)))).toString());
            	}
            	if (l == 4){
                    for(int ii = 0; ii < Game.levels[l].h; ii++)
                        worlddata4.add((new StringBuilder(String.valueOf(Game.levels[l].getData(i, ii)))).toString());
            	}

            }
        }
    }
	
	public void writeEntities(){
        for(int l = 0; l < Game.levels.length; l++){
            for(int i = 0; i < Game.levels[l].entities.size(); i++){
                Entity e = (Entity)Game.levels[l].entities.get(i);
                String name = e.getClass().getName().replace("com.mojang.ld22.entity.", "");
                String extradata = "";
                if(e instanceof Mob){
                    Mob m = (Mob)e;
                    extradata = (new StringBuilder(":")).append(m.health).append(":").append(m.maxHealth).append(":").append(m.lvl).toString();
                }
                if(e instanceof Player){
                	Player p = (Player)e;
                	extradata = (new StringBuilder(":")).append(p.health).append(":").append(p.maxHealth).append(":").append(p.lvl).toString();
                }
                if(e instanceof Chest){
                    String chestinv = "";
                    Chest c = (Chest)e;
                    for(int ii = 0; ii < c.inventory.items.size(); ii++)
                        if(c.inventory.items.get(ii) instanceof ResourceItem)
                            chestinv = (new StringBuilder(String.valueOf(chestinv))).append(((Item)c.inventory.items.get(ii)).getName()).append(";").append(c.inventory.count((Item)c.inventory.items.get(ii))).append(":").toString();
                        else
                            chestinv = (new StringBuilder(String.valueOf(chestinv))).append(((Item)c.inventory.items.get(ii)).getName()).append(":").toString();

                    extradata = (new StringBuilder(String.valueOf(extradata))).append(":").append(chestinv).toString();
                }
                //if (e instanceof Player){
                	//entities.add((new StringBuilder(String.valueOf(name))).append("[").append(e.x).append(":").append(e.y).append(extradata).append(":").append(3).append("]").toString());
                //}else if(!(e instanceof Mob)){
                if(!(e instanceof Mob)){ //Remove ! to save mobs too (Buggy)
                    entities.add((new StringBuilder(String.valueOf(name))).append("[").append(e.x).append(":").append(e.y).append(extradata).append(":").append(l).append("]").toString());
                }
                if(e instanceof Player){
                    entities.add((new StringBuilder(String.valueOf(name))).append("[").append(e.x).append(":").append(e.y).append(extradata).append(":").append(l).append("]").toString());
                }
            }

        }
    }
}
