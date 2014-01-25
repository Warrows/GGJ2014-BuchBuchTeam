package com.buchbuchteam.buchbuch.model;

public class Human extends Player {

	@Override
	public void jump() {
		controllable.jump();
	}

	@Override
	public void crouch() {
		controllable.crouch();
	}

	@Override
	public void walk() {
		controllable.walk();
	}

	@Override
	public void leave() {
		controllable.leave();
	}

}
