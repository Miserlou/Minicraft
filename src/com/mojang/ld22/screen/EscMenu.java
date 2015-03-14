package com.mojang.ld22.screen;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.sound.Sound;

public class EscMenu extends Menu {
	private Player player;
	private int selected = 0;
	private String[] options = {"Resume", "Save game", "Load game", "How to play", "Main menu", "Quit"};

	public EscMenu(Player player) {
		this.player = player;

	}

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
				game.setMenu(null);
			}
			if (selected == 1) game.setMenu(new SaveMenu(this, player));
			if (selected == 2) game.setMenu(new LoadMenu(this, player));
			if (selected == 3) game.setMenu(new InstructionsMenu(this));
			if (selected == 4) game.setMenu(new TitleMenu());
			if (selected == 5) System.exit(0);
		}
		if (input.escape.clicked) {
			Sound.test.play();
			game.setMenu(null);
		}
	}

	public void render(Screen screen) {
		Font.renderFrame(screen, "Menu", 14, 1, 30, 20);
		
		for (int i = 0; i < options.length; i++) {
			String msg = options[i];
			int col = Color.get(-1, 333, 333, 333);
			if (i == selected) {
				msg = "> " + msg + " <";
				col = Color.get(-1, 555, 555, 555);
			}
			Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (4 + i) * 8, col);
		}
		if (selected == 2 || selected == 4 | selected == 5){
			int col = Color.get(-1, 500, 500, 500);
			String msg = "Warning";
			int i = 0;
			Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (6 + i) * 16, col);
			msg = "Unsaved data";
			i = 1;
			Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (6 + i) * 16, col);
			msg= "will be lost!";
			i = 2;
			Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (6 + i) * 16, col);

		}

		Font.draw("(Arrow keys,X and C)", screen, 0, screen.h - 8, Color.get(0, 111, 111, 111));
	}
}
