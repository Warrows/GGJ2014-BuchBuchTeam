package com.buchbuchteam.buchbuch.model;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

public class Movement{

	protected MovementType type;
	protected BuchBuch buchbuch;
	
	public enum MovementType {
	
		JUMP,
		CROUCH,
		WALK,
		LEAVE
		
	}
	
	public Movement(MovementType type, BuchBuch buchbuch){
		this.type = type;
		this.buchbuch = buchbuch;
	}
	
	public void doMove(){
		
		//TODO Buchbuch will move, it'll just change his state.
		switch (type){
		case WALK : buchbuch.setRunning();System.out.println("2132465432143541");break;
		default : break;
		}
		
	}
	
}
