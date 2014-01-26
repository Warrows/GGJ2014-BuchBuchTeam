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
	
	public GameOver()
	{
		super("img/menu/gameover.png");
		stage = new Stage();
		font = new BitmapFont(Gdx.files.internal("data/game.fnt"));
		stage = new Stage();
	
		
		stage.addListener(new InputListener()
		{
			public boolean keyDown(InputEvent event, int keyCode)
			{
				if (keyCode == Input.Keys.ENTER){
					GameScreen.resetInstance();
					((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
					.setScreen(GameScreen.getInstance());
					return true;
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
