package com.buchbuchteam.buchbuch.model;

import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

public class Movement
{

	protected MovementType type;
	protected BuchBuch buchbuch;
	protected int delay;

	public enum MovementType
	{

		JUMP, CROUCH, WALK, RUN, LEAVE

	}

	public Movement(MovementType type, BuchBuch buchbuch, int delay)
	{
		this.type = type;
		this.buchbuch = buchbuch;
		this.delay = delay;
	}

	public void doMove()
	{

		// TODO Buchbuch will move, it'll just change his state.
		switch (type)
		{
		case WALK:
			buchbuch.setRunning(false);
			break;
		case RUN:
			buchbuch.setRunning(true);
			break;
		case JUMP:
			buchbuch.setJumping(true);
			buchbuch.jumpCry();
			break;
		case CROUCH :
			buchbuch.setCrouch(true);break;
		default:
			break;
		}

	}

	public int getDelay()
	{
		return delay;
	}

	public void pass()
	{
		delay--;
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Movement))
			return false;
		if (!(((Movement) o).getDelay() <= delay + 50))
			return false;
		if (!((Movement) o).buchbuch.equals(this.buchbuch))
			return false;
		if (!((Movement) o).type.equals(this.type))
			return false;
		return true;

	}

}
