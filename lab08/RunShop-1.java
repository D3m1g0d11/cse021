package pack;
import java.util.Scanner;

public class RunShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of cheeses for shop setup: ");
		int maxCheese = input.nextInt();
		ShopArr shop = new ShopArr(maxCheese);
		shop.run();
		System.out.println("Ran with Cheese Total: " + Cheese.numCheese);
		input.close();
	}

}
