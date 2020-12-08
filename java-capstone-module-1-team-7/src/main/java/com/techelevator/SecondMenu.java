package com.techelevator;

import java.util.Scanner;

public class SecondMenu extends Menu{

	Scanner userInputMenu = new Scanner(System.in);
	
	public int secondMenuSelection() {
		
		System.out.println("1) Feed money");
		System.out.println("2) Select Product");
		System.out.println("3) Finish Transaction");
		System.out.println();
		System.out.println("Please enter 1, 2, or 3: ");
		userInputMenu = new Scanner(System.in);
		String secondPath = userInputMenu.nextLine();
		int secondPathNum = Integer.parseInt(secondPath);
			
		return secondPathNum;
	}
}
