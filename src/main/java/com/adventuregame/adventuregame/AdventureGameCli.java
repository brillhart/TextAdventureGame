package com.adventuregame.adventuregame;

import com.adventuregame.adventuregame.Wanderer.JDBCWandererDAO;
import com.adventuregame.adventuregame.Wanderer.Wanderer;
import com.adventuregame.adventuregame.Wanderer.WandererDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class AdventureGameCli {

	private static final String MAIN_MENU_OPTION_START_NEW_GAME = "Start a New Adventure";
	private static final String MAIN_MENU_OPTION_CONTINUE_GAME = "Continue a previous game";
	private static final String MAIN_MENU_OPTION_VIEW_HIGH_SCORE = "See High Scores";
	private static final String MAIN_MENU_OPTION_EXIT = "Quit Game";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_START_NEW_GAME, 
														MAIN_MENU_OPTION_CONTINUE_GAME,
														MAIN_MENU_OPTION_VIEW_HIGH_SCORE,
														MAIN_MENU_OPTION_EXIT };

	/***************************************************************************
	 * I was making every method static, which is no. Need to create interfaces and use those instead to make data available.
	 * Should also look at how work code is structured and how methods are used across classes. But the reason for the errors is
	 * due to too many static methods, not enough actual correct code structure.
	 */

	private  WandererDAO wandererDAO;

	private  Menu gameMenu;
	public  Wanderer wanderer = new Wanderer();
	public  NewGame newGame = new NewGame();

	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public AdventureGameCli(BasicDataSource dataSource) {
		//contains an instance of each DAO needed to access database
		wandererDAO = new JDBCWandererDAO(dataSource);
		//also contains instance of menu
		gameMenu = new Menu(System.in, System.out);
	}

	
	//main game processing loop
	
	public void runGame() {
		boolean shouldProcess = true;
		while(shouldProcess) {
			String choice = (String)gameMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			switch(choice) {
			case MAIN_MENU_OPTION_START_NEW_GAME:
				displayNewGameMenu();
				displayScenario();
			case MAIN_MENU_OPTION_CONTINUE_GAME:
				displayContinueGameMenu();
			case MAIN_MENU_OPTION_VIEW_HIGH_SCORE:
				break;
			case MAIN_MENU_OPTION_EXIT:
				endGame();
				shouldProcess = false;
				break;
			}
		}
		return;
	}
	
	//Methods used in main processing loop
	
	public void endGame() {
		//displayScore method
		//saveGame method
		System.out.println("Safe travels fellow adventurer!");
	}

	public void displayNewGameMenu() {
		System.out.println("What is your name, wanderer?");
		String playerName = gameMenu.getPlayerNameFromInput();
		Wanderer newPlayer = wandererDAO.assignNewPlayer(playerName);    //call this method to store new player in database
		System.out.println("Welcome, " + newPlayer.getName());
	}

	public void displayContinueGameMenu() {			//this method will have to return a player in order to use throughout the game
		System.out.println("What is your name, wanderer?");
		String playerName = gameMenu.getPlayerNameFromInput();
		wandererDAO.getPlayerFromDatabase(playerName);
	}
	public void displayScenario(Wanderer thePlayer) {					//TODO add thePlayer into method to use location
		String sqlSearchScenario = "Select * from locations where location_id = ?";
		SqlRowSet resultLocation = jdbcTemplate.queryForRowSet(sqlSearchScenario, thePlayer.getLocation());
	}



}
