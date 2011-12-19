package com.mojang.ld22.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final Sound playerHurt = new Sound("/playerhurt.wav");
	public static final Sound playerDeath = new Sound("/death.wav");
	public static final Sound monsterHurt = new Sound("/monsterhurt.wav");
	public static final Sound test = new Sound("/test.wav");
	public static final Sound pickup = new Sound("/pickup.wav");
	public static final Sound bossdeath = new Sound("/bossdeath.wav");
	public static final Sound craft = new Sound("/craft.wav");

	private AudioClip clip;

	private Sound(String name) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(name));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			new Thread() {
				public void run() {
					clip.play();
				}
			}.start();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}