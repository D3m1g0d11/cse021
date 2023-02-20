package oop;

public class ModNCounter2   extends Counter {
	
	private int cycleLength; 

    public ModNCounter2 (int n) { 
    	cycleLength = n; 
    }  

    @Override
    public int value() { 
    	// fill in this method so that value() will return
    	// the correct value
    	if(super.value() < cycleLength ) {
    		return super.value();
    	}else {
    		super.reset();
    		return super.value();
    	}
    	
    } 
}
