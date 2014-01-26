package com.buchbuchteam.buchbuch.model;

import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class Human extends Player
{
	public Human()
	{
		controllable = Team.getInstance();
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
		if (!MovingTree.getInstance().isInplace())
			return;
		if (MovingTree.getInstance().isDying())
			return;
		controllable.up();
	}

	@Override
	public void down()
	{
		if (!MovingTree.getInstance().isInplace())
			return;
		if (MovingTree.getInstance().isDying())
			return;
		controllable.down();
	}

}
