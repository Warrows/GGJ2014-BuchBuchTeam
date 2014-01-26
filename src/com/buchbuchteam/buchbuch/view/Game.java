package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Game {
	
	public static final String NAME = "BushBush Game";
	public static final int SCALE = 1, WIDTH = 960 * SCALE, HEIGHT = WIDTH * 2 / 3;
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = NAME;
		cfg.useGL20 = true;
		cfg.width = WIDTH;
		cfg.height = HEIGHT;
		cfg.addIcon("img/characters/tree/acorn/Gland.png", Files.FileType.Internal);
		
		new LwjglApplication(new BushBushGame(), cfg);
	}
}
