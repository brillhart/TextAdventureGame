package com.adventuregame.adventuregame;

public class AdventureGameApp {

	public static void main(String[] args) {
		Menu gameMenu = new Menu(System.in, System.out);
		AdventureGameCli gameCli = new AdventureGameCli(gameMenu);
		gameCli.runGame();
	}

}
