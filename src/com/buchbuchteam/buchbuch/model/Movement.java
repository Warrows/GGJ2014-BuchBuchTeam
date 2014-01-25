package com.buchbuchteam.buchbuch.model;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

public class Movement{

	protected MovementType type;
	protected BuchBuch buchbuch;
	protected int delay;
	
	public enum MovementType {
	
		JUMP,
		CROUCH,
		WALK,
		RUN,
		LEAVE
		
	}
	
	public Movement(MovementType type, BuchBuch buchbuch, int delay){
		this.type = type;
		this.buchbuch = buchbuch;
		this.delay = delay;
	}
	
	public void doMove(){
		
		//TODO Buchbuch will move, it'll just change his state.
		switch (type){
		case WALK : buchbuch.setRunning(false);break;
		case RUN : buchbuch.setRunning(true);break;
		case JUMP: buchbuch.setJumping(true);break;
		default : break;
		}
		
	}
	
}
