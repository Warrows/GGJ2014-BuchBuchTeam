package com.buchbuchteam.buchbuch.view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

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
	private Button jouerButton, controlButton, hightscoreButton, creditsButton, quitterButton;
	
	private BuchBuch jack;
	private Animation tree;
	private float animTime;

	protected MenuScreen() {
		super("img/menu/bgmenu.png");
		Gdx.input.setInputProcessor(stage);	
		jack = new BuchBuch(4, 0);
		
		{
			Sprite[] treeFrames = new Sprite[3];
			treeFrames[0] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/tree/char_tree01.png")),
					0, 0, 128, 128);
			treeFrames[1] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/tree/char_tree02.png")),
					0, 0, 128, 128);
			treeFrames[2] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/tree/char_tree03.png")),
					0, 0, 128, 128);
			tree = new Animation(0.2F, treeFrames);
			tree.setPlayMode(Animation.LOOP);
		}
	

		//sprite menu 
		
		jouerSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/jouerbutton.png")),buttonWidth,buttonHeight);
		jouerSprite.setX(buttonX);
		jouerSprite.setY(jouerY);
		jouerButton = new Button(new SpriteDrawable(jouerSprite));
		stage.addActor(jouerButton);
		jouerButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				jouerButton.removeListener(this);
				controlButton.removeListener(this);
				hightscoreButton.removeListener(this);
				creditsButton.removeListener(this);
				quitterButton.removeListener(this);
			}
		});

		controlSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/controlbutton.png")),buttonWidth,buttonHeight);
		controlSprite.setX(buttonX);
		controlSprite.setY(controlY);
		controlButton = new Button(new SpriteDrawable(jouerSprite));
		stage.addActor(controlButton);
		controlButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				jouerButton.removeListener(this);
				controlButton.removeListener(this);
				hightscoreButton.removeListener(this);
				creditsButton.removeListener(this);
				quitterButton.removeListener(this);
			}
		});
		
		hightscoreSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/hightscorebutton.png")),buttonWidth,buttonHeight);
		hightscoreSprite.setX(buttonX);
		hightscoreSprite.setY(hightscoreY);
		
		hightscoreButton = new Button(new SpriteDrawable(jouerSprite));
		stage.addActor(hightscoreButton);
		hightscoreButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				jouerButton.removeListener(this);
				controlButton.removeListener(this);
				hightscoreButton.removeListener(this);
				creditsButton.removeListener(this);
				quitterButton.removeListener(this);
			}
		});
		
		creditsSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/creditsbutton.png")),buttonWidth,buttonHeight);
		creditsSprite.setX(buttonX);
		creditsSprite.setY(creditsY);
		creditsButton = new Button(new SpriteDrawable(jouerSprite));
		stage.addActor(creditsButton);
		creditsButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				jouerButton.removeListener(this);
				controlButton.removeListener(this);
				hightscoreButton.removeListener(this);
				creditsButton.removeListener(this);
				quitterButton.removeListener(this);
			}
		});
		
		quitterSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/quitterbutton.png")),buttonWidth,buttonHeight);
		quitterSprite.setX(buttonX);
		quitterSprite.setY(quitterY);
		quitterButton = new Button(new SpriteDrawable(jouerSprite));
		stage.addActor(quitterButton);
		quitterButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				jouerButton.removeListener(this);
				controlButton.removeListener(this);
				hightscoreButton.removeListener(this);
				creditsButton.removeListener(this);
				quitterButton.removeListener(this);
			}
		});
		
		
	}

	@Override
	public void render(float delta) {
		super.bgRender();
		animTime += Gdx.graphics.getDeltaTime();
		stage.act(delta);
		
stage.act();
stage.getSpriteBatch().begin();

stage.getSpriteBatch().draw(bgSprite, 0, 0);

stage.getSpriteBatch().draw(jouerSprite, buttonX, jouerY);
stage.getSpriteBatch().draw(controlSprite, buttonX, controlY);
stage.getSpriteBatch().draw(hightscoreSprite, buttonX, hightscoreY);
stage.getSpriteBatch().draw(creditsSprite, buttonX, creditsY);
stage.getSpriteBatch().draw(quitterSprite, buttonX, quitterY);


stage.getSpriteBatch().draw(jack.getRunningFrame(animTime),  (100*animTime %1160) - 196, 20);
stage.getSpriteBatch().draw(tree.getKeyFrame(animTime), 50 + (100*animTime %1160) - 96 ,  4);

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
