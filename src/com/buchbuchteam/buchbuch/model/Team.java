package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

public class Team implements Controllable
{

	protected LinkedList<BuchBuch> team;
	protected MovementQueue movements;
	protected int nbBuch;

	public Team()
	{

		this.team = new LinkedList<BuchBuch>();
		this.movements = new MovementQueue();
		reinit();
	}

	public void reinit()
	{
		nbBuch = 5;
		for (int i = 0; i < nbBuch; i++)
		{
			team.add(new BuchBuch(0, 200));
		}
	}

	@Override
	public void jump()
	{
		for (int i = 0; i < nbBuch; i++)
		{
			movements
					.add(new Movement(Movement.MovementType.JUMP, team.get(i)));
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
			movements
					.add(new Movement(Movement.MovementType.WALK, team.get(i)));
		}
	}

	@Override
	public void leave()
	{

		movements.add(new Movement(Movement.MovementType.LEAVE, team
				.removeFirst()));
		nbBuch--;
	}
}
