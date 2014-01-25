package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.buchbuchteam.buchbuch.model.Movement.MovementType;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

public class Team implements Controllable
{
	private static Team instance;
	
	private float y;
	protected LinkedList<BuchBuch> team;
	protected MovementQueue movements;
	protected int nbBuch;

	private Team()
	{
		this.team = new LinkedList<BuchBuch>();
		this.movements = new MovementQueue();
		this.y = 250;
		reinit();
	}

	public void reinit()
	{
		nbBuch = 5;
		while(team.size() < nbBuch)
			team.add(new BuchBuch(-64, y));
	}

	@Override
	public void jump()
	{
		for (int i = 0; i < nbBuch; i++)
		{
			movements.add(new Movement(Movement.MovementType.JUMP, team.get(i), i));
			movements.remove().doMove();
		}
	}

	@Override
	public void crouch()
	{
		for (int i = 0; i < nbBuch; i++)
		{
			movements.add(new Movement(Movement.MovementType.CROUCH, team.get(i), i));
			movements.remove().doMove();
		}
	}
	
	public int getX(int num)
	{
		if (team.get(num) == null)
			return -1;
		return (int) team.get(num).getX();
	}

	@Override
	public void walk()
	{
		for (int i = 0; i < team.size(); i++)
		{
			movements.add(new Movement(Movement.MovementType.WALK, team.get(i), i));
			movements.remove().doMove();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < team.size(); i++)
		{
			movements.add(new Movement(Movement.MovementType.RUN, team.get(i), i));
			movements.remove().doMove();
		}
	}

	@Override
	public void leave()
	{

		movements.add(new Movement(Movement.MovementType.LEAVE, team.removeFirst(), 0));
		nbBuch--;
	}

	public void addMove(MovementType type){
		for (int i = 0; i < team.size(); i++)
		{
			movements.add(new Movement(type, team.get(i), i));
			movements.remove().doMove();
	
		}
	}
	
	public void render(Batch spriteBatch, float animTime)
	{
		for (BuchBuch b: team)
			spriteBatch.draw(b.getFrame(animTime), b.getX(), b.getY());
	}

	public static Team getInstance()
	{
		if (instance == null)
			instance = new Team();
		return instance;
	}

	public boolean ahead(float x)
	{
		for (BuchBuch b : team)
			if (b.getX() > x && b.getX() < x + 54)
				return true;
		return false;
	}
}
