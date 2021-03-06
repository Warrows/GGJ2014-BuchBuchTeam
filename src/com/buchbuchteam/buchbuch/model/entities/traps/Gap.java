package com.buchbuchteam.buchbuch.model.entities.traps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.buchbuchteam.buchbuch.model.entities.MoveableEntity;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;

public class Gap extends MoveableEntity
{
	float x, y;

	public Gap(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public TextureRegion getFrame(float Time)
	{
		x -= 3;
		if (x < -64)
			GameScreen.getInstance().remove(this);
		return gapSprite;
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

	private static Sprite gapSprite = new Sprite(new Texture(
			Gdx.files.internal("img/game/background/text_trou.png")), 0, 0,
			128, 128);
}
