package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.view.Game;

public class GameOver extends ScreenMaster
{
	
	protected BitmapFont font;
	private Stage stage;
	
	public static final int buttonWidth = 250, buttonHeight=40;
	public static final int espaceEntreButton = 15;
	public static final int buttonX = Game.WIDTH/2 - buttonWidth / 2;
	public static final int restartY = Game.HEIGHT /2, 
							exitY = restartY - buttonHeight - espaceEntreButton;
	
	protected CursorMenu cursor;
	
	public GameOver()
	{
		super("img/menu/gameover.png");
		stage = new Stage();
		font = new BitmapFont(Gdx.files.internal("data/game.fnt"));
		stage = new Stage();
	
		cursor = new CursorMenu("img/characters/jack/char_jackCours_03.png", 2);
		
		stage.addListener(new InputListener()
		{
			public boolean keyDown(InputEvent event, int keyCode)
			{
				if (keyCode == Input.Keys.UP)

				{
					cursor.monter();

					return true;
				}
				if (keyCode == Input.Keys.DOWN)
				{

					cursor.descendre();
					return true;
				}
				if (keyCode == Input.Keys.ENTER){
					
					switch (cursor.getPosition())
					{
						case 1:
							((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
								.setScreen(GameScreen.getInstance());
							return true;
						case 2:
							Gdx.app.exit(); return true;
						default :
							return false;
					}
				}
				return false;
			}
		});
		Gdx.input.setInputProcessor(stage);
	}

	
	
	@Override
	public void render(float delta)
	{
		super.bgRender();
		
		stage.getSpriteBatch().begin();
		
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.draw(stage.getSpriteBatch(), "SCORE : "+GameScreen.getInstance().getHuman().getScore(), 350, 600);
		cursor.draw(stage.getSpriteBatch());
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

}
