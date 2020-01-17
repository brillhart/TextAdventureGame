package com.adventuregame.adventuregame.Wanderer;

import com.adventuregame.adventuregame.Items;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Wanderer {

	//this will be the player object

	private String name;
	private int health;
	private int damage;
	private int experience;
	private int level;
	private int location;								//such as a damage mods for weapons, health bonuses
	private Date saveDate;                                    //for armor, additional health for food, etc.
	private String playTime;
	private int score;

	public Wanderer() {}
	// default new player
	public Wanderer(String playerName) {
		this.name = playerName;
		this.health = 100;
		this.damage = 10;
		this.experience = 0;
		this.level = 1;
		this.location = 1;
		this.saveDate = new Date();
		this.playTime = "00:00:00";
		this.score = 0;
	}
	
	public Wanderer(String name, int health, int damage, int experience, int level, List<Items> inventory) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.experience = experience;
		this.level = level;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getHealth() { return health; }
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
	public int getLocation() { return location; }
	public void setLocation(int location) { this.location = location; }
	public Date getSaveDate() { return saveDate; }
	public void setSaveDate(Date saveDate) { this.saveDate = saveDate; }
	public String getPlayTime() { return playTime; }
	public void setPlayTime(String playTime) { this.playTime = playTime; }
	public int getScore() { return score; }
	public void setScore(int score) { this.score = score; }
}
