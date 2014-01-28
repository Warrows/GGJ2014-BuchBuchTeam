package com.buchbuchteam.buchbuch.control;

import java.util.Random;

import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.MovingTree;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;

public class IA extends Player
{
	
	private int time;
	
	public IA()
	{
		controllable = MovingTree.getInstance();
		time = 0;
	}

	public void play()
	{
		playRandom();
		return;
		/*if (controllable instanceof MovingTree)
			playTree();
		else
			playTeam();*/
	}

	private void playRandom()
	{
		if (controllable instanceof MovingTree)
			playTree();
		else
			playTeam();
	}

	private void playTeam()
	{
		time++;
		if (time%20==0){
		
			int r = new Random().nextInt() % 5;
			r = Math.abs(r);
			//System.out.println(r);
			int x = Team.getInstance().getX(0);
			int i = 4;
			
			if ( GameScreen.getInstance().hasRoot(x+32) ){
				//if ( r==0 || r==1 || r ==2)
					i = 1;
			} else if ( GameScreen.getInstance().hasAcorn(x+32) ){
				//if (r==0 || r==1 || r ==2)
					i = 2;
			} else if(r==3 || r==4) {
					i=0;
			} else {
				
			}
			
			if (i == 0)
				right();
			if (i == 1)
				up();
			if (i == 2)
				down();
			if (i == 3)
				up();
			if (i == 4)
				left();
		}
	}

	private void playTree()
	{
		int i = new Random().nextInt() % 100;
		if (i == 0)
			right();
		if (i == 1 || i == 2 || i == 3)
			left();
	}

	@Override
	public void right()
	{
		if (!MovingTree.getInstance().isInplace())
			return;
		if (MovingTree.getInstance().isDying())
			return;
		controllable.right();
	}

	@Override
	public void left()
	{
		if (!MovingTree.getInstance().isInplace())
			return;
		if (MovingTree.getInstance().isDying())
			return;
		controllable.left();
	}

	@Override
	public void up()
	{
		controllable.up();
	}

	@Override
	public void down()
	{
		controllable.down();
	}

}
