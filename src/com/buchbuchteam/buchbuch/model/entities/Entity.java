package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Entity
{
	public abstract TextureRegion getFrame(float Time);
	public abstract float getX();
	public abstract float getY();
}
