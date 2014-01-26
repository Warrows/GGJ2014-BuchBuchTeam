package com.buchbuchteam.buchbuch.model;

import java.util.Iterator;
import java.util.LinkedList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.buchbuchteam.buchbuch.control.Controllable;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;

public class Team implements Controllable
{
	private static Team instance;

	private float y;
	protected LinkedList<BuchBuch> team;
	protected LinkedList<BuchBuch> leavers;
	protected LinkedList<BuchBuch> deads;
	protected MovementQueue movements;
	private int runCry;

	private boolean toLeave;
	private boolean toKill;

	private Team()
	{
		this.team = new LinkedList<BuchBuch>();
		this.leavers = new LinkedList<BuchBuch>();
		this.deads = new LinkedList<BuchBuch>();
		this.movements = new MovementQueue();
		this.y = 250;
		toKill = false;
		this.runCry = 200;
		reinit();
	}

	public void reinit()
	{
		while (team.size() < 5)
			team.add(new BuchBuch(0, y));
	}

	public void jump()
	{
		for (int i = 0; i < team.size(); i++)
		{
			if (i == 0)
				movements.add(new Movement(Movement.MovementType.JUMP, team
						.get(i), 0));
			else
			{
				movements.add(new Movement(Movement.MovementType.JUMP, team
						.get(i),
						(int) (team.get(0).getX() - team.get(i).getX()) / 3));
			}
		}
	}

	public void crouch()
	{
		for (int i = 0; i < team.size(); i++)
		{
			if (i == 0)
				movements.add(new Movement(Movement.MovementType.CROUCH, team
						.get(i), 0));
			else
				movements.add(new Movement(Movement.MovementType.CROUCH, team
						.get(i),
						(int) (team.get(0).getX() - team.get(i).getX()) / 3));
		}
	}

	public static void resetInstance(){
		instance = new Team();
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
		toLeave = false;
	}
	

	public void reset()
	{
		team.addAll(leavers);
		team.addAll(deads);
		leavers = new LinkedList<BuchBuch>();
		deads = new LinkedList<BuchBuch>();
		for (BuchBuch b : team)
		{
			b.setLeaving(false);
			b.setDead(false);
			b.setRunning(true);
		}
		GameScreen.getInstance().changeMode();
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
		while(GameScreen.getInstance().gamePaused())
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		if (allLeaved())
			reset();
		movements.execute();
		if (!MovingTree.getInstance().isInplace())
		{
			Iterator<BuchBuch> iter=team.iterator();
			while(iter.hasNext()){
			    BuchBuch b=iter.next();
				spriteBatch.draw(b.getFrame(animTime), b.getX(), b.getY());
				if (toKill)
				{
					deads.add(b);
					iter.remove();
					toKill = false;
				}
			}
		} else
		{
			for (BuchBuch b : team)
				act(spriteBatch, animTime, b);
		}
		for (BuchBuch b : leavers)
			act(spriteBatch, animTime, b);
		for (BuchBuch b : deads)
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
		for (BuchBuch b : deads)
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
		team.getFirst().setKo(b);
	}

	public boolean isFirst(BuchBuch buchBuch)
	{
		return buchBuch.equals(team.getFirst());
	}
}
