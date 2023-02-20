package pack;
import java.util.*;

public class ShopArr {

	// Instance Variables
	private Cheese[] cheese;
	
	// Initialize method
	private void init(int max) {
		
		// Create max number of Cheese pointers
		cheese = new Cheese[max]; 
		
		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Humboldt Fog");
			cheese[0].setPrice(25.00);
			
			if (max > 1) {
				cheese[1] = new Cheese("Red Hawk");
				cheese[1].setPrice(40.50);
			
				if (max > 2) {
					cheese[2] = new Cheese("Teleme", 17.25);
					//cheese[2].setName("Wrong Name");
				}
			}
		}
		
		Random ranGen = new Random(100);

		for (int i = 3; i < max; i++) {
			cheese[i] = new Cheese("Cheese Type " + (char)('A' + i), ranGen.nextInt(1000)/100.0);
		}
		
	}
	public ShopArr() {
		init(10);
	}
	
	public ShopArr(int max) {
		init(max);
	}

	/*
	 * Displays the intro message informing the user of various cheeses sold and
	 * Gets the amount of each cheese the user would like to purchase. 
	 */
	private void intro(Scanner input) {
		System.out.println("We sell " + cheese.length + " kinds of cheese, in 0.5 lb packages:");

		for (int i = 0; i < cheese.length; i++) {
			
			System.out.println(cheese[i].getName() + ": $" + cheese[i].getPrice() + " per pound"); 
			}
		
		System.out.println();
		
		for (int j = 0; j < (cheese.length); j++) {
			System.out.print("Enter the amount of " + cheese[j].getName() + " in lb: ");
			cheese[j].setAmount(input);
			}
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	private void itemizedList(){
		double amt = 0, price = 0;
		
		double totalAmt = 0;
		
		for(int i = 0; i < cheese.length; i++) {
			totalAmt += cheese[i].getAmount();
		}
		
		if (totalAmt == 0)
			System.out.println("No items were purchased.");
		else {
			
			for (int j = 0; j < (cheese.length); j++) {
				if(cheese[j].getAmount() > 0) {
					price = cheese[j].getPrice();
					amt = cheese[j].getAmount(); 
					System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, cheese[j].getName(), price, price*amt);
					}
				}
		}
	}

	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	private double calcSubTotal() {
		double subTotal = 0;
		
		for(int m = 0; m < cheese.length; m++) {
			subTotal += (cheese[m].getPrice()*cheese[m].getAmount());
		}

		return subTotal;
	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 * stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 * Minor changes from Lab 07 (identical logic). 
	 */
	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};
		double hfAmt = 0;
		double rhAmt = 0;
		int loop = 0;
		if(cheese.length >= 1) {
			hfAmt = cheese[0].getAmount();
		}if (cheese.length >= 2) {
			rhAmt = cheese[1].getAmount();
		}
		
		if (hfAmt > 0) {
			for(double a = 0.5; a <= hfAmt; a += 0.5) {
				if(a % 1.0 == 0) {
				disSpecials[0] += (cheese[0].getPrice()/2);
				loop++;
				}
			}
			System.out.println(loop);
			System.out.println((double)((int)(cheese[0].getAmount()*2/2)*(cheese[0].getPrice()/2)));
		}
		if(rhAmt > 0) {
			for(double a = 0.5; a <= rhAmt; a += 0.5) {
				if(a % 1.5 == 0) {
				disSpecials[1] += (cheese[1].getPrice()/2);
				}
			}	
		}	
		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total. Identical to Lab 07.
	 */
	private double printSubTotals(double subTotal, double[] disSpecials) {
		double newSubTotal = subTotal;
		System.out.println();
		System.out.println();
		System.out.printf("Original Sub Total: \t\t\t $%.2f\n", subTotal);	
		System.out.println("Specials...");
		if(disSpecials[0] == 0 && disSpecials[1] == 0) {
			System.out.println("None:               \t\t\t-$0.00");
		}
		if(disSpecials[0] > 0) {
			System.out.printf("Humboldt Fog (Buy 1 Get 1 Free): \t-$%.2f\n",disSpecials[0]);
		}if(disSpecials[1] > 0) {
			System.out.printf("Red Hawk (Buy 2 Get 1 Free): \t\t-$%.2f\n",disSpecials[1]);
			}

		if(disSpecials.length > 0) {
			newSubTotal = subTotal - disSpecials[0] -disSpecials[1];
		}
		System.out.printf("New Sub Total:      \t\t\t $%.2f\n",newSubTotal);
		
		return newSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total. Identical to Lab 07.
	 */
	private void printFinalTotal(double newSubTotal) {
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

	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) 		
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lb of " + cheese[i].getName() + " @ $0 = $" + 0);
		System.out.println("Total Price: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();
		
		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}
		
		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
}
