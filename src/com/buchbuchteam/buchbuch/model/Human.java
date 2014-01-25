package com.buchbuchteam.buchbuch.model;



public class Human extends Player
{
	public Human()
	{
		controllable = Team.getInstance();
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
