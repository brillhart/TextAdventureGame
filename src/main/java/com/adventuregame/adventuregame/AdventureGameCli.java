package com.adventuregame.adventuregame;

import com.adventuregame.adventuregame.Wanderer.JDBCWandererDAO;
import com.adventuregame.adventuregame.Wanderer.Wanderer;
import com.adventuregame.adventuregame.Wanderer.WandererDAO;
import org.apache.commons.dbcp2.BasicDataSource;

public class AdventureGameCli {

	private static final String MAIN_MENU_OPTION_START_NEW_GAME = "Start a New Adventure";
	private static final String MAIN_MENU_OPTION_CONTINUE_GAME = "Continue a previous game";
	private static final String MAIN_MENU_OPTION_VIEW_HIGH_SCORE = "See High Scores";
	private static final String MAIN_MENU_OPTION_EXIT = "Quit Game";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_START_NEW_GAME, 
														MAIN_MENU_OPTION_CONTINUE_GAME,
														MAIN_MENU_OPTION_VIEW_HIGH_SCORE,
														MAIN_MENU_OPTION_EXIT };

	private WandererDAO wandererDAO;

	private Menu gameMenu;
	public Wanderer wanderer = new Wanderer();
	public static NewGame newGame = new NewGame();
	
	
	public AdventureGameCli(BasicDataSource dataSource) {
		gameMenu = new Menu(System.in, System.out);
		//contains an instance of each DAO needed to access database
		wandererDAO = new JDBCWandererDAO(dataSource);
		//also contains instance of menu

	}

	
	//main game processing loop
	
	public void runGame() {
		boolean shouldProcess = true;
		while(shouldProcess) {
			String choice = (String)gameMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			switch(choice) {
			case MAIN_MENU_OPTION_START_NEW_GAME:
				break;
			case MAIN_MENU_OPTION_CONTINUE_GAME:
				break;
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
	
	public static void endGame() {
		//displayScore method
		//saveGame method
		System.out.println("Safe travels fellow adventurer!");
	}





}
