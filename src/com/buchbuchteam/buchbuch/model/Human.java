package com.buchbuchteam.buchbuch.model;

import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class Human extends Player
{
	protected long score;
	
	public Human()
	{
		controllable = Team.getInstance();
		score = 0;
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
	
	public boolean isTree(){
		return controllable instanceof MovingTree ;
	}
	
	public boolean isBuchBuch(){
		return controllable instanceof Team;
	}

	public void addScore(long points){
		this.score += points;
	}
	
	public void remScore(long points){
		this.score -= points;
	}
	
}
