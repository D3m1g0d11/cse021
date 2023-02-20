package roommates;
import java.util.Scanner;

public class Date {
	public int year;
	public int day;
	public int month;
	
	public Date(int dMonth, int dDay, int dYear)
	   {
	       // year range: from 1900 to 3000
	       if (dYear < 1900)
	           year = 1900;
	       else if (dYear > 3000)
	           year = 3000;
	       else
	           year = dYear;

	       // month range: from 1 to 12
	       if (dMonth < 1)
	           month = 1;
	       else if (dMonth > 12) {
	           this.month = 12;
	       }else {
	    	   this.month = dMonth;
	       }
	           this.day = dDay;
	   }
	
	 public int getYear()
	   {
	       return year;
	   }

	   public int getMonth()
	   {
	       return month;
	   }

	   public int getDay()
	   {
	       return day;
	   }
	
	
	public int dayOfYear() {
		int totalDays = 0;
		switch (this.month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += this.day;
		return totalDays;
		}
	public int compare(Date dt) {
		int dtDays = Math.abs(this.year - dt.year)*365;
		int daysDifference = Math.abs(this.dayOfYear() - dt.dayOfYear());
		int monthsDifference = Math.abs(dtDays- daysDifference);
		
		monthsDifference = monthsDifference/30;
		
		if (monthsDifference >= 60) {
			return 60;
		} 
		
		return monthsDifference;
		
	}
}
