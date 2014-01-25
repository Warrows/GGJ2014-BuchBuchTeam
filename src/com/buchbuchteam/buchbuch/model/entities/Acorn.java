package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Acorn extends MoveableEntity
{
	float x, y;

	public Acorn(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public TextureRegion getFrame(float Time)
	{
		x -= 1;
		return acornSprite;
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


	private static Sprite acornSprite = new Sprite(new Texture(
			Gdx.files.internal("img/characters/tree/acorn/Gland.png")), 0,
			0, 960, 640);
}
