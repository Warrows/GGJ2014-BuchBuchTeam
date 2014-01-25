package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MovingTree extends MoveableEntity
{
	private float x, y;
	
	public MovingTree(float x, float y)
	{
		this.x = x;
		this.y = y;
		Cry();
	}

	@Override
	public TextureRegion getFrame(float stateTime)
	{
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
	
	public static void Cry(){
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Tree.wav"));
		sound.play(0.5f);
		sound.loop();
	}
	
	
}
