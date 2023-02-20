package oop;

import static org.junit.Assert.assertEquals;

public class Runner {

	public static void main(String[] args) {
		testCounter();

		testCounter7Statements();

		testModNCounter();
		
		testModNCounter2();

		testDecrementableCounter();

		testSeasonCounter();
	}
	
	private static void testDecrementableCounter() {
		System.out.println("-- Testing: DecrementableCounter");
		DecrementableCounter ctr = new DecrementableCounter();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println("Current value: " + ctr.value ());
		ctr.decrement();
		System.out.println("Current value: " + ctr.value ());
		ctr.increment();
		ctr.increment();
		System.out.println("Current value: " + ctr.value ());
		ctr.decrement();
		System.out.println("Current value: " + ctr.value ());
		System.out.println("Current value: " + ctr.value ());
		
	}
	private static void testSeasonCounter(){
		
		System.out.println("-- Testing: SeasonCounter");
		SeasonCounter ctr = new SeasonCounter();
		System.out.println(ctr.toString());
		ctr.increment();
		System.out.println(ctr.toString());
		ctr.increment();
		System.out.println(ctr.toString());
		ctr.increment();
		System.out.println(ctr.toString());
		ctr.increment();
		System.out.println(ctr.toString());
	}
	
	private static void testModNCounter() {

		System.out.println("-- Testing: ModNCounter");
		ModNCounter ctr = new ModNCounter(3);
		for (int i=1; i<7; i++) {
			ctr.increment();
		}
		ctr.reset();
		ctr.increment();
		ctr.increment();
		System.out.println(ctr.value());
		ctr.increment();
		System.out.println(ctr.value());
}
		


	private static void testModNCounter2() {
		System.out.println("-- Testing: ModNCounter2 ");
		ModNCounter2 ctr = new ModNCounter2(3);
		for (int i=1; i<7; i++) {
			ctr.increment();
		}
		
		System.out.println(ctr.value());
		
		ctr.reset();
		ctr.increment();
		ctr.increment();
		ctr.increment();
		
		System.out.println(ctr.value());
	}


	public static void testCounter() {
		System.out.println("-- Testing Counter");

		Counter c = new Counter();
		c.increment();
		System.out.println("Current value: " + c.value());
		
		ModNCounter d = new ModNCounter(2);
		System.out.println(d.value());
		d.increment();
		System.out.println(d.value());
		d.increment();
		System.out.println(d.value());
		d.increment();

	}

	
	public static void testCounter7Statements() {
		Counter c = new Counter();
		System.out.println("-- Testing 7 statements");
		// include exactly 7 increment() and reset() statements below
		
		c.increment();
		c.reset();
		c.increment();
		c.increment();
		c.reset();
		c.reset();
		c.reset();
		c.reset();
		c.reset();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current value: " + c.value());
	}

}
