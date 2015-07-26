/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Assignment J4
*Feb 17, 2015
*/

//This program will convert a given number of feet to meters


import java.io.*;
//tells java input and output will be used

public class Coins //defines class
{ //begins class definition
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
		
		//declare and initialize variables
		int coins, toonies, loonies, quarters, dimes, nickels, pennies; 
		String inData;
		
		//assigns value to the variables
		loonies = 100;
		toonies = 200;
		quarters = 25;
		dimes = 10;
		nickels = 5;
		pennies = 1;
				
		
		System.out.println("Enter number of cents:"); //prints a line that asks user to enter # of cents
		inData = stdin.readLine (); //gets user input as a string
		coins = Integer.parseInt(inData); //turns input into an integer and assigns it to variable
		
		
		
		int coin2 = (int) (coins / toonies); //divides # of cents by 200 for # of toonies		
		double remainder1 = (coins % 200); //takes what is left over and assigns to variable
		
		int coin1 = (int) (remainder1 / loonies); //divides remaining # of cents by 100 for # of loonies
		double remainder2 = (coins % 100); //takes what is left over and assigns to variable
				
		int coin3 = (int) (remainder2 / quarters); //divides # cents by 25 for # of quarters
		double remainder3 = (coins % 25); //takes what is left over and assigns to variable		
		
		int coin4 = (int) (remainder3 / dimes); //divides remaining # of cents by 10 for # of dimes
		double remainder4 = (coins % 10); //takes what is left over and assigns to variable		
		
		int coin5 = (int) (remainder4 / nickels); //divides remaining # of cents by 5 for # of nickels
		double remainder5 = (coins % 5); //takes what is left over and assigns to variable	
		
		int coin6 = (int) (remainder5 / pennies); //divides remaining # of cents by 1 for # of pennies
		double remainder6 = (coins %1);	//takes what is left over and assigns to variable	
		
		
			
		
		if ( coins < 0 == true)
			{ System.out.println("Please enter a positive integer!");
			}else{ System.out.println("Amount in coins: ");
			}
		/* if calculation turns out to be < 0 then it prints Please enter a positive integer!
		* or else it will print the amount of coins
		*/
			
			if ( coin2 > 0 == true){
				System.out.println("Toonies: " + coin2);
			} //only print this line if the value of toonies > 0
			
			
			if ( coin1 > 0 == true){			
				System.out.println("Loonies: " + coin1);
			} //only print this line if the value of loonies > 0
			
			if ( coin3 > 0 == true){
				System.out.println("Quarters: " + coin3);
			} //only print this line if the value of Quarters > 0
			
			if ( coin4 > 0 == true){
				System.out.println("Dimes: " + coin4);
			} //only print this line if the value of dimes > 0
			
			if ( coin5 > 0 == true){
				System.out.println("Nickels: " + coin5);
			} //only print this line if the value of nickels > 0
			
			if ( coin6 > 0 == true){
				System.out.println("Pennies: " + coin6);
			} //only print this line if the value of pennies > 0
			
	} //ends main method
	
} //ends class definition
