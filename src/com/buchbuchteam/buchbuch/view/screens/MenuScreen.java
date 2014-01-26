package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.view.Game;

public class MenuScreen extends ScreenMaster
{

	// Variables de bouttons

	public static final int buttonWidth = 250, buttonHeight = 40;
	public static final int espaceEntreButton = 15;
	public static final int buttonX = Game.WIDTH / 2 - buttonWidth / 2;
	public static final int jouerY = Game.HEIGHT / 2, controlY = jouerY
			- buttonHeight - espaceEntreButton, hightscoreY = controlY
			- buttonHeight - espaceEntreButton, creditsY = hightscoreY
			- buttonHeight - espaceEntreButton, quitterY = creditsY
			- buttonHeight - espaceEntreButton;
	public Stage stage;

	private CursorMenu curseur;

	public MenuScreen()
	{
		super("img/menu/bgmenu.png", "img/menu");

		curseur = new CursorMenu("img/menu/cursor.png");
		stage = new Stage();
		curseur.setPosition(curseur.getX(), curseur.getY());
		
		
		
		stage.addListener(new InputListener()
		{
			public boolean keyDown(InputEvent event, int keyCode)
			{
				if (keyCode == Input.Keys.UP)

				{
					curseur.monter();

					return true;
				}
				if (keyCode == Input.Keys.DOWN)
				{

					curseur.descendre();
					return true;
				}
				if (keyCode == Input.Keys.ENTER)
				{
					switch (curseur.getPosition())
					{
					case 1:
						((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
								.setScreen(GameScreen.getInstance());
						return true;
					case 2:
						((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
								.setScreen(new ControlScreen());
						return true;
					case 3:
						((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
								.setScreen(new HighScoreScreen());
						return true;
					case 4:
						((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
								.setScreen(new CreditScreen());
						return true;
					case 5:
						Gdx.app.exit();
						return true;

					default:
						return false;
					}
				}
				return false;
			}
		});
		Gdx.input.setInputProcessor(stage);
	}

	private static Animation bgAnim;
	{
		Sprite[] bgFrames = new Sprite[2];
		bgFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/menu/bgmenu.png")), 0, 0, 960, 640);
		bgFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/menu/bgmenu2.png")), 0, 0, 960, 640);

		bgAnim = new Animation(0.6F, bgFrames);
		bgAnim.setPlayMode(Animation.LOOP);
	}

	public void render(float delta)
	{

		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(bgAnim.getKeyFrame(delta), 0, 0);
		curseur.draw(stage.getSpriteBatch());

		stage.getSpriteBatch().end();

	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	public static int getJouery()
	{
		return jouerY;
	}

}