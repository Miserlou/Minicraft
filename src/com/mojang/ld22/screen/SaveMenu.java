package com.mojang.ld22.screen;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.saveload.Save;
import com.mojang.ld22.sound.Sound;

public class SaveMenu extends Menu {
	private Menu parent;
	private int selected = 0;
	private String[] options = {"Back", "Save 1", "Save 2", "Save 3"};
	private Player player;
	
	public SaveMenu(Menu parent, Player player) {
		this.player = player;
		this.parent = parent;		
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
			}
			if (selected > 0) {
				Sound.test.play();
				Save save = new Save("Save_" + selected, player);
				game.setMenu(null);
			}
		}
		if (input.escape.clicked){
			game.setMenu(parent);
		}
	}
	
	public void render(Screen screen) {
		Font.renderFrame(screen, "Save game", 14, 1, 30, 20);
		
		for (int i = 0; i < options.length; i++) {
			String msg = options[i];
			int col = Color.get(-1, 333, 333, 333);
			if (i == selected) {
				msg = "> " + msg + " <";
				col = Color.get(-1, 555, 555, 555);
			}
			Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (4 + i) * 8, col);
		}

		Font.draw("(Arrow keys,X and C)", screen, 0, screen.h - 8, Color.get(0, 111, 111, 111));
	}
}
