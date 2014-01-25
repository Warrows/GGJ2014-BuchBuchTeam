package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

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
		for (int i = 0; i < nbBuch; i++)
		{
			team.add(new BuchBuch(0, y));
		}
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

	@Override
	public void walk()
	{
		for (int i = 0; i < nbBuch; i++)
		{
			movements.add(new Movement(Movement.MovementType.WALK, team.get(i)));
			System.out.println("coucou");
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
		for (BuchBuch b: team)
			spriteBatch.draw(b.getFrame(animTime), b.getX(), b.getY());
	}
}
