/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Assignment J4
*Feb 17, 2015
*/

//This program adds up all the digits of a given integer

import java.io.*;
//tells java input and output will be used

public class Integer //defines class
{//begins class definition
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
	
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
        
		//declare and initialize variables
		int given, hundreds, tens, ones, sum, justone;
		String inData;
		//assigns value to the variables
		justone = 1;
		
		
		System.out.println("Enter number: ");//prints a line that asks user to enter front left tire pressure
		inData = stdin.readLine (); //gets user input as a string
		given = Integer.parseInt(inData); //turns input into an integer and assigns it to variable
		
		if (given == 1000) { //if integer entered is 1000 sum of digits is 1
			System.out.println("The sum of all the digits are: " + justone);
		}else{ //else do calculations
		
		hundreds = (given / 100); //to get the single digit
		tens = ((given / 10) % 10); //to get second digit
		ones = (given % 10); //to get last digit
		
		sum = hundreds + tens + ones; //add all the digits 
		
		System.out.println("The sum of all the digits are: " + sum); //output sum
		
		}//ends else statement
		
	}//ends main method
	
}//ends class definition
