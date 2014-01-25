package com.buchbuchteam.buchbuch.model;

import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class IA extends Player
{
	public IA()
	{
		controllable = MovingTree.getInstance();
	}

	public void toggleMode()
	{
		// TODO Auto-generated method stub

	}

	public void right()
	{
		controllable.right();
	}

	public void left()
	{
		controllable.left();
	}

	public void up()
	{
		controllable.up();
	}

	@Override
	public void down()
	{
		controllable.down();
	}

}
