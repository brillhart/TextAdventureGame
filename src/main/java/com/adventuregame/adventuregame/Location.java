package com.adventuregame.adventuregame;

import java.util.Vector;

public class Location {

	private String roomTitle;			//could also be a position on a path
	private String roomDescription;		//display this when player moves to new location
	private Vector vectorExits;
	private int locationLevel;			//this may be used as a shorthand for 
										//where the player is in the game
	
	public Location() {
		// TODO Auto-generated constructor stub
	}

}
