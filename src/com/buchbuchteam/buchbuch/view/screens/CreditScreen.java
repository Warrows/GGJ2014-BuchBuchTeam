package com.buchbuchteam.buchbuch.view.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CreditScreen extends ScreenMaster {
	Stage stage;
	protected CreditScreen() {
		super("img/credits/creditsBackGround.png");
		stage = new Stage();
		
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

	public void render(float delta) {
		bgRender();
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
	}}
