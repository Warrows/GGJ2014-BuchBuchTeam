package com.buchbuchteam.buchbuch.model;

import java.util.LinkedList;
import com.buchbuchteam.buchbuch.model.entities.BuchBuch;

public class Team implements Controllable {

	protected LinkedList<BuchBuch> team;
	
	public Team(){
		
		this.team = new LinkedList<BuchBuch>();
		
		for (int i=0;i<4;i++){
			
			team.add(new BuchBuch());
		}
	}

	@Override
	public boolean jump() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crouch() {
		// TODO Auto-generated method stub
		return false;
	}
}
