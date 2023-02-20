package arraylist;

import java.util.ArrayList;

public class ArrayListRunner {
	
	// Use this class to run your code

	public static void main(String[] args) {
		
		testArrayList();
		testArrayList2();
	}

	
	
	public static void testArrayList() {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add ("a");
		System.out.println(words.toString());
		words.add ("b");
		System.out.println(words.toString());
		words.add ("c");
		System.out.println(words.toString());
		words.remove ("b");
		System.out.println(words.toString());
		words.add ("d");
		System.out.println(words.toString());
		words.remove ("a");
		System.out.println(words.toString());
		words.add ("e");
		System.out.println(words.toString());
		words.remove ("b");
		System.out.println(words.toString());
		words.add ("d");
		System.out.println(words.toString());
		words.remove ("c");
		System.out.println(words.toString());
		words.remove ("d");
		System.out.println(words.toString());
	}

public static void testArrayList2() {
		
		TrackedArrayList<String> words = new TrackedArrayList<String>();
		words.add ("a");
		System.out.println(words.maxSizeSoFar());
		words.add ("b");
		System.out.println(words.maxSizeSoFar());
		words.add ("c");
		System.out.println(words.maxSizeSoFar());
		words.remove ("b");
		System.out.println(words.maxSizeSoFar());
		words.add ("d");
		System.out.println(words.maxSizeSoFar());
		words.remove ("a");
		System.out.println(words.maxSizeSoFar());
		words.add ("e");
		System.out.println(words.maxSizeSoFar());
		words.remove ("b");
		System.out.println(words.maxSizeSoFar());
		words.add ("d");
		System.out.println(words.maxSizeSoFar());
		words.remove ("c");
		System.out.println(words.maxSizeSoFar());
		words.remove ("d");
		System.out.println(words.maxSizeSoFar());
	}


	private static char[] maxSizeSoFar() {
		// TODO Auto-generated method stub
		return null;
	}

}
