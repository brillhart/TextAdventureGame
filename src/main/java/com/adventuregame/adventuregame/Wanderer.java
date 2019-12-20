package com.adventuregame.adventuregame;

import java.util.List;

public class Wanderer {

	//this will be the player object
	
	private int health;
	private int damage;
	private int experience;
	private int level;
	private List<Items> inventory;		//List will be a separate class with attributes 
										//such as a damage mods for weapons, health bonuses
										//for armor, additional health for food, etc.
	
	public Wanderer() {
		
	}
	
	public Wanderer(int health, int damage, int experience, int level, List<Items> inventory) {
		this.health = health;
		this.damage = damage;
		this.experience = experience;
		this.level = level;
		this.inventory = inventory;
	}


	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<Items> getInventory() {
		return inventory;
	}
	public void setInventory(List<Items> inventory) {
		this.inventory = inventory;
	}

}
