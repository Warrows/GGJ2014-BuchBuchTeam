package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen extends ScreenMaster{
	
	//Variables de bouttons
	
	
	public static final int buttonWidth = 250, buttonHeight=40;
	public static final int espaceEntreButton = 5;
	public static final int buttonX = Game.WIDTH/2 - buttonWidth / 2;
	public static final int jouerY = Game.HEIGHT /2, 
							controlY = jouerY - buttonHeight - espaceEntreButton,
							hightscoreY = controlY - buttonHeight - espaceEntreButton, 
							creditsY= hightscoreY - buttonHeight - espaceEntreButton, 
							quitterY = creditsY - buttonHeight - espaceEntreButton ;
	private SpriteBatch jouerBatch, controlBatch, hightscoreBatch, creditsBatch, quitterBatch;
	private Sprite jouerSprite, controlSprite, hightscoreSprite, creditsSprite, quitterSprite;
	

	protected MenuScreen() {
		super("img/menu/bgmenu.png");
		
		//batch menu
		jouerBatch = new SpriteBatch();
		controlBatch = new SpriteBatch();
		hightscoreBatch = new SpriteBatch();
		creditsBatch = new SpriteBatch();
		quitterBatch = new SpriteBatch();
		
		//sprite menu 
		
		jouerSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/jouerbutton.png")),buttonWidth,buttonHeight);
		controlSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/controlbutton.png")),buttonWidth,buttonHeight);
		hightscoreSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/hightscorebutton.png")),buttonWidth,buttonHeight);
		creditsSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/creditsbutton.png")),buttonWidth,buttonHeight);
		quitterSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/quitterbutton.png")),buttonWidth,buttonHeight);
		
		jouerSprite.setX(buttonX);
		jouerSprite.setY(jouerY);
		controlSprite.setX(buttonX);
		controlSprite.setY(controlY);
		hightscoreSprite.setX(buttonX);
		hightscoreSprite.setY(hightscoreY);
		creditsSprite.setX(buttonX);
		creditsSprite.setY(creditsY);
		quitterSprite.setX(buttonX);
		quitterSprite.setY(quitterY);
	}

	@Override
	public void render(float delta) {
		super.bgRender();
		
		jouerBatch.begin();
			jouerSprite.draw(jouerBatch);
		jouerBatch.end();
	
	controlBatch.begin();
			controlSprite.draw(controlBatch);
	controlBatch.end();
	
	hightscoreBatch.begin();
		hightscoreSprite.draw(hightscoreBatch);
	hightscoreBatch.end();
	
	creditsBatch.begin();
		creditsSprite.draw(creditsBatch);
	creditsBatch.end();
	
	quitterBatch.begin();
		quitterSprite.draw(quitterBatch);
	quitterBatch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
