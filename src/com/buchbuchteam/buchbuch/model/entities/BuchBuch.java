package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.view.GameScreen;

public class BuchBuch extends MoveableEntity
{
	private float x, y;
	private boolean running;

	public BuchBuch(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.running = true;
	}

	public void setRunning(boolean bool)
	{
		this.running = bool;
	}

	@Override
	public TextureRegion getFrame(float stateTime)
	{
		if (jumping)
		{
			return jackJumping.getKeyFrame(stateTime);
		}
		if (running && !Team.getInstance().ahead(x))
			return run(stateTime);
		return walk(stateTime);
	}

	private TextureRegion walk(float stateTime)
	{
		x--;
		if (x <= 0)
			x = 0;
		return jackWalking.getKeyFrame(stateTime);
	}

	private TextureRegion run(float stateTime)
	{
		x += 2;
		if (x >= GameScreen.getInstance().getTree().getX())
		{
			setRunning(false);
		}
		return jackRunning.getKeyFrame(stateTime);
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
	private static Animation jackJumping;
	{
		Sprite[] jackFrames = new Sprite[6];
		jackFrames[0] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackHit_01.png")),
				0, 0, 64, 64);
		jackFrames[1] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackHit_02.png")),
				0, 0, 64, 64);
		jackFrames[2] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackHit_03.png")),
				0, 0, 64, 64);
		jackFrames[3] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackHit_04.png")),
				0, 0, 64, 64);
		jackFrames[4] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackHit_05.png")),
				0, 0, 64, 64);
		jackFrames[5] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackHit_06.png")),
				0, 0, 64, 64);
		jackJumping = new Animation(0.2F, jackFrames);
		jackJumping.setPlayMode(Animation.LOOP);
	}
}
