package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Key {

	protected int button;
	protected int x, y;
	
	public Key(int col){
		
		x = 150;
		y = 150;
		
		if (col > 0)
			button = 1;
		else 
			button = 2;
			
		
	}
	
	public TextureRegion getFrame(float Time){
		if (button == 1)
			return blueKey.getKeyFrame(Time);
		else 
			return pinkKey.getKeyFrame(Time);
	}
	
	private static Animation blueKey;
	{
		Sprite[] keyFrames = new Sprite[2];
		keyFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/game/QTE/bouton_01.png")),
				0, 0, 128, 128);
		keyFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/game/QTE/bouton_01b.png")),
				0, 0, 128, 128);
		blueKey = new Animation(0.2F, keyFrames);
		blueKey.setPlayMode(Animation.LOOP);
	}
	
	private static Animation pinkKey;
	{
		Sprite[] keyFrames = new Sprite[2];
		keyFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/game/QTE/bouton_02.png")),
				0, 0, 128, 128);
		keyFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/game/QTE/bouton_02b.png")),
				0, 0, 128, 128);
		pinkKey = new Animation(0.2F, keyFrames);
		pinkKey.setPlayMode(Animation.LOOP);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
