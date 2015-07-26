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

public class FeetToMeter //defines class
{ //begins class definition
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
		
		//declare and initialize variables
		double feet, converter, meter;
		String inData;
		converter = 0.305;
		
		
		System.out.println("Enter number of feet:"); //prints a line that asks user to enter # of feet
		inData = stdin.readLine ( ); //gets user input as a string
		feet = Integer.parseInt(inData); //turns input into an integer and assigns it to variable
		
		meter = feet*converter; //performs calculation
		System.out.println("Meters = " + meter); //outputs result
		
	} //end main method
	
} //ends class