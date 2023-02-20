import java.util.*;

public class Lab21_Vars {

	public static void main(String[] args) {

		//Integers were not defined
		//int i, j;
		int i = 0;
		int j = 0;

		int var0, var1;

		// Fix 1: Correctly type cast 5.0 to an int so it can assigned to var3.
		//I put (int) in front of 5.0 so it would convert it to an integer
		int var2 = 0, var3 = (int) 5.0;
		//int var2 = 0, var3 = 5.0;

		// Fix 2: Correctly declare a variable as an array.
		//Needs brackets after int
		int[] arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};


		//int arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

		double[] arrd0 = {0.0, 1.0, 2.0, 3.0, 4.0};

		// Fix 3: What's wrong with temp? Fix it.
		//Temp is not casted in the else statement so i put it outside the statement
		int temp;
		if (i < j) {
			//int temp = 0;
			temp = 0;
			System.out.println("Temp is " + temp);
		} else {
			temp = 1;
			System.out.println("Temp is " + temp);
		}

		// Fix 4: Correctly calculate square of sums and print it as total.
		//I declared total outside the for loop and since i was declared
		//i made sure it didn't cast twice
		int total = 0;
		for(i = 0; i < 10; i++) {
			//for (int i = 0; i < 10; i++) {
			total = 0;
			//int total = 0;
			total += i*i;
		}
		System.out.println("i value is " + i);
		System.out.println("Total is " + total);


		// Fix 5: Figure out the logical error in lines 36-42, and correct it.
		//I got the the cheese class from previous labs
		//I set jack to new Cheese();

		Cheese jack = new Cheese();
		//Cheese jack;
		Cheese monterey = new Cheese("Monterey");
		jack = monterey;
		System.out.println("Monterey name is " + monterey.getName());
		jack.setName("Jack");
		System.out.println("Jack name is " + jack.getName());
		System.out.println("Monterey name is still " + monterey.getName());



		// Fix 6: Make the following code shorter by combining redundant 
		//        (unnecessary/duplicate) statements
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = input.nextInt();

		System.out.print("Enter second number: ");	
		int num2 = input.nextInt();

		if(num1 > var3) {	
			//if (input.nextInt() > var3) {
			//Removed System.out.print("Enter second number: ");
			//Removed int num2 = input.nextInt();
			System.out.println("First is greater");
			/*if (num2 < var3)
			 *	System.out.println("Second is Less than");
			 *else
			 *	System.out.println("Second is Greater or equal");
			 */
		} else {
			//Removed System.out.print("Enter second number: ");
			//Removed int num2 = input.nextInt();
			System.out.println("First is Less than or equal");
			/*if (num2 < var3)
			 *	System.out.println("Second is Less than");
			 *else
			 *	System.out.println("Second is Greater or equal");
			 */
		}
		if (num2 < var3)
			System.out.println("Second is Less than");
		else
			System.out.println("Second is Greater or equal");
		
		System.out.println("The first number is " + num1);
		// Fix 7: Print out the first number entered by the user
		//        (Hint - You will need to modify the above code)
		//added last line

	}

}