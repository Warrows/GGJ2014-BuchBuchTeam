package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;
import com.buchbuchteam.buchbuch.view.GameScreen;

public class Team implements Controllable
{
	private float y;
	protected LinkedList<BuchBuch> team;
	protected MovementQueue movements;
	protected int nbBuch;

	public Team(float y)
	{
		this.team = new LinkedList<BuchBuch>();
		this.movements = new MovementQueue();
		this.y = y;
		reinit();
	}

	public void reinit()
	{
		nbBuch = 5;
	}

	@Override
	public void jump()
	{
		for (int i = 0; i < nbBuch; i++)
		{
			movements.add(new Movement(Movement.MovementType.JUMP, team.get(i)));
		}
	}

	@Override
	public void crouch()
	{
		for (int i = 0; i < nbBuch; i++)
		{
			movements.add(new Movement(Movement.MovementType.CROUCH, team
					.get(i)));
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
			movements.add(new Movement(Movement.MovementType.WALK, team.get(i)));
			movements.remove().doMove();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < team.size(); i++)
		{
			movements.add(new Movement(Movement.MovementType.RUN, team.get(i)));
			movements.remove().doMove();
		}
	}

	@Override
	public void leave()
	{

		movements.add(new Movement(Movement.MovementType.LEAVE, team
				.removeFirst()));
		nbBuch--;
	}

	public void render(Batch spriteBatch, float animTime)
	{
		if (team.isEmpty() || team.size() < nbBuch && team.getLast().getX()>0)
			team.add(new BuchBuch(-64, y));
		for (BuchBuch b: team)
			spriteBatch.draw(b.getFrame(animTime), b.getX(), b.getY());
	}
}
