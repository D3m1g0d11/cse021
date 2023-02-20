package pack;
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts) {
		
		System.out.println();
 		System.out.println("We sell " + names.length + " kinds of cheese, in 0.5 lb packages: ");
 		
		if(names.length !=0) {
			if(names.length >= 1) {
				names[0] = "Humboldt Fog";
				prices[0] = 25.00;
			
			if(names.length >= 2) {
				names[1] = "Red Hawk";
				prices[1] = 40.50;
					}
			if(names.length >= 3) {
				names[2] = "Teleme";
				prices[2] = 17.25;
					}
				}
		System.out.println(names[0] + ": $" + prices[0] + " per pound");
		if(names.length >= 2) {
		System.out.println(names[1] + ": $" + prices[1] + " per pound");
			}
		if(names.length >= 3) {
		System.out.println(names[2] + ": $" + prices[2] + " per pound");
			}
		}
		
 		Random ranGen = new Random(200);
///Generates the cheese names and prices
 		
		for (int i = 3; i < names.length; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;
			System.out.println(names[i] + ": $" + prices[i] + " per pound"); 
			}
			
		System.out.println();
	}
	
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		for (int j = 0; j < (names.length); j++) {
			System.out.print("Enter the amount of " + names[j] + " in lb: ");
			amounts[j] = sc.nextDouble();
			while(amounts[j] % 0.5 != 0 || amounts[j] < 0) {
				if(amounts[j] % 0.5 != 0 ) {
				System.out.print("Invalid input. Enter a value that's a multiple of 0.5: ");
				amounts[j] = sc.nextDouble();
			}
			if(amounts[j] < 0) {
				System.out.print("Invalid input. Enter a value >= 0: ");
				amounts[j] = sc.nextDouble();
				}
			}
		}

	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		boolean purchase = false;
		
		for (int k = 0; k < prices.length; k++) {
			if(purchase != true && amounts[k] > 0) {
				purchase = true;
			}else {
				break;
			}
		}
		
		if(purchase == false) {
			System.out.println("No items were purchased");
		}else {
			for(int t = 0; t < (names.length); t++) {
				if(amounts[t] > 0) {
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amounts[t], names[t],prices[t], prices[t]*amounts[t]);
					}
				}
			}
		}
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		double subTotal = 0;
		for(int m = 0; m < prices.length; m++) {
			subTotal += (prices[m]*amounts[m]);
		}
		return subTotal;
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */

	public static double[] discountSpecials(double[] amounts, double[] prices){

		double humboldtDiscount = 0;
		double redHawkDiscount = 0;
		double[] disSpecials = new double[amounts.length];
		
		if(amounts.length > 0) {
		if(amounts[0] >= 1 ) {
			for(double ab = 0.5; ab <= amounts[0]; ab += 0.5) {
					if(ab % 1.0 == 0) {
					humboldtDiscount += prices[0]/2;
					}
			}
		}else {
			humboldtDiscount = 0;
			
		}
			
		if(amounts.length> 1 && amounts[1] >= 1.5) {
			for(double bc = 0.5; bc <= amounts[1]; bc += 0.5) {
				if(bc % 1.5 == 0) {
				redHawkDiscount += prices[1]/2;
				}
			}
		}else {
			redHawkDiscount = 0;
		}
		disSpecials[0] = humboldtDiscount;
		disSpecials[1] = redHawkDiscount;
		}
		return disSpecials;
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		double newSubTotal = 0;
		System.out.println();
		System.out.println();
		System.out.printf("Original Sub Total: \t\t\t $%.2f\n", subTotal);	
		System.out.println("Specials...");
		if(disSpecials.length == 0) {
			System.out.println("None:               \t\t\t-$0.00");
		}else {
		if(disSpecials[0] == 0 && disSpecials[1] == 0) {
			System.out.println("None:               \t\t\t-$0.00");
		}
		if(disSpecials[0] > 0) {
			System.out.printf("Humboldt Fog (Buy 1 Get 1 Free): \t-$%.2f\n",disSpecials[0]);
		}if(disSpecials[1] > 0) {
			System.out.printf("Red Hawk (Buy 2 Get 1 Free): \t\t-$%.2f\n",disSpecials[1]);
			}
		}
		if(disSpecials.length > 0) {
			newSubTotal = subTotal - disSpecials[0] -disSpecials[1];
		}
		System.out.printf("New Sub Total:      \t\t\t $%.2f\n",newSubTotal);
		
		return newSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		
		double specialDiscount = 0;
		int specialPercentage = 0;
		double finalTotal = newSubTotal;
		
		if(newSubTotal >= 250) {
			specialDiscount = (Math.round(newSubTotal * (0.25)*100.00))/100.00;
			specialPercentage = 25;
		}else if(newSubTotal >= 150) {
				specialDiscount = (Math.round(newSubTotal * (0.1)*100.00))/100.00;
				specialPercentage = 10;
			}
		finalTotal -= specialDiscount;
				
		System.out.printf("Additional %d%% Discount: \t\t-$%.2f\n", specialPercentage ,specialDiscount);
		System.out.printf("Final Total:        \t\t\t $%.2f",finalTotal);
		
	}
	
	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}