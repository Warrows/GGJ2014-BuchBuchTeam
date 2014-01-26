package com.buchbuchteam.buchbuch.view.screens;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.buchbuchteam.buchbuch.control.Human;
import com.buchbuchteam.buchbuch.control.IA;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.Entity;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;
import com.buchbuchteam.buchbuch.model.entities.traps.Gap;
import com.buchbuchteam.buchbuch.view.BackGround;

public class GameScreen extends ScreenMaster
{
	private static GameScreen instance;
	private Stage stage;
	private float animTime;
	private Team buchers;
	private MovingTree tree;
	private BackGround bg;
	private Human human;
	private IA ia;
	private Set<Entity> entitiesToRender;
	private Set<Entity> entitiesToRemove;

	public GameScreen()
	{
		super("img/game/background/bggame.png");
		animTime = 0;
		stage = new Stage(960, 640, false);

		bg = new BackGround();

		buchers = Team.getInstance();
		tree = MovingTree.getInstance();
		human = new Human();
		ia = new IA();
		entitiesToRemove = new HashSet<Entity>();

		stage.addListener(new InputListener()
		{
			public boolean keyDown(InputEvent event, int keyCode)
			{
				if (keyCode == Input.Keys.RIGHT)
				{
					human.right();
					return true;
				}
				if (keyCode == Input.Keys.LEFT)
				{
					human.left();
					return true;
				}
				if (keyCode == Input.Keys.UP)
				{
					human.up();
					return true;
				}
				if (keyCode == Input.Keys.DOWN)
				{
					human.down();
					return true;
				}
				if (keyCode == Input.Keys.A)
				{
					changeMode();
					return true;
				}
				return false;
			}
		});
		Gdx.input.setInputProcessor(stage);
		freeEntities();
	}

	@Override
	public void render(float delta)
	{
		ia.play();
		if (new Random().nextInt() % 300 == 1)
			entitiesToRender.add(new Gap(1100, 200));

		animTime += Gdx.graphics.getDeltaTime();
		stage.act(delta);
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(bgSprite, 0, 0);
		bg.render(stage.getSpriteBatch());
		entitiesToRender.removeAll(entitiesToRemove);
		System.out.println(entitiesToRender.size());
		for (Entity entity : entitiesToRender)
		{
			stage.getSpriteBatch().draw(entity.getFrame(animTime),
					entity.getX(), entity.getY());
		}
		buchers.render(stage.getSpriteBatch(), animTime);
		stage.getSpriteBatch().draw(tree.getFrame(animTime), tree.getX(),
				tree.getY());
		stage.getSpriteBatch().end();
	}

	public void changeMode()
	{
		human.toggleMode();
		ia.toggleMode();
	}
	
	public Human getHuman(){
		return human;
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

	public void add(Entity entity)
	{
		entitiesToRender.add(entity);
	}

	public void remove(Entity entity)
	{
		entitiesToRemove.add(entity);
	}

	public void resetInputProc()
	{
		Gdx.input.setInputProcessor(stage);
	}

	public void freeEntities()
	{
		entitiesToRender = new HashSet<Entity>();
	}

	public boolean hasGap(float x)
	{
		for (Entity g: entitiesToRender)
		{
			//System.out.println(g);
			if (!(g instanceof Gap))
				continue;
			System.out.println("    a    ");
			if (x > ((Gap)g).getX() && x < 64 + ((Gap)g).getX())
				return true;
		}
		return false;
	}

}
