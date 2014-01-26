package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;

public class Pause {

	private Stage stage;
	private Sprite sprite;
	private String file;
	private int  width = 200, height = 100,x = 480 - width /2 , y= 320 - height /2;
	
	
	 public Pause(String file){
		this.file = file;
		stage = new Stage();
		sprite = new Sprite(new Texture(Gdx.files.internal(file)));
		sprite.setSize(width, height);
		sprite.setPosition(x, y);
		
		
		
	}


	public void PauseRender() {
			stage.getSpriteBatch().begin();
				sprite.draw(stage.getSpriteBatch());
			stage.getSpriteBatch().end();
			
	}


	public Sprite getSprite() {
		return sprite;
	}


	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	
	
}
