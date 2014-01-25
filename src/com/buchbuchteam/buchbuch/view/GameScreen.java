package com.buchbuchteam.buchbuch.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.loaders.SoundLoader.SoundParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.model.Human;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class GameScreen extends ScreenMaster implements InputProcessor
{
	private static GameScreen instance;
	private Stage stage;
	private float animTime;
	private Team buchers;
	private MovingTree tree;
	private BackGround bg;
	private Human human;

	GameScreen()
	{
		super("img/game/background/bggame.png");
		animTime = 0;
		stage = new Stage(960, 640, false);
		
		bg = new BackGround();
		
		buchers = Team.getInstance();
		tree = new MovingTree(700, 240);
		human = new Human();
		BuchBuch.Cry();
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
		
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			buchers.run();
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			buchers.walk();
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
			buchers.jump();
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Input.Keys.A))
			System.out.println("YOLO");
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public static GameScreen getInstance()
	{
		if (instance == null)
			instance = new GameScreen();
		return instance;
	}

	public MovingTree getTree()
	{
		return tree;
	}

}
