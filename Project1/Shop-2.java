package shop;
import java.util.*;

public class Shop {

	private static Items[] items;
	static boolean shopExists = false;
	private static double discountAmount;
	private static double discountRate;
	public static boolean bought = false;
	//Sets to a specific function using numbers 1-4

	public static void func (int function, Scanner input) {
		if(function == 1) {
			shop(input);
			shopExists = true;
			intro(input);
		}if(function == 2 && shopExists == true) {
			buy(items.length, input);
			intro(input);

		}if(function == 3 && shopExists == true) {
			itemtizedList(input);
			intro(input);
		}if(function == 4 && shopExists == true) {
			checkout(input);
			return;
		}if(shopExists == false) {
			System.out.println();
			System.out.println("The shop has not been set up yet!");
			System.out.println();
			intro(input);
		}
	}
	//Suffix printing

	public static String numSuffix (int i) {
		int rem = i % 10;
		switch (rem) {
		case 0:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return(i + "th");
		case 1:
			if(i % 100 != 11) {
				return (i + "st");
			}else {
				return (i + "th");
			}
		case 2:
			if(i % 100 != 12) {
				return (i + "nd");
			}else {
				return (i + "th");
			}
		case 3:
			if(i % 100 != 13) {
				return (i + "rd");
			}else {
				return (i + "th");
			}
		default:
			break;
		}
		return "";
	}

	//Sets the names, prices. discounts and etc. of the items

	private static void arrayInitialized(int length, Scanner scan) {
		System.out.println();
		items = new Items[length];

		for(int i = 0; i < length; i++) {
			items[i] = new Items();
			System.out.print("Enter the name of " + numSuffix(i+1) + " product: ");
			items[i].setName(scan.next());

			System.out.print("Enter the per package price of " + items[i].getName() + ": ");
			items[i].setPrice(scan.nextDouble());

			System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free) \nfor " +items[i].getName() + ", or 0 if no Special Discount offered: ");
			items[i].setDiscount(scan.nextInt()+2);
		}
		System.out.println();
		System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
		discountAmount = scan.nextDouble();
		while (discountAmount < 0) {
			System.out.println("Invalid input. Enter a value >= 0: ");
			discountAmount = scan.nextDouble();
		}
		if(discountAmount > 0) {
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			discountRate = scan.nextDouble();
			while (discountRate < 0 || discountRate > .5) {
				System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
				discountRate = scan.nextDouble();
			}
		}
		System.out.println();
	}

	// Shop function uses the shop 

	private static void shop(Scanner scan) {
		System.out.print("Please enter the number of items to set up shop: ");
		int numItems = scan.nextInt();
		while(numItems < 0) {
			System.out.println("Invalid input. Enter a value >= 0: ");
			numItems = scan.nextInt();
		}
		arrayInitialized(numItems, scan);
	}

	//Buying function

	public static void buy(int length , Scanner scan) {
		System.out.println();

		for(int i = 0; i < items.length; i++) {
			System.out.print("Enter the number of " + items[i].getName() + " packages to buy: ");
			items[i].setAmount(scan);
		}
		bought = true;	
		System.out.println();
	}

	public static void itemtizedList(Scanner scan) {
		int amt = 0;
		double price = 0;
		System.out.println();
		int totalAmt = 0;

		for(int i = 0; i < items.length; i++) {
			totalAmt += items[i].getAmount();
		}

		if (totalAmt == 0 && bought == true) {
			System.out.println("No items were purchased.");
		}else if(totalAmt == 0){	
			System.out.println("You have not bought anything!");
		}else {

			for (int j = 0; j < (items.length); j++) {
				if(items[j].getAmount() > 0) {
					price = items[j].getPrice();
					amt = (int) items[j].getAmount(); 
					System.out.printf(amt + " package of %s @ $%.2f = $%.2f\n", items[j].getName(), price, price*amt);

				}
			}
		}
		System.out.println();
	}
	public static void checkout(Scanner scan) {
		printFinalTotal(printSubTotals(calcSubTotal(), discountSpecials()));
	}

	private static double printSubTotals(double subTotal, double[] disSpecials) {
		double newSubTotal = subTotal;
		double packageSavings = 0;
		System.out.println();
		System.out.println();
		System.out.printf("Original Sub Total: \t\t\t $%.2f\n", subTotal);	

		if(disSpecials.length > 0) {
			for(int a = 0; a < disSpecials.length; a++) {
				packageSavings += disSpecials[a];
			}
			newSubTotal -= packageSavings;
		}
		if(packageSavings > 0) {
		System.out.printf("Specials Discount:  \t\t\t-$%.2f\n", packageSavings);
		}else {
			System.out.println("No Special Discounts applied ");
		}
		System.out.printf("New Sub Total:      \t\t\t $%.2f\n",newSubTotal);

		return newSubTotal;
	}
	//Calculate Specials
	private static double[] discountSpecials() {
		double[] disSpecials = new double [items.length];

		for(int p = 0; p < items.length; p++) {
			if(items[p].getAmount() >= items[p].getDiscount() && items[p].getDiscount() != 0) {
				for(int a = 0; a < items[p].getAmount() ; a++) {
					if(a % items[p].getDiscount() == 0) {
						disSpecials[p] += (items[p].getPrice());
					}
				}
			}else {
				disSpecials[p] = 0;
			}
		}	
		return disSpecials;		
	}

	private static void printFinalTotal(double newSubTotal) {
		double specialDiscount = 0;
		int specialPercentage = 0;
		double finalTotal = newSubTotal;

		if(newSubTotal >= discountAmount && discountAmount > 0) {
			specialDiscount = (Math.round(newSubTotal * (discountRate)*100.00))/100.00;
			specialPercentage = (int)(discountRate*100);
			finalTotal -= specialDiscount;
			System.out.printf("Additional %d%% Discount: \t\t-$%.2f\n", specialPercentage ,specialDiscount);
		}else {
			System.out.println("You did not qualify for an Additional Discount");
		}
		System.out.printf("Final Total:        \t\t\t $%.2f",finalTotal);
	}


	private static double calcSubTotal() {
		double subTotal = 0;

		for(int m = 0; m < items.length; m++) {
			subTotal += (items[m].getPrice()*items[m].getAmount());
		}
		return subTotal;
	}



	public static void intro(Scanner scan) {
		System.out.println("This program support 4 functions");
		System.out.println("\t1. Set up shop");
		System.out.println("\t2. Buy");
		System.out.println("\t3. List items");
		System.out.println("\t4. Checkout");

		System.out.print("Please choose the function you want: ");
		int function = scan.nextInt();
		while(function < 0 || function > 4) {
			System.out.println();
			System.out.println("Number is not in range");
			System.out.println();
			intro(scan);
		}
		func(function, scan);
	}

	public static void run() {

		Scanner input = new Scanner(System.in);
		intro(input);

		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();
		System.out.println("------------------------------------------------");


		System.out.println();

		if (redo == 1) {
			for(int y = 0; y < items.length; y++) {
				items[y].reset();
				shopExists = false;
			}
			run();
		}

	}
}