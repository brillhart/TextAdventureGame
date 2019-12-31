package com.adventuregame.adventuregame;

import org.apache.commons.dbcp2.BasicDataSource;

public class AdventureGameApp {

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setUrl("jdbc:postgresql://localhost:5432/adventuregame");
		dataSource.setUsername("jesse");
		dataSource.setPassword("03yz125");

		Menu gameMenu = new Menu(System.in, System.out);
		AdventureGameCli gameCli = new AdventureGameCli(dataSource);
		gameCli.runGame();
	}

}
