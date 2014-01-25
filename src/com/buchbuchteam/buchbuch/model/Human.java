package com.buchbuchteam.buchbuch.model;

public class Human extends Player {

	@Override
	public boolean jump() {
		return controllable.jump();
	}

	@Override
	public boolean crouch() {
		return controllable.crouch();
	}

}
