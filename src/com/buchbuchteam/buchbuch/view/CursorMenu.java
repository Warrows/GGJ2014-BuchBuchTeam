package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.buchbuchteam.buchbuch.view.screens.ControlScreen;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;
import com.buchbuchteam.buchbuch.view.screens.HighScoreScreen;
import com.buchbuchteam.buchbuch.view.screens.MenuScreen;

public class CursorMenu {
	
	private SpriteBatch batch;
	private Sprite sprite;
	private String file;
	public static final int width=40, height= 40, x =250,  Ay = 15,j = 1;
	private int y, e=1;
	
	
	  public CursorMenu(String file) {
		  
		 y = MenuScreen.jouerY;
		
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal(file)), width, height);
		
		sprite.setPosition(x, y);	
	}

	  
	 
	  
	  public void CursorRender(){
		  
		  batch.begin();
		  	sprite.draw(batch);
		  	batch.end();
	  }


	


	public void Choose(){
		
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN )){
				e++;
				System.out.println(e);
				y -= 55;
				CursorRender();
				if(e > 5){
				   e --;
				}
				
				}
		if(Gdx.input.isKeyPressed(Input.Keys.UP )){
			e--;
			System.out.println(e);
			y += 55;
			CursorRender();
			if(e == 0){
			   e ++;
			}
			
			}
		
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
