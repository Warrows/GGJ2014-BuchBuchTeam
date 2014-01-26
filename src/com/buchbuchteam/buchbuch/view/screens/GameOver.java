package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameOver extends ScreenMaster
{
	
	protected BitmapFont font;
	private Stage stage;
	
	public GameOver()
	{
		super("img/menu/gameover.png");
		stage = new Stage();
		font = new BitmapFont(Gdx.files.internal("data/game.fnt"));
		stage = new Stage();
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
