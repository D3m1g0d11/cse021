package roommates;
import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Match {
		
		 public static void main(String[] args) {
		       Students[] roommates = new Students[100];
		       

		       System.out.print("Enter the name of a text file: ");
		       Scanner input = new Scanner(System.in);
		       String fileName = input.next();
		       System.out.println();
		      
		       try {
		           Scanner file = new Scanner(new FileReader(fileName));
		           int studentsCount = 0;

		           // While Loop makes sure there is a line in file before it proceeds
		           while (file.hasNextLine() && studentsCount < 100) {
		               String line = file.nextLine();
		              
		               //.split puts each line into the String Array and removes the se
		               
		               String[] lineParts = line.split("\t");                  
		               String name = lineParts[0];
		               char gender = lineParts[1].charAt(0);
		               String date = lineParts[2];
		              
		               //Interger.paraseInt carefully converts the String into the equivalent integer
		               int quietTime = Integer.parseInt(lineParts[3]);
		               int music = Integer.parseInt(lineParts[4]);
		               int reading = Integer.parseInt(lineParts[5]);
		               int chatting = Integer.parseInt(lineParts[6]);
		              
		               String[] dateParts = date.split("-");
		               int month = Integer.parseInt(dateParts[0]);
		               int day = Integer.parseInt(dateParts[1]);
		               int year = Integer.parseInt(dateParts[2]);
		              
		               Date birthdate = new Date(month, day, year);
		               Preference pref = new Preference(quietTime, music, reading, chatting);
		              
		               // Creates a student class and record their information
		               Students stu = new Students(name, gender, birthdate, pref);
		               roommates[studentsCount] = stu;
		            
		               studentsCount++;
		           }
		           file.close();
		           input.close();
		                      
		           for(int i = 0; i < studentsCount; i++) {
		               Students recordi = roommates[i];
		              
		               if(recordi.getMatched() == true) {
		            	   continue;
		           }else{                  
		                   Students currentRmmt = null;
		                   int max = 0;
		                  
		                   for(int j = i + 1; j < studentsCount; j++) {
		                       Students recordj = roommates[j];
		                      
		                       if(recordj.getMatched() != true) {     
		                           int currentScore = recordi.compare(recordj);
		                          
		                           if(currentScore > max){
		                               currentRmmt = recordj;
		                               max = currentScore;
		                           }else {
		                        	   continue;
		                           }
		                       }
		                   }
		                  
		                   if(max == 0) {
		                       System.out.println(recordi.getName() + " has no matches.");
		                   }else{
		                       recordi.setMatched();
		                       currentRmmt.setMatched();                      
		                       System.out.println(recordi.getName() + " matches with " + currentRmmt.getName() + " with the score " + max);
		                   }
		               }
		           }
		       }
		       catch (NoSuchElementException e) {
		           System.out.println(e);
		       }
		       catch (FileNotFoundException e) {
		           System.out.println(e);
		       }
		   }
}
