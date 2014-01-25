package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BuchBuch extends MoveableEntity
{
	private float x, y;
	private boolean running;

	public BuchBuch(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.running = false;
	}

	public void setRunning(){
		this.running = !this.running;
	}
	
	@Override
	public TextureRegion getFrame(float stateTime)
	{
		if (running){
			x += 2;
			return jackRunning.getKeyFrame(stateTime);
		} else {
			if (x==0) x=0;
			else x--;
		}
		return jackWalking.getKeyFrame(stateTime);
	}
	
	public TextureRegion getRunningFrame(float animTime)
	{
		return jackRunning.getKeyFrame(animTime);
	}

	@Override
	public float getX()
	{
		return x;
	}

	@Override
	public float getY()
	{
		return y;
	}

	private static Animation jackWalking;
	{
		Sprite[] jackFrames = new Sprite[4];
		jackFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackMarche.png")),
				0, 0, 64, 64);
		jackFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackMarche.png")),
				64, 0, 64, 64);
		jackFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackMarche.png")),
				128, 0, 64, 64);
		jackFrames[3] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackMarche.png")),
				192, 0, 64, 64);
		jackWalking = new Animation(0.2F, jackFrames);
		jackWalking.setPlayMode(Animation.LOOP);
	}
	private static Animation jackRunning;
	{
		Sprite[] jackFrames = new Sprite[3];
		jackFrames[0] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackCours_01.png")),
				0, 0, 64, 64);
		jackFrames[1] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackCours_02.png")),
				0, 0, 64, 64);
		jackFrames[2] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackCours_03.png")),
				0, 0, 64, 64);
		jackRunning = new Animation(0.2F, jackFrames);
		jackRunning.setPlayMode(Animation.LOOP);
	}
}
