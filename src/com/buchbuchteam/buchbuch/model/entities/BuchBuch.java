package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
	private int jumping;

	public BuchBuch(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.running = true;
		this.jumping = -1;


	}
	
	public void setRunning(boolean bool)
	{
		this.running = bool;
	}

	public void setJumping(boolean bool)
	{
		this.jumping = 0;
	}

	@Override
	public TextureRegion getFrame(float stateTime)
	{
		TextureRegion frame;
		if (running && !Team.getInstance().ahead(x))
			frame = run(stateTime);
		else
			frame = walk(stateTime);
		
		if (jumping>=0)
		{
			jumping ++;
			frame = jackJumping.getKeyFrame(stateTime);
			if (jumping == 60)
				jumping = -1;
		}
		return frame;
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
			return jackAttacking.getKeyFrame(stateTime);
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
	private static Animation jackAttacking;
	{
		Sprite[] jackFrames = new Sprite[3];
		jackFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackHit_01.png")),
				0, 0, 64, 92);
		jackFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackHit_02.png")),
				0, 0, 64, 92);
		jackFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackHit_03.png")),
				0	, 0, 64, 92);
		jackAttacking = new Animation(0.2F, jackFrames);
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
		Sprite[] jackFrames = new Sprite[3];
		jackFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackHit_01.png")),
				0, 5, 64, 92);
		jackFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackHit_03.png")),
				0, 15, 64, 92);
		jackFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackHit_04.png")),
				0, 5, 64, 92);
		jackJumping = new Animation(0.2F, jackFrames);
		jackJumping.setPlayMode(Animation.LOOP);
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/jump.wav"));
		sound.play(0.5f);
	}
	public static void Cry(){
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/buch.wav"));
		sound.play(0.5f);
		
	}
}
