/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Assignment J5
*Feb 20, 2015
*/

//This program will analyse tire pressure


import java.io.*;
//tells java input and output will be used

public class Tire //defines class
{ //begins class definition
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		System.out.println(" "); //when program starts, it prints these lines out
		System.out.println("Check if your tires are OK!"); //just for fun
		System.out.println(" "); 
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
        
		//declares variables
        String inData, inData2, inData3, inData4;
        int frontleft, frontright, backleft, backright, low, high;
		//assigns value to variables
		low = 32;
		high = 38;
        
		System.out.println("Enter All Values in PSI");
        System.out.println("Enter front left tire pressure:"); //prints a line that asks user to enter front left tire pressure
		inData = stdin.readLine (); //gets user input as a string
		frontleft = Integer.parseInt(inData); //turns input into an integer and assigns it to variable
		
		System.out.println("Enter front right tire pressure:"); //prints a line that asks user to enter front right tire pressure
		inData2 = stdin.readLine (); //gets user input as a string
		frontright = Integer.parseInt(inData2); //turns input into an integer and assigns it to variable
		
		System.out.println("Enter back left tire pressure:"); //prints a line that asks user to enter back left tire pressure
		inData3 = stdin.readLine (); //gets user input as a string
		backleft = Integer.parseInt(inData3); //turns input into an integer and assigns it to variable
		
		System.out.println("Enter back right tire pressure:"); //prints a line that asks user to enter back right tire pressure
		inData4 = stdin.readLine (); //gets user input as a string
		backright = Integer.parseInt(inData4); //turns input into an integer and assigns it to variable
		
				
		if (frontleft == frontright){ //if front tires are equal pressure
			System.out.println("Tire inflation is the same: front"); //print this line
		}else{ //if not equal 
			System.out.println("Tire inflation is not the same: front"); //print this
		}
		
		if (backleft == backright){ //if back tires are equal pressure
			System.out.println("Tire inflation is the same: back"); //print this line
		}else{ //if not equal
			System.out.println("Tire inflation is not the same: back"); //print this
		}
		
		if (backleft == backright && high >= backleft &&  backleft >= low){ //if equal and within range
			System.out.println("Tire inflation is within the specified range of 32 and 38 psi: back");
		}else{ //if not
			System.out.println("Tire inflation is not within the specified range of 32 and 38 psi: back");
		}
		
		if (frontleft == frontright && high >= frontleft && frontleft >= low){ //if equal and within range
			System.out.println("Tire inflation is within the specified range of 32 and 38 psi: front");
		}else{ //if not
			System.out.println("Tire inflation is not within the specified range of 32 and 38 psi: front");
		}
		
		if (low >= frontleft || frontleft >= high){ //if not within range
			System.out.println("Tire out of range: front left");
		}
		
		if (low >= frontright || frontright >= high){ //if not within range
			System.out.println("Tire out of range: front right");
		}
		
		if (low >= backleft || backleft >= high){ //if not within range
			System.out.println("Tire out of range: back left");
		}
		
		if (low >= backright || backright >= high){ //if not within range
			System.out.println("Tire out of range: back right");
		}
		
	
	}//ends main method
} //ends class definition 