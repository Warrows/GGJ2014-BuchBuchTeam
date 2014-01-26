package com.buchbuchteam.buchbuch.model;

import java.util.Iterator;
import java.util.LinkedList;

import com.buchbuchteam.buchbuch.model.entities.MovingTree;

public class MovementQueue
{

	protected LinkedList<Movement> queue;

	public MovementQueue()
	{
		queue = new LinkedList<Movement>();
	}

	public void add(Movement movement)
	{
		if (queue.contains(movement))
			return;
		queue.addLast(movement);
	}

	public Movement remove()
	{
		return queue.removeFirst();
	}

	public void execute()
	{
		Iterator<Movement> i = queue.iterator();
		while (i.hasNext())
		{
			Movement m = i.next();
			m.pass();
			if (m.getDelay() <= 0)
			{
				m.doMove();
				i.remove();
			}
		}
	}

}
