package com.buchbuchteam.buchbuch.view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class MenuScreen extends ScreenMaster {
	
	//Variables de bouttons
	
	
	public static final int buttonWidth = 250, buttonHeight=40;
	public static final int espaceEntreButton = 5;
	public static final int buttonX = Game.WIDTH/2 - buttonWidth / 2;
	public static final int jouerY = Game.HEIGHT /2, 
							controlY = jouerY - buttonHeight - espaceEntreButton,
							hightscoreY = controlY - buttonHeight - espaceEntreButton, 
							creditsY= hightscoreY - buttonHeight - espaceEntreButton, 
							quitterY = creditsY - buttonHeight - espaceEntreButton ;
	private Sprite jouerSprite, controlSprite, hightscoreSprite, creditsSprite, quitterSprite;
	private Button jouerButton;

	protected MenuScreen() {
		super("img/menu/bgmenu.png");
		Gdx.input.setInputProcessor(stage);	
		//sprite menu 
		
		jouerSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/jouerbutton.png")),buttonWidth,buttonHeight);
		jouerSprite.setX(buttonX);
		jouerSprite.setY(jouerY);
		jouerButton = new Button(new SpriteDrawable(jouerSprite));
		stage.addActor(jouerButton);
		jouerButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				System.out.println("CLICK");
				((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
			}
		});

		controlSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/controlbutton.png")),buttonWidth,buttonHeight);
		controlSprite.setX(buttonX);
		controlSprite.setY(controlY);
		
		hightscoreSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/hightscorebutton.png")),buttonWidth,buttonHeight);
		hightscoreSprite.setX(buttonX);
		hightscoreSprite.setY(hightscoreY);
		
		creditsSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/creditsbutton.png")),buttonWidth,buttonHeight);
		creditsSprite.setX(buttonX);
		creditsSprite.setY(creditsY);
		
		quitterSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/quitterbutton.png")),buttonWidth,buttonHeight);
		quitterSprite.setX(buttonX);
		quitterSprite.setY(quitterY);
		
		
	}

	@Override
	public void render(float delta) {
stage.act();
stage.getSpriteBatch().begin();
stage.getSpriteBatch().draw(jouerSprite, buttonX, jouerY);
stage.getSpriteBatch().draw(controlSprite, buttonX, controlY);
stage.getSpriteBatch().draw(hightscoreSprite, buttonX, hightscoreY);
stage.getSpriteBatch().draw(creditsSprite, buttonX, creditsY);
stage.getSpriteBatch().draw(quitterSprite, buttonX, quitterY);

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
