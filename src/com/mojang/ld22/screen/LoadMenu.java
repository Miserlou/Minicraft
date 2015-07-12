package com.mojang.ld22.screen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.saveload.Load;
import com.mojang.ld22.saveload.DATA;
import com.mojang.ld22.sound.Sound;

public class LoadMenu extends Menu {
	private Menu parent;
	private String[] options = {"Back", "AutoSave", "1", "2", "3"};
	private String[] saves = {"AutoSave.palm", "Save_1.palm", "Save_2.palm", "Save_3.palm"};
	private int selected = 0;
	String location = DATA.location;
	String extention = ".palm";
	private static List<String> data = new ArrayList<String>();
	private Player player;

	public LoadMenu(Menu parent, Player player){
		this.player = player;
		this.parent = parent;
		File folder = new File(location);
		loadAllFiles(folder);
	}
	
	static List<String> loadAllFiles(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	            if (fileEntry.isFile()){
	            	data.add(fileEntry.getName());
	            }
	        }
	    }
		return data;
		
	}

	@SuppressWarnings("unused")
	public void tick() {
		if (input.up.clicked) selected--;
		if (input.down.clicked) selected++;

		int len = options.length;
		if (selected < 0) selected += len;
		if (selected >= len) selected -= len;

		if (input.attack.clicked || input.menu.clicked) {
			if (selected == 0) {
				Sound.test.play();
				//game.resetGame();
				game.setMenu(parent);
			}else{
				Load load = new Load(saves[selected-1], player);
				game.setMenu(null);
			}
		}
		if (input.escape.clicked){
			game.setMenu(parent);
		}
	}
	
	public void render(Screen screen) {
		Font.renderFrame(screen, "Load game", 1, 1, 18, 11);
		
		for (int i = 0; i < options.length; i++) {
			String msg = options[i].replaceAll(".palm", "");
			if (i != 0){
				msg = "Load " + msg;
			}
			int col = Color.get(-1, 333, 333, 333);
			if (i == selected) {
				if (i == 0){
					msg = "> " + msg + " <";
					col = Color.get(-1, 555, 555, 555);
				}else{
					msg = "> " + msg + " <";
					col = Color.get(-1, 555, 555, 555);
				}
			}
			Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (4 + i) * 8, col);
		}


		Font.draw("(Arrow keys,X and C)", screen, 0, screen.h - 8, Color.get(0, 111, 111, 111));
	}
}
