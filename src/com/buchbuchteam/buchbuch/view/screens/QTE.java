package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.control.Human;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;
import com.buchbuchteam.buchbuch.view.BackGround;
import com.buchbuchteam.buchbuch.view.Key;

public class QTE extends ScreenMaster implements InputProcessor
{

	protected Key[] keys;
	private float animTime;
	private Stage stage;
	private BackGround bg;
	private double score;
	private boolean left;

	public QTE()
	{
		super("img/game/QTE/buchVStree.png");
		animTime = 0;
		keys = new Key[2];
		keys[0] = new Key(0);
		keys[1] = new Key(1);

		bg = new BackGround();
		stage = new Stage(960, 640, false);
		score = 50;
		left = true;

		stage.addListener(new InputListener()
		{
			public boolean keyDown(InputEvent event, int keyCode)
			{
				if (keyCode == Input.Keys.RIGHT)
				{
					right();
					return true;
				}
				if (keyCode == Input.Keys.LEFT)
				{
					left();
					return true;
				}
				return false;
			}
		});
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta)
	{
		super.bgRender();

		score -= 0.05;
		if (score < 0)
		{
			treeWon();
			GameScreen.getInstance().freeEntities();
			return;
		}
		if (score > 100)
		{
			buchBuchWon();
			GameScreen.getInstance().freeEntities();
			return;
		}

		animTime += Gdx.graphics.getDeltaTime();
		stage.act(delta);

		stage.act();
		stage.getSpriteBatch().begin();

		stage.getSpriteBatch().draw(bgSprite, 0, 0);

		stage.getSpriteBatch().draw(keys[1].getFrame(animTime), 240, 25);
		stage.getSpriteBatch().draw(keys[0].getFrame(animTime), 600, 25);

		stage.getSpriteBatch().end();
	}

	private void left()
	{
		if (left)
		{
			score += 1;
			left = !left;
		} else
			score -= 1;
		System.out.println(score);
	}

	private void right()
	{
		if (!left)
		{
			score += 1;
			left = !left;
		} else
			score -= 1;
		System.out.println(score);
	}

	public void play()
	{

		// buchBuchWon();
	}

	private void buchBuchWon()
	{
		Team.getInstance().setAttacking(false);
		Team.getInstance().setLeaving(true);
		MovingTree.getInstance().kill();
		GameScreen.getInstance().resume();
		((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
				.setScreen(GameScreen.getInstance());
		GameScreen.getInstance().resetInputProc();
		
		Human h = GameScreen.getInstance().getHuman();
		if( h.isBuchBuch() )
			h.addScore(50);
		else
			h.remScore(50);
	}

	private void treeWon()
	{
		((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
				.setScreen(GameScreen.getInstance());
		GameScreen.getInstance().resetInputProc();
		Team.getInstance().setKo(true);
		Human h = GameScreen.getInstance().getHuman();
		if( h.isTree() )
			h.addScore(50);
		else
			h.remScore(50);
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
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean keyDown(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Auto-generated method stub
		return false;
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

}
