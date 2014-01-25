package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

public class Team implements Controllable {

	protected LinkedList<BuchBuch> team;
	protected MovementQueue movements;
	
	public Team(){
		
		this.team = new LinkedList<BuchBuch>();
		this.movements = new MovementQueue();
		
		for (int i=0;i<4;i++){
			
			team.add(new BuchBuch());
		}
	}

	@Override
	public boolean jump() {
		for ( int i=0; i < 4; i++){
			movements.add(new Movement(Movement.MovementType.JUMP, team.get(i)));
		}
		return false;
	}

	@Override
	public boolean crouch() {
		// TODO Auto-generated method stub
		return false;
	}
}
