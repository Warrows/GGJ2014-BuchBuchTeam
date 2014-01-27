package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class HighScoreScreen extends ScreenMaster {
	Stage stage;
	public HighScoreScreen() {
		super("img/menu/bgmenu.png");
		stage = new Stage();
	}

	@Override
	public void render(float delta) {
		super.bgRender();
		
		stage.addListener(new InputListener()
		{
			public boolean keyDown(InputEvent event, int keyCode)
			{
				if (keyCode == Input.Keys.ESCAPE )
					
				{

					 ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(MenuScreen.getInstance());
					
					
					return true;
				}
			
				return false;
			}
		});
		
	Gdx.input.setInputProcessor(stage);
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
