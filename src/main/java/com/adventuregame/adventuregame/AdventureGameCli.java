package com.adventuregame.adventuregame;

public class AdventureGameCli {

	private static final String MAIN_MENU_OPTION_START_NEW_GAME = "Start a New Adventure";
	private static final String MAIN_MENU_OPTION_CONTINUE_GAME = "Continue a previous game";
	private static final String MAIN_MENU_OPTION_VIEW_HIGH_SCORE = "See High Scores";
	private static final String MAIN_MENU_OPTION_EXIT = "Quit Game";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_START_NEW_GAME, 
														MAIN_MENU_OPTION_CONTINUE_GAME,
														MAIN_MENU_OPTION_VIEW_HIGH_SCORE,
														MAIN_MENU_OPTION_EXIT };
	
	private Menu gameMenu;
	public Wanderer wanderer = new Wanderer();
	
	
	public AdventureGameCli(Menu menu) {
		this.gameMenu = menu;
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
		System.out.println("Safe travels fellow adventurer!");
	}
}
