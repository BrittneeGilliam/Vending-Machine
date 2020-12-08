package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SecondMenuOptions extends Menu{

	private Scanner userInputSecondMenu;
	private Scanner userMoney;
	private Scanner userIdSnack;
	double totalMoneyInput = 0;
	
	
	public double feedMoney() {
		boolean userAnswer = true;
		userMoney = new Scanner(System.in);
		
		while(userAnswer == true) {
			System.out.println("Please input cash amount by bill (1, 5, 10): ");
			String money = userMoney.nextLine();
			double doubleMoney = Double.parseDouble(money);
			
			totalMoneyInput = totalMoneyInput + doubleMoney;
			System.out.println("Current money provided: $" + totalMoneyInput);
			System.out.println();
			
			System.out.println("Would you like to put in more money? (Y for Yes, or, N for No): ");
			String answer = userMoney.nextLine();
			answer = answer.toLowerCase();
			
			if(answer.contentEquals("y")) {
				userAnswer = true;
			} else {
				userAnswer = false;
			}
		}
		return totalMoneyInput;
	}
	
	public double selectProduct() {
		//Show list of available products
		System.out.println("Please look through all options (scroll to bottom)");
		System.out.println();
		menuInventory.displayInventoryinConsole();
		Inventory interactiveList = new Inventory(C_S_V);
		
		//Allow customer to choose product iD
		userIdSnack = new Scanner(System.in);
		System.out.println("Please enter item ID (ex. A1): ");
		String snackId = userIdSnack.nextLine();
		double totalCash = 0; //Change this later maybe
		boolean isSnackDispensable; // I read through the code and it looks like maybe we don't need this variable?
		
		for(Snack menuSnack : interactiveList.interactWithInventory()) {
			if(snackId.contentEquals(menuSnack.getLocation())) {
				snackId = menuSnack.getLocation();
				if(menuSnack.getRemainingQuanitity() == 0) {
					System.out.println("SOLD OUT!!");
				} else if(totalMoneyInput >= menuSnack.getPrice()) {    //CANT CALL FEED MONEY
					isSnackDispensable = true;
					totalCash = totalMoneyInput - menuSnack.getPrice();
					System.out.println("Here is your " + menuSnack.getName() + ". " + "The cost was: $" + menuSnack.getPrice() +
							". " + "Money remaining: $" + totalCash + ". " + menuSnack.printout());
				
				}	else if(totalCash <= 0){
					isSnackDispensable = false;
					System.out.println("You do not have enough money for " + menuSnack.getName() + ". Please insert more money.");
				} else {
				System.out.println("Could not find that snack ID.");
			}
				
		}
		
		///////////////// Notes below is reference logic /////////////////////////
		
		//if product is sold out tell customer, and return to purchase menu
		
		//if valid product, dispense product along with if they have enough money
		
		//dispensing item includes item name, cost, money remaining, and returns Yum message.
		}
		return totalCash; 
		
		// A note from Frankie
		// I found an error in this method while trying to create the log.
		// Because it uses the input from the feed money function, it doesn't use the updated
		// customer balance on a second or third purchase, 
		// and just keeps resetting the money back to the total amount of money fed in.
		// I can't figure out how to address this so I'm leaving it for now.
		
	}
	
//		
	
	
}
