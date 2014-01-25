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
	private boolean running,jumping;

	public BuchBuch(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.running = true;
		this.jumping = false;


	}
	
	public void setRunning(boolean bool)
	{
		this.running = bool;
	}

	public void setJumping(boolean bool)
	{
		this.jumping = bool;
		resetJackJumping();
	}

	@Override
	public TextureRegion getFrame(float stateTime)
	{
		TextureRegion frame;
		if (running && !Team.getInstance().ahead(x))
			frame = run(stateTime);
		else
			frame = walk(stateTime);
		
		if (jumping)
		{
			frame = jackJumping.getKeyFrame(stateTime);
		}
		return frame;
	}

	private TextureRegion walk(float stateTime)
	{
		x-=0.5;
		if (x <= 0)
			x = 0;
		return jackWalking.getKeyFrame(stateTime);
	}

	private TextureRegion run(float stateTime)
	{
		x += 1.5;
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
		Sprite[] jackFrames = new Sprite[8];
		jackFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/hit/char_jackHitTake_01.png")),
				0, 0, 64, 92);
		jackFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/hit/char_jackHitTake_02.png")),
				0, 0, 64, 92);
		jackFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/hit/char_jackHitTake_03.png")),
				0, 0, 64, 92);
		jackFrames[3] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/hit/char_jackHitTake_04.png")),
				0, 0, 64, 92);
		jackFrames[4] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/hit/char_jackHitTake_05.png")),
				0, 0, 64, 92);
		jackFrames[5] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/hit/char_jackHitTake_06.png")),
				0, 0, 64, 92);
		jackFrames[6] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/hit/char_jackHitTake_07.png")),
				0, 0, 64, 92);
		jackFrames[7] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/hit/char_jackHitTake_08.png")),
				0, 0, 64, 92);
		jackAttacking = new Animation(0.2F, jackFrames);
		jackAttacking.setPlayMode(Animation.NORMAL);
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
	private static Sprite jackJumpingSprite;
	{
		Sprite[] jackJumping = new Sprite[5];
		jackJumping[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackJump_01.png")),
				0, 5, 64, 92);
		jackJumping[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackJump_02.png")),
				0, 15, 64, 92);
		jackJumping[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackJump_03.png")),
				0, 5, 64, 92);
		jackJumping[3] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackJump_04.png")),
				0, 15, 64, 92);
		jackJumping[4] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackJump_05.png")),
				0, 5, 64, 92);
	}
	private void resetJackJumping()
	{
		jackJumping = new Animation(0.2F, jackJumpingSprite);
		jackJumping.setPlayMode(Animation.NORMAL);
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/jump.wav"));
		sound.play(0.5f);
	}
	public static void Cry(){
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/buch.wav"));
		sound.play(0.5f);
		
	}
}
