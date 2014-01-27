package com.buchbuchteam.buchbuch.model.entities.traps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.buchbuchteam.buchbuch.model.Speed;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;
import com.buchbuchteam.buchbuch.model.entities.MoveableEntity;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;

public class Acorn extends MoveableEntity
{
	float x, y;
	boolean isDead;
	boolean isActive;
	protected int deading;
	private BuchBuch buchbuch;
	
	public Acorn(float x, float y)
	{
		this.x = x;
		this.y = y;
		isDead = false;
		isActive = true;
	}

	@Override
	public TextureRegion getFrame(float Time)
	{
		if (isDead){
			x += Speed.projectile;
			return acornDeath(Time);
		} else {
			x -= Speed.projectile * Speed.walk;
		}
		if (x < 0)
			GameScreen.getInstance().remove(this);
		
		return acornSprite;
	}

	public TextureRegion acornDeath(float Time){
		
		//TextureRegion frame;
		
		deading++;
		if (deading >= 28){
			isDead=false;
			GameScreen.getInstance().remove(this);
			buchbuch.die();
		}
		return deadAcorn.getKeyFrames()[deading / 4];
		
	}
	
	public void setDeath(boolean b, BuchBuch buch){
		if (isActive()){
			isActive=false;
			isDead = true;
			x -= 51;
			y -= 51;
			buchbuch = buch;
		}
	}
	
	public boolean isActive(){
		return isActive;
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
	
	private static Animation deadAcorn;
	private static Sprite[] acornFrames;
	{
		acornFrames = new Sprite[8];
		acornFrames[0] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/death/GlandExpl_01.png")),
				0, 0, 155, 134);
		acornFrames[1] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/death/GlandExpl_02.png")),
				0, 0, 155, 134);
		acornFrames[2] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/death/GlandExpl_03.png")),
				0, 0, 155, 134);
		acornFrames[3] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/death/GlandExpl_04.png")),
				0, 0, 155, 134);
		acornFrames[4] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/death/GlandExpl_05.png")),
				0, 0, 155, 134);
		acornFrames[5] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/death/GlandExpl_06.png")),
				0, 0, 155, 134);
		acornFrames[6] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/death/GlandExpl_07.png")),
				0, 0, 155, 134);
		acornFrames[7] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/death/GlandExpl_08.png")),
				0, 0, 155, 134);
		deadAcorn = new Animation(0.2F, acornFrames);
		deadAcorn.setPlayMode(Animation.LOOP);
	}

	private static Sprite acornSprite = new Sprite(new Texture(
			Gdx.files.internal("img/characters/tree/acorn/Gland.png")), 0, 0,
			32, 32);

	public boolean isFinish() {
		return ! isDead;
	}
}
