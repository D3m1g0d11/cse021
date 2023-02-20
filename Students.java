package roommates;
//import java.util.Scanner;


public class Students {
	
	public String name;
	public char gender;
	public Date bdate;
	public boolean matched;
	public Preference pref;
	public String matchedWith;
	public int rmmtScr = -1;
	public String partner;
	
	public Students(String names, char gender, Date birthdateStr, Preference pref) {
		this.name = names;
		this.gender = gender;
		this.bdate = birthdateStr;
		this.pref = pref;
		this.matched = false;
	}
	
	
	public void matchedWith(String j, int score) {
		this.matchedWith = j;
		this.rmmtScr = score;
	}
	
	public void setMatch(Students stu) {
		this.setMatched();
		stu.setMatched();
	}
	
	public String getName() {
		return name;
	}
	public char getGender() {
		return gender;
	}
	
	
	public int getRmmtScr() {
		return rmmtScr;
	}
	
	public boolean getMatched() {
		return matched;
	}
	public String getPartner() {
		return partner;
	}
	
	public void setMatched() {
			this.matched = true;
		}
	public void setPartner(Students stu) {
		this.partner = stu.getName();
	}
	public int compare(Students stu) {
		if(this.gender == stu.gender) {
			int matching = ((40 - Math.abs(this.pref.compare(stu.pref))) + (60 - Math.abs(this.bdate.compare(stu.bdate))));
			return matching;
		}else {
			return 0;
			
		}
	}
	
	
	
	
}
