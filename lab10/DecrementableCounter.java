package oop;

public class DecrementableCounter extends Counter{
	
	private int counter = 0;
	
	public int decrement() {
		if(super.value() + counter <= 0) {
			return counter;

		}else {
			counter--;
			return counter;
		}
	}
	public int value(){
		return (super.value() + counter);
	}
}
