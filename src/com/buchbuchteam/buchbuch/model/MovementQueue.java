package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;

public class MovementQueue {

	protected LinkedList<Movement> queue;
	
	public MovementQueue(){
		queue = new LinkedList<Movement>();
	}
	
	public void add(Movement movement){
		queue.addLast(movement);
	}
	
	public Movement remove(){
		return queue.removeFirst();
	}
	
	public void Execute(){
		//TODO Execute the queue
		
		queue.remove().doMove();
	}
	
}
