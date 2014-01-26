package com.buchbuchteam.buchbuch.control;

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
		playRandom();
		return;
		/*if (controllable instanceof MovingTree)
			playTree();
		else
			playTeam();*/
	}

	private void playRandom()
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
			down();
		if (i == 3)
			up();
		if (i == 4)
			down();
	}

	private void playTree()
	{
		int i = new Random().nextInt() % 100;
		if (i == 0)
			right();
		if (i == 1)
			up();
		if (i == 2)
			left();
		if (i == 3)
			down();
	}

	@Override
	public void right()
	{
		if (!MovingTree.getInstance().isInplace())
			return;
		if (MovingTree.getInstance().isDying())
			return;
		controllable.right();
	}

	@Override
	public void left()
	{
		if (!MovingTree.getInstance().isInplace())
			return;
		if (MovingTree.getInstance().isDying())
			return;
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
