package com.adventuregame.adventuregame;

import com.adventuregame.adventuregame.Wanderer.Wanderer;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
	
	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	
	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			//eat the exception, an error message  will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n" + userInput + "is not a valid option \n");
		}
		return choice;
	}
	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNumber = i + 1;
			out.println(optionNumber + ")" + options[i]);
		}
		out.println("\n Please select an option... ");
		out.flush();
	}

	public String getPlayerNameFromInput() {
		String playerName = in.nextLine();
		return playerName;
	}

	public String getInputFromPlayer() {
		String playerInput = in.nextLine();
		return playerInput;						// use this to interact with a player input interpreter that decides what action to perform
	}


}
