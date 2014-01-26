package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ControlScreen extends ScreenMaster{
	
	Stage stage;
	
	public ControlScreen() {
		super("img/control/controls.png");
		stage = new Stage();
	}

	public void render(float delta) {
		super.bgRender();

		stage.addListener(new InputListener()
		{
			public boolean keyDown(InputEvent event, int keyCode)
			{
				if (keyCode == Input.Keys.ESCAPE )
					
				{

					 ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new MenuScreen());
					
					
					return true;
				}
			
				return false;
			}
		});
		Gdx.input.setInputProcessor(stage);
	}

	public void resize(int width, int height) {
		
	}

	public void show() {
		
	}

	public void hide() {
		
	}

	public void pause() {
		
	}

	public void resume() {
		
	}

	public void dispose() {
		
	}

}
