package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;

public class AboutMenu extends Menu {
	private Menu parent;

	public AboutMenu(Menu parent) {
		this.parent = parent;
	}

	public void tick() {
		if (input.attack.clicked || input.menu.clicked) {
			game.setMenu(parent);
		}
	}

	public void render(Screen screen) {
		screen.clear(0);

		Font.draw("About Minicraft", screen, 2 * 8 + 4, 1 * 8, Color.get(0, 555, 555, 555));
		Font.draw("Minicraft was made", screen, 0 * 8 + 4, 3 * 8, Color.get(0, 333, 333, 333));
		Font.draw("by Markus Persson", screen, 0 * 8 + 4, 4 * 8, Color.get(0, 333, 333, 333));
		Font.draw("For the 22'nd ludum", screen, 0 * 8 + 4, 5 * 8, Color.get(0, 333, 333, 333));
		Font.draw("dare competition in", screen, 0 * 8 + 4, 6 * 8, Color.get(0, 333, 333, 333));
		Font.draw("december 2011.", screen, 0 * 8 + 4, 7 * 8, Color.get(0, 333, 333, 333));
		Font.draw("it is dedicated to", screen, 0 * 8 + 4, 9 * 8, Color.get(0, 333, 333, 333));
		Font.draw("my father. <3", screen, 0 * 8 + 4, 10 * 8, Color.get(0, 333, 333, 333));
	}
}
