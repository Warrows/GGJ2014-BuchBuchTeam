package com.buchbuchteam.buchbuch.control;

import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public abstract class Player
{

	protected Controllable controllable;

	public abstract void up();
	public abstract void down();
	public abstract void left();
	public abstract void right();

	public void setControllable(Controllable controllable)
	{
		this.controllable = controllable;
	}

	public void toggleMode()
	{
		if (controllable.equals(MovingTree.getInstance()))
			controllable = Team.getInstance();
		else
			controllable = MovingTree.getInstance();
	}
}
