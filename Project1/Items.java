package shop;

import java.util.Scanner;

public class Items {
	private String name;
	private double price;
	private int amount;
	private double discount;

	public static int numItems = 0;

	public Items() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		discount = 0;
		numItems++;
	}

	public Items(String name) { // Constructor with name as parameter
		this.name = name;
		price = 0;
		amount = 0;
		numItems++;
	}

	public Items(String name, double price) { // Constructor with 2 parameters
		this.name = name;
		this.price = price;
		amount = 0;
		numItems++;
	}
	public double getDiscount() {
		return discount;
	}

	public void reset() {
		name = "";
		price = 0;
		amount = 0;
		discount = 0;
		numItems = 0;
	}	
	public String getName() { // Accessor
		return name;
	}

	public void setName(String newName) { // Mutator 
		name = newName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	public void setDiscount(double newDiscount) { // Mutator 
		discount = newDiscount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(Scanner input) {

		this.amount = input.nextInt();
		while(amount % 1 != 0 || amount < 0) {

			if(amount % 1 != 0){
				System.out.print("Invalid input. Enter a value that's multiple of 1 : ");
				this.amount = input.nextInt();
			}if(amount < 0) {
				System.out.print("Invalid input. Enter a value >= 0: ");
				this.amount = input.nextInt();
			}
		}

	}

}
