package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.buchbuchteam.buchbuch.model.Controllable;
import com.buchbuchteam.buchbuch.view.GameScreen;

public class MovingTree extends MoveableEntity implements Controllable
{
	private static MovingTree instance;
	
	private float x, y;
	private int firing;
	
	private MovingTree()
	{
		this.x = 700;
		this.y = 240;
		cry();
	}
	
	public void setFiring()
	{
		firing = 60;
	}

	@Override
	public TextureRegion getFrame(float stateTime)
	{
		if (firing>=0)
		{
			firing --;
			if (firing == 0)
				fireAcorn();
			return acornFireAnim.getKeyFrames()[firing/20];
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
	
	public static void cry(){
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Tree.wav"));
		sound.play(1.0f);
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
		setFiring();
	}

	private void fireAcorn()
	{
		GameScreen.getInstance().add(new Acorn(x+64, y));
	}

	@Override
	public void down()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void left()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void right()
	{
		// TODO Auto-generated method stub
		
	}



	private static Animation acornFireAnim;
	{
		Sprite[] treeFrames = new Sprite[3];
		treeFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/acorn/char_tree_gland_01.png")), 0,
				0, 128, 128);
		treeFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/acorn/char_tree_gland_02.png")), 0,
				0, 128, 128);
		treeFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/acorn/char_tree_gland_03.png")), 0,
				0, 128, 128);
		acornFireAnim = new Animation(0.2F, treeFrames);
		acornFireAnim.setPlayMode(Animation.LOOP);
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
}
