package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class BackGround
{
	private int anim;

	public BackGround()
	{
		anim = 0;
	}

	public void render(Batch spriteBatch)
	{
		anim++;
		anim %= 128;
		for (int i = 0; i <= 8; i++)
		{
			spriteBatch.draw(groundSprite, 128 * i - anim, 180);
			spriteBatch.draw(undergroundSprite, 128 * i - anim, 180 - 128);
			spriteBatch.draw(undergroundSprite, 128 * i - anim, 180 - 256);
		}
	}

	private static Sprite undergroundSprite = new Sprite(new Texture(
			Gdx.files.internal("img/game/background/text_underground.png")), 0,
			0, 128, 128);

	private static Sprite groundSprite = new Sprite(new Texture(
			Gdx.files.internal("img/game/background/text_plat.png")), 0, 0,
			128, 128);

}
