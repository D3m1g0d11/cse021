public class Lab21_Objects {

	public static void main(String[] args) {
		// DO NOT CREATE NEW VARIABLES
		
		Dummy[] dlist = new Dummy[11];
		int[] iarr = new int[11];
		double[] darr = new double[11];

		// DO NOT USE ANY CONSTANTS OR NEW VARIABLES
		
		// Calls to Constructors 1 and 2  
		dlist[0] = new Dummy();
		dlist[1] = new Dummy(iarr[0]);
		
		// Fill-in calls to Constructors 3-11 and assign them to dlist array indices 2-10
		dlist[2] = new Dummy(darr[0]); //Cons 3
		dlist[3] = new Dummy(iarr);  //Cons 4
		dlist[4] = new Dummy(darr);//Cons 5
		dlist[5] = new Dummy(dlist[0]); //Cons 6
		dlist[6] = new Dummy(dlist);//Cons 7
		dlist[7] = new Dummy(1, 6.8); //Cons 8
		dlist[8] = new Dummy(iarr, darr); //Cons 9
		dlist[9] = new Dummy(0, 7.5, dlist[0]); //Cons 10
		dlist[10] = new Dummy(iarr, darr, dlist);  //Cons 11
		
		
		// Calls to diplay methods 1 and 2
		dlist[0].display();
		dlist[1].display(iarr[0]);
		
		// Fill-in calls to display methods 3-11 for the dlist objects at indices 2-10
		dlist[2].display(darr[0]); //3
		dlist[3].display(iarr); //4
		dlist[4].display(darr); //5
		dlist[5].display(dlist[0]); //6
		dlist[6].display(dlist); //7
		dlist[7].display(1, 6.8); //8
		dlist[8].display(iarr, darr); //9
		dlist[9].display(iarr[10], darr[10], dlist[0]); //10
		dlist[10].display(iarr, darr, dlist); //11
	
	}
}
