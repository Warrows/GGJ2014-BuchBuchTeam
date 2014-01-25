package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen extends ScreenMaster
{
	private Animation jack;
	private Animation tree;
	private Stage stage;
	private float animTime;

	public GameScreen()
	{
		super("img/game/background/bggame.png");
		animTime = 0;
		stage = new Stage(960, 640, false);
		
		{
			Sprite[] jackFrames = new Sprite[4];
			jackFrames[0] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/jack/char_jackMarche.png")),
					0, 0, 64, 64);
			jackFrames[1] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/jack/char_jackMarche.png")),
					64, 0, 64, 64);
			jackFrames[2] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/jack/char_jackMarche.png")),
					128, 0, 64, 64);
			jackFrames[3] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/jack/char_jackMarche.png")),
					192, 0, 64, 64);
			jack = new Animation(0.2F, jackFrames);
			jack.setPlayMode(Animation.LOOP);
		}
		
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
	}

	@Override
	public void render(float delta)
	{
		animTime += Gdx.graphics.getDeltaTime();
		stage.act(delta);
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(bgSprite, 0, 0);
		stage.getSpriteBatch().draw(jack.getKeyFrame(animTime), 100*animTime % (960-64), 200);
		stage.getSpriteBatch().draw(tree.getKeyFrame(animTime), 80*animTime % (960-128), 200);
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
