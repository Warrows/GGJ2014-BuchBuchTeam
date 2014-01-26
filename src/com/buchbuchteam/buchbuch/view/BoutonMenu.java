package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoutonMenu {
	private SpriteBatch batch;
	private Sprite sprite;
	public static final int  width = 250, height = 40, x = Game.WIDTH/2 - width / 2;
	private int y, id;
	private String file;
	private boolean hover;
	
	BoutonMenu(String file, int y, boolean hover, int id){
		batch = new SpriteBatch();
		this.file = file;
		this.y = y;
		this.hover = hover;
		this.id = id;
		
		sprite = new Sprite(new Texture(Gdx.files.internal(file)), width, height);
		sprite.setX(x);
		sprite.setY(y);
	}
	
	public void BoutonRender(){
		batch.begin();
			sprite.draw(batch);
		batch.end();
	}

	
}
