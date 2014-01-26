package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class QTE extends ScreenMaster implements InputProcessor
{

	protected Key[] keys;
	private float animTime;
	private Stage stage;
	private static QTE instance;
	private BackGround bg;

	protected QTE()
	{

		super("img/game/QTE/buchVStree.png");
		animTime = 0;
		keys = new Key[2];
		keys[0] = new Key(0);
		keys[1] = new Key(1);

		bg = new BackGround();
		stage = new Stage(960, 640, false);
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

		stage.getSpriteBatch().end();
	}

	public void play()
	{
		// TODO

		buchBuchWon();
	}

	private void buchBuchWon()
	{
		Team.getInstance().setAttacking(false);
		Team.getInstance().setLeaving(true);
		MovingTree.getInstance().kill();
		GameScreen.getInstance().resume();
		((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
				.setScreen(GameScreen.getInstance());
	}

	private void treeWon()
	{
		((com.badlogic.gdx.Game) Gdx.app.getApplicationListener())
				.setScreen(GameScreen.getInstance());
		Team.getInstance().setKo(true);
	}

	public static QTE getInstance()
	{
		if (instance == null)
			instance = new QTE();
		return instance;
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
