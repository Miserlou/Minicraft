package com.mojang.ld22.saveload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mojang.ld22.Game;
import com.mojang.ld22.entity.Chest;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Inventory;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.level.tile.Tile;

public class Load {
	String location = DATA.location;
	String extention = DATA.extention;
	
	private List<String> Inv = new ArrayList<String>();
	private List<String> World0 = new ArrayList<String>();
	private List<String> World1 = new ArrayList<String>();
	private List<String> World2 = new ArrayList<String>();
	private List<String> World3 = new ArrayList<String>();
	private List<String> World4 = new ArrayList<String>();
	private List<String> entities = new ArrayList<String>();
	@SuppressWarnings("unused")
	private Player player;
	
	public Load(String world, Player player){
		loadFromFile(location + world);
		loadWorld(location + world);
		loadEntities(location + world, player);
		loadInventory(location + world, player.inventory);
		loadAchievements(location + world, player.inventory);
	}

	@SuppressWarnings({ "resource", "static-access" })
	private void loadInventory(String filename, Inventory inv) {
		File file = new File(filename);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String Data = br.readLine();
			Data = br.readLine();
						
			String[] DataSplit = Data.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
			for (int i = 0;i < DataSplit.length;i++){
				Inv.add(DataSplit[i]);
			}
		} catch (Exception e) {
			System.err.println("Could not load Inventory");
		}
		inv.items.clear();
		inv.items1.clear();
		for (int i = 0;i < Inv.size();i++){
			String[] ni = Inv.get(i).split(":");
			Item newItem = Item.getItem(ni[0]);
			if(newItem instanceof ResourceItem){
				for (int ii = 0;ii < Integer.parseInt(ni[1].replaceAll("[^0-9]", ""));ii++){
					ResourceItem resItem = new ResourceItem(((ResourceItem)newItem).resource);
					inv.add(resItem);
				}
			}else{
					for (int ii = 0;ii < Integer.parseInt(ni[1].replaceAll("[^0-9]", ""));ii++){
						inv.add(newItem);
					}
			}
		}
	}
	@SuppressWarnings("resource")
	public void loadWorld(String filename){
		File file = new File(filename);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String w0 = br.readLine();
			w0 = br.readLine();
			w0 = br.readLine();
			String w1 = br.readLine();
			String w2 = br.readLine();
			String w3 = br.readLine();
			String w4 = br.readLine();
			
			String[] DataSplit_w0 = w0.split(",");
			String[] DataSplit_w1 = w1.split(",");
			String[] DataSplit_w2 = w2.split(",");
			String[] DataSplit_w3 = w3.split(",");
			String[] DataSplit_w4 = w4.split(",");
			for (int i = 0;i < DataSplit_w0.length;i++){
				World0.add(DataSplit_w0[i].replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			for (int i = 0;i < DataSplit_w1.length;i++){
				World1.add(DataSplit_w1[i].replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			for (int i = 0;i < DataSplit_w2.length;i++){
				World2.add(DataSplit_w2[i].replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			for (int i = 0;i < DataSplit_w3.length;i++){
				World3.add(DataSplit_w3[i].replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			for (int i = 0;i < DataSplit_w4.length;i++){
				World4.add(DataSplit_w4[i].replaceAll("\\[", "").replaceAll("\\]", ""));
			}
		} catch (Exception e) {
			System.err.println("Could not load World");
		}
		Game.levels[0].w = Integer.parseInt((String)World0.get(0));
        Game.levels[0].h = Integer.parseInt((String)World0.get(1));
        Game.levels[0].depth = Integer.parseInt((String)World0.get(2));
        for(int x = 0; x < Game.levels[0].w - 1; x++){
            for(int y = 0; y < Game.levels[0].h - 1; y++){
                Game.levels[0].setTile(y, x, Tile.tiles[Integer.parseInt((String)World0.get(x + y * Game.levels[0].w + 3))], Integer.parseInt((String)World0.get(x + y * Game.levels[0].w)));
            }

        }
        Game.levels[1].w = Integer.parseInt((String)World1.get(0));
        Game.levels[1].h = Integer.parseInt((String)World1.get(1));
        Game.levels[1].depth = Integer.parseInt((String)World1.get(2));
        for(int x = 0; x < Game.levels[1].w - 1; x++){
            for(int y = 0; y < Game.levels[1].h - 1; y++){
                Game.levels[1].setTile(y, x, Tile.tiles[Integer.parseInt((String)World1.get(x + y * Game.levels[1].w + 3))], Integer.parseInt((String)World1.get(x + y * Game.levels[1].w)));
            }

        }
        Game.levels[2].w = Integer.parseInt((String)World2.get(0));
        Game.levels[2].h = Integer.parseInt((String)World2.get(1));
        Game.levels[2].depth = Integer.parseInt((String)World2.get(2));
        for(int x = 0; x < Game.levels[2].w - 1; x++){
            for(int y = 0; y < Game.levels[2].h - 1; y++){
                Game.levels[2].setTile(y, x, Tile.tiles[Integer.parseInt((String)World2.get(x + y * Game.levels[2].w + 3))], Integer.parseInt((String)World2.get(x + y * Game.levels[2].w)));
            }

        }
        Game.levels[3].w = Integer.parseInt((String)World3.get(0));
        Game.levels[3].h = Integer.parseInt((String)World3.get(1));
        Game.levels[3].depth = Integer.parseInt((String)World3.get(2));
        for(int x = 0; x < Game.levels[3].w - 1; x++){
            for(int y = 0; y < Game.levels[3].h - 1; y++){
                Game.levels[3].setTile(y, x, Tile.tiles[Integer.parseInt((String)World3.get(x + y * Game.levels[3].w + 3))], Integer.parseInt((String)World3.get(x + y * Game.levels[3].w)));
            }

        }
        Game.levels[4].w = Integer.parseInt((String)World4.get(0));
        Game.levels[4].h = Integer.parseInt((String)World4.get(1));
        Game.levels[4].depth = Integer.parseInt((String)World4.get(2));
        for(int x = 0; x < Game.levels[4].w - 1; x++){
            for(int y = 0; y < Game.levels[4].h - 1; y++){
                Game.levels[4].setTile(y, x, Tile.tiles[Integer.parseInt((String)World4.get(x + y * Game.levels[4].w + 3))], Integer.parseInt((String)World4.get(x + y * Game.levels[4].w)));
            }

        }
    }
	
	@SuppressWarnings({ "resource", "unused" })
	public void loadEntities(String filename, Player player){
		
		File file = new File(filename);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String Data = br.readLine(); //tickcount
			Data = br.readLine(); //inventory
			Data = br.readLine(); //world0
			Data = br.readLine(); //world1
			Data = br.readLine(); //world2
			Data = br.readLine(); //world3
			Data = br.readLine(); //world4
			Data = br.readLine(); //ENTITIES
			
			String[] DataSplit = Data.split(",");
			for(int l = 0; l < Game.levels.length; l++){
				for (int i = 0;i < entities.size();i++){
					entities.remove(i);
				}
				for (int i = 0;i < Game.levels[l].entities.size();i++){
					Game.levels[l].entities.remove(i);
				}
			}
			for (int i = 0;i < DataSplit.length;i++){
				entities.add(DataSplit[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        for(int l = 0; l < Game.levels.length; l++){
        	for(int i = 0;i < Game.levels[l].entities.size();i++){
        		String e = Game.levels[l].entities.get(i).toString().replaceAll("com.mojang.ld22.entity.", "").replaceAll("@(.*)", "");
        		if(e.equalsIgnoreCase("Player")){
        			Game.levels[l].entities.remove(i);
        		}
        	}
        }
            //Game.levels[l].entities.clear();
        	

        for(int i = 0; i < entities.size(); i++)
        {
            Entity newEntity = DATA.getEntity(((String)entities.get(i)).substring(0, ((String)entities.get(i)).indexOf("[")), player);
            List<String> info = Arrays.asList(((String)entities.get(i)).substring(((String)entities.get(i)).indexOf("[") + 1, ((String)entities.get(i)).indexOf("]")).split(":"));
            if(newEntity != null)
            {
                newEntity.x = Integer.parseInt((String)info.get(0).toString().replaceAll("(.*)\\[", ""));
                newEntity.y = Integer.parseInt((String)info.get(1));
                if(newEntity instanceof Mob)
                {
                    Mob m = (Mob)newEntity;
                    m.health = Integer.parseInt((String)info.get(2));
                    m.maxHealth = Integer.parseInt((String)info.get(3));
                    m.lvl = Integer.parseInt((String)info.get(4));
                    m.level = Game.levels[Integer.parseInt((String)info.get(5))];
                    int currentlevel = Integer.parseInt((String)info.get(5));
                    Game.levels[currentlevel].add(m);
                } else
                if(newEntity instanceof Chest)
                {
                    Chest c = (Chest)newEntity;
                    for(int x = 3; x < info.size(); x++)
                        if(Item.getItem((String)info.get(x)) instanceof ResourceItem)
                        {
                            String name = (new StringBuilder(String.valueOf((String)info.get(x)))).append(";0").toString();
                            List<String> neww = Arrays.asList(name.split(";"));
                            Item newItem = Item.getItem(((String)name).replace(" ", ""));
                            //for(int ii = 0; ii < Integer.parseInt((String)neww.get(1)); ii++)
                                if(newItem instanceof ResourceItem)
                                {
                                    ResourceItem resItem = new ResourceItem(((ResourceItem)newItem).resource);
                                    c.inventory.add(resItem);
                                } else
                                {
                                    c.inventory.items.add(newItem);
                                }

                        } else
                        {
                            c.inventory.items.add(Item.getItem((String)info.get(x)));
                        }

                    newEntity.level = Game.levels[Integer.parseInt((String)info.get(info.size() - 1))];
                    int currentlevel = Integer.parseInt((String)info.get(info.size() - 1));
                    Game.levels[currentlevel].add(c);
                } else
                {
                    //newEntity.level = Game.levels[Integer.parseInt((String)info.get(2))];
                    newEntity.level = Game.levels[Integer.parseInt((String)info.get(2))];
                    int currentlevel = Integer.parseInt((String)info.get(2));
                    Game.levels[currentlevel].add(newEntity);
                }
            }
        }

    }
	
	@SuppressWarnings({ "resource" })
	private void loadAchievements(String filename, Inventory inv) {
		File file = new File(filename);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String Data = br.readLine(); //tickcount
			Data = br.readLine(); //inventory
			Data = br.readLine(); //world0
			Data = br.readLine(); //world1
			Data = br.readLine(); //world2
			Data = br.readLine(); //world3
			Data = br.readLine(); //world4
			Data = br.readLine(); //entities
			Data = br.readLine(); //ACHIEVEMENTS			
			
			//System.out.println(filename + ": " + Data + " - " + file);
			
			String[] DataSplit = Data.replaceAll("\\[", "").replaceAll("\\]", "").substring(0, Data.lastIndexOf(",")).split(",");
			for (int i = 0;i < DataSplit.length;i++){
				DATA.hasAchievements[i] = Boolean.parseBoolean(DataSplit[i]);
			}
		} catch (Exception e) {
			System.err.println("Could not load Achievements");
		}
	}
	
	private void loadFromFile(String world) {
		File file = new File(world);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String Data = br.readLine();
			String[] DataSplit = Data.split(",");
			for (int i = 0;i < DataSplit.length;i++){
				Game.tickCount = Integer.parseInt(DataSplit[i].replaceAll("[^0-9]", ""));
			}
			br.close();
		} catch (Exception e) {
			System.err.println("Error loading save file");
		}
		
	}
}
