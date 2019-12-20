package com.adventuregame.adventuregame;

public class Items {

	private String itemName;
	private String description;
	private int damage;				//will be 0 if a health potion, food, etc.
	private int quantity;
	private int durability; 
	private int addHealth;			//will be 0 if a weapon.
	
	public Items(String itemName, String description, int damage, int quantity, int durability, int addHealth) {
		this.itemName = itemName;
		this.description = description;
		this.damage = damage;
		this.quantity = quantity;
		this.durability = durability;
		this.addHealth = addHealth;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public int getAddHealth() {
		return addHealth;
	}
	public void setAddHealth(int addHealth) {
		this.addHealth = addHealth;
	}
	
}
