package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
	
	final  File C_S_V =  new File ("vendingmachine.csv");
	
	Inventory menuInventory = new Inventory(C_S_V);
	
	public String invalidInput() {
		return "Please enter 1, 2, or 3";
	}
	
	public String exit() {
		return "You have left the vending machine.";
	}

}
