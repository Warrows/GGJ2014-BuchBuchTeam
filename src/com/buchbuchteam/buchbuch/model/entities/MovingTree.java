package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.buchbuchteam.buchbuch.control.Controllable;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.traps.Acorn;
import com.buchbuchteam.buchbuch.model.entities.traps.Root;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;

public class MovingTree extends MoveableEntity implements Controllable
{
	private static MovingTree instance;

	private float x, y;
	private int firing;
	private int rooting;
	private int dying;
	private int wait;
	private static Sound sound;

	// TODO wait 90
	// TODO sortie QTE tree

	private MovingTree()
	{
		this.x = 1100;
		this.y = 240;
		this.dying = 0;
		this.rooting = 0;
		cry();
	}

	public void setFiring()
	{
		if (wait > 0)
			return;
		firing = 70;
		wait = 110;
	}

	private void setRooting()
	{
		if (wait > 0)
			return;
		rooting = 70;
		wait = 110;
	}

	@Override
	public TextureRegion getFrame(float stateTime)
	{
		wait--;
		if (x > 800)
			x-=1;
		if (dying > 0)
		{
			dying--;
			if (dying == 0)
			{
				this.x = 1100;
				this.y = 240;
			}
			return treeDie.getKeyFrames()[dying / 24];
		}

		if (firing > 0 && x<=800)
		{
			rooting = 0;
			firing--;
			if (firing == 10)
				fireAcorn();
			return acornFireAnim.getKeyFrames()[firing / 24];
		}

		if (rooting > 0 && x<=800)
		{
			firing = 0;
			rooting--;
			if (rooting == 10)
				fireRoot();
			return rootFireAnim.getKeyFrames()[rooting / 24];
		}
		return treeAnim.getKeyFrame(stateTime);
	}

	@Override
	public float getX()
	{
		return x;
	}

	@Override
	public float getY()
	{
		return y;
	}

	public static void cry()
	{
		sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Tree.wav"));
		sound.play();
		sound.loop();
	}

	public static MovingTree getInstance()
	{
		if (instance == null)
			instance = new MovingTree();
		return instance;
	}

	@Override
	public void up()
	{
		// TODO Auto-generated method stub
	}

	private void fireAcorn()
	{
		if (Team.getInstance().ahead(700))
			return;
		GameScreen.getInstance().add(new Acorn(x + 32, y + 48));
	}

	private void fireRoot()
	{
		if (Team.getInstance().ahead(700))
			return;
		GameScreen.getInstance().add(new Root(x + 32, y));
	}

	@Override
	public void down()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void left()
	{
		setFiring();
	}

	@Override
	public void right()
	{
		setRooting();
	}

	public void kill()
	{
		dying = 180;
		Team.getInstance().walk();
	}

	private static Animation acornFireAnim;
	{
		Sprite[] treeFrames = new Sprite[3];
		treeFrames[0] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/char_tree_gland_03.png")),
				0, 0, 128, 128);
		treeFrames[1] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/char_tree_gland_02.png")),
				0, 0, 128, 128);
		treeFrames[2] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/acorn/char_tree_gland_01.png")),
				0, 0, 128, 128);
		acornFireAnim = new Animation(0.2F, treeFrames);
		acornFireAnim.setPlayMode(Animation.LOOP);
	}
	private static Animation rootFireAnim;
	{
		Sprite[] treeFrames = new Sprite[3];
		treeFrames[0] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/root/char_tree_racine03.png")),
				0, 0, 128, 128);
		treeFrames[1] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/root/char_tree_racine02.png")),
				0, 0, 128, 128);
		treeFrames[2] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/root/char_tree_racine01.png")),
				0, 0, 128, 128);
		rootFireAnim = new Animation(0.2F, treeFrames);
		rootFireAnim.setPlayMode(Animation.LOOP);
	}
	private static Animation treeAnim;
	{
		Sprite[] treeFrames = new Sprite[3];
		treeFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/char_tree01.png")), 0,
				0, 128, 128);
		treeFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/char_tree02.png")), 0,
				0, 128, 128);
		treeFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/char_tree03.png")), 0,
				0, 128, 128);
		treeAnim = new Animation(0.2F, treeFrames);
		treeAnim.setPlayMode(Animation.LOOP);
	}
	private static Animation treeDie;
	{
		Sprite[] treeFrames = new Sprite[9];
		treeFrames[0] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death09.png")),
				0, 0, 128, 128);
		treeFrames[1] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death08.png")),
				0, 0, 128, 128);
		treeFrames[2] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death07.png")),
				0, 0, 128, 128);
		treeFrames[3] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death06.png")),
				0, 0, 128, 128);
		treeFrames[4] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death05.png")),
				0, 0, 128, 128);
		treeFrames[5] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death04.png")),
				0, 0, 128, 128);
		treeFrames[6] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death03.png")),
				0, 0, 128, 128);
		treeFrames[7] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death02.png")),
				0, 0, 128, 128);
		treeFrames[8] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/tree/death/char_tree_death01.png")),
				0, 0, 128, 128);
		treeDie = new Animation(0.1F, treeFrames);
		treeDie.setPlayMode(Animation.LOOP);
	}

	public boolean isInplace()
	{
		return x <= 800;
	}

	public boolean isDying()
	{
		return dying > 0;
	}

	public static void resetInstance()
	{
		instance = new MovingTree();

	}

	public void stopcry() {
		
		sound.stop();
	}
}
