package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;




public abstract class ScreenMaster  implements Screen {
	
	//CREATION DE LA CAMERA
		private OrthographicCamera camera;
		
		//VARIABLES DU BACKGROUND
		protected Stage stage; //BATCH DU SPRITE DE FOND
		protected Sprite bgSprite; //SPRITE DE FOND
		private String file; //CHEMIN DE L'IMAGE DE FOND
		private int bgWidth = Game.WIDTH, bgHeight = Game.HEIGHT, bgX = 0, bgY = 0; //VARIABLE IMAGE DE FOND

		protected ScreenMaster(String file){
			
			camera = new OrthographicCamera();
			this.file = file;
		
			
			stage = new Stage();
			bgSprite = new Sprite(new Texture(Gdx.files.internal(file)), bgX, bgY, bgWidth, bgHeight);
			
			
			
			
		}
		public abstract void render(float delta);

		public abstract void resize(int width, int height);

		public  abstract void show();

		public abstract void hide();

		public abstract void pause();
		public abstract void resume();

		public abstract void dispose();
		
		public void bgRender(){
			
		
				{
					stage.act();
				stage.getSpriteBatch().begin();
				stage.getSpriteBatch().draw(bgSprite, 0, 0);
				stage.getSpriteBatch().end();
			
			
			
		}
		
	
		}
		}
