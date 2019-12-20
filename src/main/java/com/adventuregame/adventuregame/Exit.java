package com.adventuregame.adventuregame;

public class Exit {
	
	private static final int UNDEFINED = 0;
	private static final int NORTH = 1;
	private static final int NORTHEAST = 2;
	private static final int EAST = 3;
	private static final int SOUTHEAST = 4;
	private static final int SOUTH = 5;
	private static final int SOUTHWEST = 6;
	private static final int WEST = 7;
	private static final int NORTHWEST = 8;
	private static final int IN = 11;
	private static final int OUT = 12;
	
	public final String[] dirName = {
			"UNDEFINED", 
			"NORTH", 
			"NORTHEAST", 
			"EAST", 
			"SOUTHEAST", 
			"SOUTH", 
			"SOUTHWEST", 
			"WEST",
			"NORTHWEST",
			"IN", 
			"OUT"
	};
	
	private Location leadsTo = null;
	private String roomLocation;
	private int direction;
	private String directionName;

	//default constructor
	public Exit() {
		this.direction = Exit.UNDEFINED;
		this.leadsTo = null;
		this.dirName[] = dirName[UNDEFINED];
	}

	//Full constructor
	public Exit(int direction, Location leadsTo) {
		this.direction = direction;
		if (direction <= dirName.length) {
			directionName = dirName[direction];
		}
		this.leadsTo = leadsTo;
	}
	
	@Override
	public String toString() {
		return "Exit [directionName=" + directionName + "]";
	}

	//getters and setters
	public Location getLeadsTo() {
		return leadsTo;
	}
	public void setLeadsTo(Location leadsTo) {
		this.leadsTo = leadsTo;
	}
	public String getRoomLocation() {
		return roomLocation;
	}
	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public String getDirectionName() {
		return directionName;
	}
	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}
	
	
}
