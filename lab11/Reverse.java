package recursions;

public class Reverse {

	/*
	 * Now, write a recursive solution to reverse without using any helper methods.
	 * That is, reverse should only call reverse (and some string manipulation methods).
	 */
	
	
	public String reverse(String s) {
		
		int length = s.length();
		
		
		if(s==null || length <= 1) {
			
			return s;
			// base case
		
		} else {
		
			// the recursive case!
            return s.charAt(s.length()-1) + reverse(allButLast(s)); 
		}
	}
	
	
	//////// HELPER METHODS YOU MIGHT FIND USEFUL
	
	// Returns a string containing all the characters except the first
	public static String allButFirst(String s) {
		return s.substring(1);
	}
	
	// Returns a string containing all the characters except the last
	public static String allButLast(String s) {
		return s.substring(0, s.length()-1);
	}	

	// Use this to test your reverse method by running this class manually
	public static void main(String[] args) {
		Reverse obj = new Reverse();
		
		System.out.println(obj.reverse("Monogatari"));
		System.out.println(obj.reverse("This is Lab 11 of CSE 21"));
		System.out.println(obj.reverse("123456"));
		System.out.println(obj.reverse("I am learning recursion to solve problems in CSE!"));
	}

}
