package com.buchbuchteam.buchbuch.model;

public class Speed
{
	public static float walk = 1;
	public static float projectile = 3;
	
	private static float save;
	
	public static void pause()
	{
		save = walk;
		walk = 0;
	}
	public static void unpause()
	{
		walk = save;
	}
}
