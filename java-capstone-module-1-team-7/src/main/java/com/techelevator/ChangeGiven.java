package com.techelevator;

import java.math.BigDecimal;

// GOAL:
//Input: number from 1 to 99 - from the purchase menu aspect of the program.
//Output: a combination of coins that equals that amount of change. 


public class ChangeGiven extends Menu {


	public void changeGiven(double coinChange){



	int quarters = 0; // coin change initialized
	int dimes = 0;	
	int nickels = 0;  
    while (coinChange >= .25){
       quarters = quarters + 1;
        coinChange = coinChange - .25;
   }
    while (coinChange >= .10){
        nickels = dimes + 1;
      coinChange = coinChange - .10;
   }	
        while (coinChange >= .5){
            nickels = nickels + 1;
            coinChange = coinChange - .5;
        }
            

			System.out.println("Please accept your change in the amount of: " + quarters +  " quarters " 
            + dimes + " dimes " + nickels + " nickels ");
      			}
    		}