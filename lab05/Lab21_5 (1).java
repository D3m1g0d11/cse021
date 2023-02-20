package packag.copy;

public class Lab21_5 {

	public static void init(long[] arr) {
		// Initialize all the entries of the array to 0
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	public static long sumAll(int max) {
		// sumAll basic version
		long subTotal = 0;
		for (int i = 1; i <= max; i++) {
			subTotal += i;
			System.out.println("sumAll " + i + " value " + subTotal);
		}
		return subTotal;
	}
	
	public static long sumAll(long[] arr, int max) {
		// Use the array to store sub results
		for (int i = 1; i <= max ; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1] + i;	
				System.out.println("sumAll[" + i + "] value " + arr[i]);
			}
		}
		return arr[max];

	}

   // Fill-in the appropriate methods to complete the lab
	
	public static long squareSum(int x) {
		long subTotal = 0;
		for (int i = 1; i <= x; i++) {
			subTotal += i*i;
			System.out.println("squareSum " + i + " value " + subTotal);
		}
		return subTotal;

 	}

	public static long squareSum(long[] arr, int y){
		for (int i = 1; i <= y ; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1] + i*i;	
				System.out.println("squareSum[" + i + "] value " + arr[i]);
			}
		}
		return arr[y];
  		
  		
  	}
	
	public static long fib(int x) {
		int j = 0;
		int k = 1;
		int fib = 0;
		for (int i = 2; i <= x; i++) {
			if (j > k) {
				fib = k+j;
				k = fib;
			}
			else {
				fib = j+k;
				j = fib;
			}
			System.out.println("Fibonacci " + i + " value " + fib);
		}
		return fib;

 	}
 
	public static long fib(long[] arr, int y){
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= y ; i++) {
			if(arr[i] == 0) {
			long fib = arr[i-1] + arr[i-2];
				arr[i] = fib;
				System.out.println("Fibonacci[" + i + "] value " + arr[i]);
			}
		}	
		return arr[y];
  	}
	
	public static long factorial(int w) {
		long subTotal = 1;
		for (int i = 2; i <= w; i++) {
			subTotal *= i;
			System.out.println("Factorial " + i + " value " + subTotal);
		}
		return subTotal;

 	}
 
	public static long factorial(long[] arr, int z){
		arr[0] = 1;
		for (int i = 1; i <= z ; i++) {
				if(arr[i] == 0) {
				arr[i] = arr[i-1]*i;	
				System.out.println("Factorial[" + i + "] value " + arr[i]);
				}
		}
		return arr[z];
  	}
	
	public static void main(String[] args) {

		final int MAXSIZE = 100;
		long[] arr = new long[MAXSIZE];

		System.out.println("sumAll output for 5 is " + sumAll(5));
		System.out.println("sumAll output for 10 is " + sumAll(10));
		System.out.println("sumAll output for 20 is " + sumAll(20));
		System.out.println("sumAll output for 15 is " + sumAll(15));
		System.out.println();

		init(arr);
		System.out.println("sumAll output for 5 is " + sumAll(arr, 5));
		System.out.println("sumAll output for 10 is " + sumAll(arr, 10));
		System.out.println("sumAll output for 20 is " + sumAll(arr, 20));
		System.out.println("sumAll output for 15 is " + sumAll(arr, 15));
		System.out.println();

		
		System.out.println("squareSum output for 5 is " + squareSum(5));
		System.out.println("squareSum output for 10 is " + squareSum(10));
		System.out.println("squareSum output for 20 is " + squareSum(20));
		System.out.println("squareSum output for 15 is " + squareSum(15));
		System.out.println();

		init(arr);
		System.out.println("squareSum output for 5 is " + squareSum(arr, 5));
		System.out.println("squareSum output for 10 is " + squareSum(arr, 10));
		System.out.println("squareSum output for 20 is " + squareSum(arr, 20));
		System.out.println("squareSum output for 15 is " + squareSum(arr, 15));
		System.out.println();

		System.out.println("Fibonacci Number 5 is " + fib(5));
		System.out.println("Fibonacci Number 10 is " + fib(10));
		System.out.println("Fibonacci Number 20 is " + fib(20));
		System.out.println("Fibonacci Number 15 is " + fib(15));
		System.out.println();

		init(arr);
		System.out.println("Fibonacci Number 5 is " + fib(arr, 5));
		System.out.println("Fibonacci Number 10 is " + fib(arr, 10));
		System.out.println("Fibonacci Number 20 is " + fib(arr, 20));
		System.out.println("Fibonacci Number 15 is " + fib(arr, 15));
		System.out.println();

		System.out.println("Factorial of 5 is " + factorial(5));
		System.out.println("Factorial of 10 is " + factorial(10));
		System.out.println("Factorial of 20 is " + factorial(20));
		System.out.println("Factorial of 15 is " + factorial(15));
		System.out.println();

		init(arr);
		System.out.println("Factorial of 5 is " + factorial(arr, 5));
		System.out.println("Factorial of 10 is " + factorial(arr, 10));
		System.out.println("Factorial of 20 is " + factorial(arr, 20));
		System.out.println("Factorial of 15 is " + factorial(arr, 15));
		
	} 

}
