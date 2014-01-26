package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class CursorMenu extends Sprite
{

	public static final int width = 40, height = 40, x = 310;
	public static final int j = 1;
	private int y, e = 1;

	public CursorMenu(String file)
	{
		super(new Texture(Gdx.files.internal("img/menu/cursor.png")), width,
				height);

		y = MenuScreen.jouerY;
		setPosition(x, y);

	}

	public void monter()
	{
		if (e <= 1)
			return;
		y = y + 47;
		e--;
		setY(y);

	}

	public void descendre()
	{
		if (e >= 5)
			return;
		y = y - 47;
		e++;
		setY(y);
	}
}
