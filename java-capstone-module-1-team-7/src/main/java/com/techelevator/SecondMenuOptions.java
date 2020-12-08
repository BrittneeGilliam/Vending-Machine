package com.techelevator;


import java.util.Scanner;


public class SecondMenuOptions extends Menu{


	private Scanner userMoney;
	private Scanner userIdSnack;
	double totalMoneyInput = 0;
	
	
	public double [] feedMoney() {
		boolean userAnswer = true;
		userMoney = new Scanner(System.in);
		double [] bothAmounts = new double[2];
		
		while(userAnswer == true) {
			System.out.println("Please input cash amount by bill (1, 5, 10): ");
			String money = userMoney.nextLine();
			double doubleMoney = Double.parseDouble(money);
			
			totalMoneyInput = totalMoneyInput + doubleMoney;
			System.out.println("Current money provided: $" + totalMoneyInput);
			System.out.println();
			
			bothAmounts[0] = doubleMoney;
			bothAmounts[1] = totalMoneyInput;
			System.out.println("Would you like to put in more money? (Y for Yes, or, N for No): ");
			String answer = userMoney.nextLine();
			answer = answer.toLowerCase();
			
			
			if(answer.contentEquals("y")) {
				userAnswer = true;
			} else {
				userAnswer = false;
			}
		}
		return bothAmounts;
	}
	
	public String [] selectProduct() {
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
		String [] allTheStuffINeed = new String[3];
		
		
		for(Snack menuSnack : interactiveList.interactWithInventory()) {
			if(snackId.contentEquals(menuSnack.getLocation())) {
				totalCash = totalMoneyInput - menuSnack.getPrice();
				//this only provides accurate change for the first purchase
				//I'm stuck on how to access the updated balance after a purchse
				//to plug back into here :(
				//String graspingAtStraws = stringCash + " " + snackLocation + " " + snackName;
				//allTheStuffINeed = graspingAtStraws.split(" ");
				//allTheStuffINeed = new String [] { Double.toString(totalCash), menuSnack.getLocation(), menuSnack.getName()};
				allTheStuffINeed [0] = Double.toString(totalCash);
				allTheStuffINeed [1] = menuSnack.getLocation();
				allTheStuffINeed [2] = menuSnack.getName();
				if(menuSnack.getRemainingQuanitity() == 0) {
					System.out.println("SOLD OUT!!");
				} else if(totalMoneyInput >= menuSnack.getPrice()) {  
					
					menuSnack.setRemainingQuanitity(menuSnack.getRemainingQuanitity()-1);
					System.out.println("Here is your " + menuSnack.getName()+ ". " + "The cost was: $" + menuSnack.getPrice() +
							". " + "Money remaining: $" + totalCash + ". " + menuSnack.printout());
				
				}	else if(totalCash <= menuSnack.getPrice()){
					
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
		return allTheStuffINeed; 

		
	}
	
	
	
	
}
