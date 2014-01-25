package com.buchbuchteam.buchbuch.model;

public abstract class Player {

	protected Controllable controllable;
	
	public abstract void jump();
	public abstract void crouch();
	
	public void setControllable( Controllable controllable ){
		
		this.controllable = controllable;
		
	}
	
}
