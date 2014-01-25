package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class GameScreen extends ScreenMaster
{
	private Stage stage;
	private float animTime;
	private BuchBuch jack;
	private MovingTree tree;

	public GameScreen()
	{
		super("img/game/background/bggame.png");
		animTime = 0;
		stage = new Stage(960, 640, false);
		
		jack = new BuchBuch(100, 200);
		tree = new MovingTree(200, 200);
	}

	@Override
	public void render(float delta)
	{
		animTime += Gdx.graphics.getDeltaTime();
		stage.act(delta);
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(bgSprite, 0, 0);
		stage.getSpriteBatch().draw(jack.getFrame(animTime), jack.getX(), jack.getY());
		stage.getSpriteBatch().draw(tree.getFrame(animTime), tree.getX(), tree.getY());
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
