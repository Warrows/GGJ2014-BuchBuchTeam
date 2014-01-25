package com.buchbuchteam.buchbuch.model.entities;

import com.buchbuchteam.buchbuch.model.Movement.MovementType;
import com.buchbuchteam.buchbuch.model.Team;

public class World {

	protected MovingTree tree;
	protected Team buchers;
	
	public World(){
		
		buchers = Team.getInstance();
		tree = new MovingTree(700, 240);
		
	}
	
	public Team getBuchers(){
		return buchers;
	}
	
	public MovingTree getTree(){
		return tree;
	}
	
	public void moveBuchers(MovementType move){
		buchers.addMove(move);
	}
	
	public boolean hit( MoveableEntity entity1, MoveableEntity entity2){
		
		return entity1.getX() >= entity2.getX();
	}
	
}
