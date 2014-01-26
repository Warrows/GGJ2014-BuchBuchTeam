package com.buchbuchteam.buchbuch.model.entities.traps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.buchbuchteam.buchbuch.model.entities.MoveableEntity;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;

public class Root extends MoveableEntity
{
	float x, y;
	int spawn;

	public Root(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.spawn = 50;
	}

	@Override
	public TextureRegion getFrame(float Time)
	{
		x -= 3;
		if (x < -64)
			GameScreen.getInstance().remove(this);
		if (spawn > 0)
		{
			spawn --;
			return rootAnimation.getKeyFrames()[spawn/7];
		}
		return rootSprite;
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

	private static Sprite rootSprite = new Sprite(new Texture(
			Gdx.files.internal("img/characters/tree/root/Racine08.png")), 0, 0,
			128, 64);

	private static Animation rootAnimation;
	{
		Sprite[] rootSprites = new Sprite[8];
		rootSprites[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/root/Racine08.png")),
				0, 0, 128, 64);
		rootSprites[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/root/Racine07.png")),
				0, 0, 128, 64);
		rootSprites[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/root/Racine06.png")),
				0, 0, 128, 64);
		rootSprites[3] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/root/Racine05.png")),
				0, 0, 128, 64);
		rootSprites[4] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/root/Racine04.png")),
				0, 0, 128, 64);
		rootSprites[5] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/root/Racine03.png")),
				0, 0, 128, 64);
		rootSprites[6] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/root/Racine02.png")),
				0, 0, 128, 64);
		rootSprites[7] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/root/Racine01.png")),
				0, 0, 128, 64);
		rootAnimation = new Animation(0.2F, rootSprites);
	}
}
