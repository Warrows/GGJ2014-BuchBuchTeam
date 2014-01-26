package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class CursorMenu {
	
	private Stage stage;
	private Sprite sprite;
	private String file;
	public static final int width=40, height= 40, x =250;
	public static int Ay = 55;
	public static final int j = 1;
	private int y, e=1;
	
	
	  public CursorMenu(String file) {
		  
		 y = MenuScreen.jouerY;
		
		stage = new Stage();
		sprite = new Sprite(new Texture(Gdx.files.internal(file)), width, height);
		
		stage.addListener(new InputListener()
		{
			public boolean keyDown(InputEvent event, int keyCode)
			{
				if (keyCode == Input.Keys.UP && e > 1)
					
				{

					
					System.out.println(e);
					sprite.setPosition(x, y = y + Ay);
					
				
					
				
					   e --;
					
					return true;
				}
				if (keyCode == Input.Keys.DOWN && e <5)
				{

					
					System.out.println(e);
					sprite.setPosition(x, y = y - Ay);
					
				
					
				
					   e ++;
					
					return true;
				}
				return false;
			}
		});

		Gdx.input.setInputProcessor(stage);
		sprite.setPosition(x, y);	
	}

	  
	 
	  
	  public void CursorRender(){
		  
		  stage.getSpriteBatch().begin();
		  	sprite.draw(stage.getSpriteBatch());
		  	
		  	stage.getSpriteBatch().end();
	  }


	


	public void Choose(){
		
		
	
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER  )){
			System.out.println("ENTER");
			switch (e){
			case 1: ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
					System.out.println("JOUER");
				break;
			case 2: ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new ControlScreen());
			System.out.println("CONTROL");
				break;
			case 3: ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new HighScoreScreen());
			System.out.println("HIGH SCORE");
				break;
			case 4: ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new ControlScreen());
			System.out.println("CREDITS");
				break;
			case 5: Gdx.app.exit();
			System.out.println("QUITTER");
				break;
				
			default: 
				System.out.println("NONE");
			}
			
			
		}
			
		 
		  
	  }
	
	
	
	

}
