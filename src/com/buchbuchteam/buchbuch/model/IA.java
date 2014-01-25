package com.buchbuchteam.buchbuch.model;

import java.util.Random;

import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class IA extends Player
{
	public IA()
	{
		controllable = MovingTree.getInstance();
	}

	public void play()
	{
		if (controllable instanceof MovingTree)
			playTree();
		else
			playTeam();
	}

	private void playTeam()
	{
		int i = new Random().nextInt() % 100;
		if (i == 0)
			right();
		if (i == 1)
			up();
		if (i == 2)
			left();
	}

	private void playTree()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void right()
	{
		controllable.right();
	}

	@Override
	public void left()
	{
		controllable.left();
	}

	@Override
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
