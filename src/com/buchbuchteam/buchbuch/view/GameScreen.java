package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class GameScreen extends ScreenMaster
{
	private Stage stage;
	private float animTime;
	private Team buchers;
	private MovingTree tree;
	private BackGround bg;

	public GameScreen()
	{
		super("img/game/background/bggame.png");
		animTime = 0;
		stage = new Stage(960, 640, false);
		
		bg = new BackGround();
		
		buchers = new Team(250);
		tree = new MovingTree(200, 240);
	}

	@Override
	public void render(float delta)
	{
		animTime += Gdx.graphics.getDeltaTime();
		stage.act(delta);
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(bgSprite, 0, 0);
		bg.render(stage.getSpriteBatch());
		buchers.render(stage.getSpriteBatch(),animTime);
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
