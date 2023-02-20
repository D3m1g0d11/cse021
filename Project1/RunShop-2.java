package shop;
import java.util.Scanner;

public class RunShop {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Shop shopProgram = new Shop();
		shopProgram.run();
		input.close();
	}
}