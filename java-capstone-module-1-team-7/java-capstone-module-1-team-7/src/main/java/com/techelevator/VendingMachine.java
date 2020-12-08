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



public class VendingMachine {
	
	//a note about the log
	//what i've done does in fact creat the log.  I'm getting it to add the required info 
	//one step at a time.  
	//I still feel like it should eventually be a class.  I tried that at first but was really
	//strugging to actually implement it here, so I figured I'd start in here and see if I could
	//at least get something working for now.


	public static void main(String[] args) throws IOException {
		
	final File C_S_V =  new File ("vendingmachine.csv");
	MainMenu mainMenu = new MainMenu();
	SecondMenu secondMenu = new SecondMenu();
	SecondMenuOptions option = new SecondMenuOptions();
	File theDreadedLog = new File("Log.txt");
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
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
				totalMoney = totalMoney + option.feedMoney();
				try (PrintWriter tooLogitToQuit = new PrintWriter(new FileWriter(theDreadedLog, true))){
					//BigDecimal logFeed = new BigDecimal(totalMoney);
					//tooLogitToQuit.println(dtf.format(now) + " FEED MONEY: " + " " + logFeed.toString());	
					//attempted to use big decimal to make the formatting better, but it hasn't worked yet
					tooLogitToQuit.println(dtf.format(now) + " FEED MONEY: " + totalMoney);
					}
				//needs to return to secondmenu; I can't get anything to work!
			} else if(secondPathNum == 2) {
				leftoverMoney = option.selectProduct();
				try (PrintWriter tooLogitToQuit = new PrintWriter(new FileWriter(theDreadedLog, true))){
					tooLogitToQuit.println(dtf.format(now) + " Snack name and location " + totalMoney + " " + leftoverMoney);	
					//It's going to be complicated to get the snack name and location
					//is there a way for a method to return an int and two strings lol?
					//Maybe.  I'm tired, I'll try again later, or maybe you'll figure it out
				    }
				totalMoney = leftoverMoney;
				//needs to return to secondmenu  I can't get anything to work!
			} else if(secondPathNum == 3) {
				ChangeGiven change = new ChangeGiven();
				System.out.println();
				System.out.println("Your change is: " + leftoverMoney);
				change.changeGiven(leftoverMoney);
				
				try (PrintWriter tooLogitToQuit = new PrintWriter(new FileWriter(theDreadedLog, true))){
					tooLogitToQuit.println(dtf.format(now) + " GIVE CHANGE: " + leftoverMoney + "$0.00");	
					}
				
				totalMoney = 0;
				leftoverMoney = 0;
				
				//keepGoing = false;  // I got rid of this so that t returned to the main exit menu
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