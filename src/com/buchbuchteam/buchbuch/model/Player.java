package com.buchbuchteam.buchbuch.model;

public abstract class Player {

	protected Controllable controllable;
	
	public abstract boolean jump();
	public abstract boolean crouch();
	
	public void setControllable( Controllable controllable ){
		
		this.controllable = controllable;
		
	}
	
}
