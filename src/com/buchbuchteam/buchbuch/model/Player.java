package com.buchbuchteam.buchbuch.model;

public abstract class Player {

	protected Controllable controllable;
	
	public abstract void up();
	public abstract void down();
	public abstract void left();
	public abstract void right();
	
	public void setControllable( Controllable controllable ){
		
		this.controllable = controllable;
		
	}
	
}
