package com.techelevator;

public abstract class Snack {
	
	private String location;
	private String name;
	private double price;
	private int remainingQuanitity = 5;
	
	

	public Snack(String location, String name, double price) {
		this.location = location;
		this.name = name;
		this.price = price;
	}

	
	public abstract String printout();
	

	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public int getRemainingQuanitity() {
		return remainingQuanitity;
	}


	public String getLocation() {
		return location;
	}


//	public void setLocation(String location) {
//		this.location = location;
//	}





	
	
}
