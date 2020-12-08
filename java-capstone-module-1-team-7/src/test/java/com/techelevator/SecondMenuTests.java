package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SecondMenuTests extends SecondMenu{ //Menu Selection 
	@Test

	public void displays_a_list_of_numerical_menu_options_and_asks_user_to_make_a_choice() {
		//Arrange
		Object[] userInput = null;
		
		@SuppressWarnings("unused")
		SecondMenu mySecondMenu = new SecondMenu(); 
		
		//Act

		@SuppressWarnings("unused")
		String String = "\n" + "1) " + userInput[0].toString() + "\n" + "2) " + userInput[1].toString() + "\n" + "3) "
				+ userInput[2].toString() + "\n\n" + "Please enter 1, 2, or 3: ";
	//Assert
		Assert.assertEquals(1, 2, 3);
	}

}