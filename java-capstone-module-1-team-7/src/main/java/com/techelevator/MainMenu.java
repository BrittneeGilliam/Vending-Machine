package com.techelevator;

import java.util.Scanner;

public class MainMenu extends Menu {

	private Scanner userInputMenu;
	
	public int menuSelection() {
		
		userInputMenu = new Scanner(System.in);
		
		System.out.println("************************************");
		System.out.println("*      Vendo-Matic 1100100000      *");
		System.out.println("************************************");
		System.out.println();
		System.out.println("1) Display Vending Machine Items");
		System.out.println("2) Purchase");
		System.out.println("3) Exit");
		
		System.out.print("Please enter 1, 2, or 3: ");
		String path = userInputMenu.nextLine();
		int pathNum = Integer.parseInt(path);
		return pathNum;
	}
	

	
	
}
