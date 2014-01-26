package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;

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
		leavers.addLast(team.removeFirst());
		movements.add(new Movement(Movement.MovementType.LEAVE, leavers
				.getLast(), 1));
		nbBuch--;
		toLeave = false;
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
	
	public boolean isAttacking()
	{
		return team.getFirst().isAttacking();
	}

	public boolean isLeaving()
	{
		return team.getFirst().isLeaving();
	}

	public void render(Batch spriteBatch, float animTime)
	{
		if (allLeaved())
			reset();
		movements.execute();
		if (!MovingTree.getInstance().isInplace())
		{
			for (BuchBuch b : team)
			{
				spriteBatch.draw(b.getFrame(animTime), b.getX(), b.getY());
			}
		} else
		{
			for (BuchBuch b : team)
				act(spriteBatch, animTime, b);
		}
		for (BuchBuch b : leavers)
			act(spriteBatch, animTime, b);

		if (toLeave)
		{
			leave();
		}
	}

	private void act(Batch spriteBatch, float animTime, BuchBuch b)
	{
		runCry--;
		if (b.isRunning() && runCry <= 0)
		{
			b.cry();
			runCry = 1600;
		}
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

	public BuchBuch getFirst()
	{
		return team.getFirst();
	}

	public boolean allLeaved()
	{
		if (!team.isEmpty())
			return false;
		for (BuchBuch b : leavers)
			if (b.getX() > -62)
				return false;
		return true;
	}

	public boolean isEmpty()
	{
		return team.isEmpty();
	}

	public void setAttacking(boolean b)
	{
		team.getFirst().setAttacking(b);
	}

	public void setLeaving(boolean b)
	{
		team.getFirst().setLeaving(b);
	}

	public void setKo(boolean b)
	{
		// TODO Auto-generated method stub

	}
}
