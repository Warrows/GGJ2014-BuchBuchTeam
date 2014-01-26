package com.buchbuchteam.buchbuch.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.control.Human;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;
import com.buchbuchteam.buchbuch.view.Key;

public class QTE extends ScreenMaster implements InputProcessor
{
	protected Key[] keys;
	private float animTime;
	private Stage stage;
	private double score;
	private boolean left;
	private Sprite needle;

	public QTE()
	{
		super("img/game/QTE/buchVStree.png");
		animTime = 0;
		keys = new Key[2];
		keys[0] = new Key(0);
		keys[1] = new Key(1);

		needle = new Sprite(new Texture("img/game/QTE/aiguille.png"));

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

		play();

		animTime += Gdx.graphics.getDeltaTime();
		stage.act(delta);

		stage.act();
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(bgSprite, 0, 0);
		stage.getSpriteBatch().draw(keys[1].getFrame(animTime), 240, 25);
		stage.getSpriteBatch().draw(keys[0].getFrame(animTime), 600, 25);
		if (GameScreen.getInstance().getHuman().isBuchBuch())
			stage.getSpriteBatch().draw(needle, 480-54, 128, 54, 0, 108, 486, 1, 1,
					(float) (((50 - score) / 50 * 90)));
		else
			stage.getSpriteBatch().draw(needle, 480-54, 128, 54, 0, 108, 486, 1, 1,
					(float) (((score - 50) / 50 * 90)));
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
	}

	private void right()
	{
		if (!left)
		{
			score += 1;
			left = !left;
		} else
			score -= 1;
	}

	public void play()
	{
		score -= 0.05;
		if (GameScreen.getInstance().getHuman().isBuchBuch())
		{
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
		} else
		{
			if (score < 0)
			{
				buchBuchWon();
				GameScreen.getInstance().freeEntities();
				return;
			}
			if (score > 100)
			{
				treeWon();
				GameScreen.getInstance().freeEntities();
				return;
			}
		}
	}

	private void buchBuchWon()
	{
		Sound musique = Gdx.audio.newSound(Gdx.files.internal("sounds/timber.wav"));
		musique.play();
		Team.getInstance().setAttacking(false);
		Team.getInstance().setLeaving(true);
		MovingTree.getInstance().kill();
		GameScreen.getInstance().resume();
		((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
				.setScreen(GameScreen.getInstance());
		GameScreen.getInstance().resetInputProc();

		Human h = GameScreen.getInstance().getHuman();
		if (h.isBuchBuch())
			h.addScore(50);
		else
			((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
			.setScreen(new GameOver());			
	}

	private void treeWon()
	{
		((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
				.setScreen(GameScreen.getInstance());
		GameScreen.getInstance().resetInputProc();
		Team.getInstance().setKo(true);
		Human h = GameScreen.getInstance().getHuman();
		if (h.isBuchBuch())
			h.addScore(50);
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
