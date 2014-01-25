package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

public class Team implements Controllable
{
	private static Team instance;

	private float y;
	protected LinkedList<BuchBuch> team;
	protected LinkedList<BuchBuch> leavers;
	protected MovementQueue movements;
	protected int nbBuch;
	private int runCry;

	private boolean toLeave;

	private Team()
	{
		this.team = new LinkedList<BuchBuch>();
		this.leavers = new LinkedList<BuchBuch>();
		this.movements = new MovementQueue();
		this.y = 250;
		this.runCry = 200;
		reinit();
	}

	public void reinit()
	{
		nbBuch = 5;
		while (team.size() < nbBuch)
			team.add(new BuchBuch(0, y));

	}

	public void jump()
	{
		for (int i = 0; i < nbBuch; i++)
		{
			movements.add(new Movement(Movement.MovementType.JUMP, team.get(i),
					i * 20));
		}
	}

	public void crouch()
	{
		for (int i = 0; i < nbBuch; i++)
		{
			movements.add(new Movement(Movement.MovementType.CROUCH, team
					.get(i), i * 20));
		}
	}

	public int getX(int num)
	{
		if (team.get(num) == null)
			return -1;
		return (int) team.get(num).getX();
	}

	public void walk()
	{
		for (int i = 0; i < team.size(); i++)
		{
			movements.add(new Movement(Movement.MovementType.WALK, team.get(i),
					0));
		}
	}

	public void run()
	{
		for (int i = 0; i < team.size(); i++)
		{
			movements.add(new Movement(Movement.MovementType.RUN, team.get(i),
					0));
		}
	}

	public void leave()
	{
		System.out.println(leavers.size());
		System.out.println(team.size());
		leavers.addLast(team.removeFirst());
		movements.add(new Movement(Movement.MovementType.LEAVE, leavers
				.getLast(), 1));
		nbBuch--;
		toLeave = false;
	}

	public boolean isEmpty()
	{
		return team.isEmpty();
	}

	public void reset()
	{
		team.addAll(leavers);
		leavers = new LinkedList<BuchBuch>();
		for (BuchBuch b : team)
		{
			b.setLeaving(false);
			b.setRunning(true);
		}
		toLeave = false;
	}

	public void render(Batch spriteBatch, float animTime)
	{
		if (allLeaved())
			reset();
		movements.execute();
		for (BuchBuch b : team)
		{
			runCry--;
			if (b.isRunning() && runCry <= 0)
			{
				b.cry();
				runCry = 1600;
			}
			spriteBatch.draw(b.getFrame(animTime), b.getX(), b.getY());
		}
		for (BuchBuch b : leavers)
		{
			runCry--;
			if (b.isRunning() && runCry <= 0)
			{
				b.cry();
				runCry = 1600;
			}
			spriteBatch.draw(b.getFrame(animTime), b.getX(), b.getY());
		}

		if (toLeave)
		{
			leave();
		}
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

	@Override
	public void up()
	{
		jump();
	}

	@Override
	public void down()
	{
		crouch();
	}

	@Override
	public void left()
	{
		walk();
	}

	@Override
	public void right()
	{
		run();
	}

	public void setToLeave(boolean b)
	{

		this.toLeave = b;

	}

	public boolean allLeaved()
	{
		if (!isEmpty())
			return false;
		for (BuchBuch b : leavers)
			if (b.getX() > -62)
				return false;
		return true;
	}
}
