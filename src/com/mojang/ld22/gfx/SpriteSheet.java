package com.mojang.ld22.gfx;

import android.graphics.Bitmap;

public class SpriteSheet {
	public int width, height;
	public int[] pixels;

	public SpriteSheet(Bitmap image) {
		width = image.getWidth();
		height = image.getHeight();
		image.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = (pixels[i] & 0xff) / 64;
		}
	}
}