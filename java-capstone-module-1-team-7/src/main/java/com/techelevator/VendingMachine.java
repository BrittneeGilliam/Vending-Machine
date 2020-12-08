package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

	//A note to our instructors
	//We had some issues completing this assignment
	//I'm sure you'll want to talk to us in person, but I also 
	//included lots of notes to clarify what we were trying to accomplish,
	//even if we coudln't pull it all off

public class VendingMachine {
	
	// a note about the log
	// I wanted to eventually make it into an interface called Logable
	// which the menu classes would all implement, then at the end of the finish transaction
	// option, there would be a for each logable : Logable loop.  
	// I think this would have made these individual pieces
	// print out into the correct format at the end
	// But alas, it was not meant to be...

	public static void main(String[] args) throws IOException {
		
	final File C_S_V =  new File ("vendingmachine.csv");
	MainMenu mainMenu = new MainMenu();
	SecondMenu secondMenu = new SecondMenu();
	SecondMenuOptions option = new SecondMenuOptions();
	File theDreadedLog = new File("Log.txt");
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	double moneyFed = 0;
	double totalMoney = 0;
	double leftoverMoney = 0;
	boolean keepGoing = true;
		
	//Stocks the Vending Machine upon start
	Inventory menuInventory = new Inventory(C_S_V);
	
	//Displays Main Menu and offers navigation to selections
	//Link method after method together instead of while loop
	while(keepGoing) {
		int pathNum = mainMenu.menuSelection();
		System.out.println();
		if(pathNum == 1) {
			menuInventory.displayInventoryinConsole();
			System.out.println();
		} else if(pathNum == 2) {
				 int secondPathNum = secondMenu.secondMenuSelection();
			if(secondPathNum == 1) {
				moneyFed = option.feedMoney()[0];
				totalMoney = option.feedMoney()[1];
				try (PrintWriter tooLogitToQuit = new PrintWriter(new FileWriter(theDreadedLog, true))){	
					//attempted to use big decimal to make the formatting better, but it hasn't worked yet
					tooLogitToQuit.println(dtf.format(now) + " FEED MONEY: " +  moneyFed + " " + totalMoney);
					}
				//needs to return to secondmenu
			} else if(secondPathNum == 2) {
				//it asks you to select the product three times for some reason
				//I'm working on it
				//I realize that's not right, but if you go ahead and select it three times it works for now
			
				leftoverMoney = Double.parseDouble(option.selectProduct()[0]);
				try (PrintWriter tooLogitToQuit = new PrintWriter(new FileWriter(theDreadedLog, true))){
					tooLogitToQuit.println(dtf.format(now) + " " + option.selectProduct()[1]
							+ " " + option.selectProduct()[2] + " " + totalMoney + " " + leftoverMoney);	
		
				    }
				totalMoney = leftoverMoney;
				//needs to return to secondmenu  
			} else if(secondPathNum == 3) {
				//to get to this function, you must select 2 on the main menu
				//i'm working on fixing this error
				ChangeGiven change = new ChangeGiven();
				System.out.println();
				System.out.println("Your change is: " + leftoverMoney);
				change.changeGiven(leftoverMoney);
				
				try (PrintWriter tooLogitToQuit = new PrintWriter(new FileWriter(theDreadedLog, true))){
					tooLogitToQuit.println(dtf.format(now) + " GIVE CHANGE: " + leftoverMoney + " $0.00");	
					}
				
				totalMoney = 0;
				leftoverMoney = 0;
				
			} else {
				System.out.println("Please enter 1, 2, or 3");
			}
		} else if(pathNum == 3) {
			keepGoing = false;
			System.out.println("You have left the vending machine.");
		} else {
			System.out.println("Please enter 1, 2, or 3");
			System.out.println();
		}
		
	}
	
	
		
	}	
		
}