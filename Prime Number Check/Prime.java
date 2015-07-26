/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Assignment J7
*March 9, 2015
*/

//This program will check if a number is a prime number or not


import java.io.*;
//tells java input and output will be used

public class Prime //defines class
{ //begins class definition
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		System.out.println(" "); //when program starts, it prints these lines out
		System.out.println("Check if your number is prime!"); //just for fun
		System.out.println(" "); 
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
        
		//declares variables
        String inData;
		int input;
		boolean prime = true;
		
		System.out.println("Enter a number");
        inData = stdin.readLine();  //gets user input as a string
		input = Integer.parseInt(inData); //converts string to integer and assigns it to variable

		/* for loop
		input is divided by numbers lesser than it
		loop checks if it is evenly divided
		if it is then it isn't prime
		*/
		
		for (int i = 2; i < input; i++) {
			if (input % i == 0) {
				prime = false;
			}
		}
		
		if (input == 1){ //one is prime no matter what
			System.out.println(input + " is not a prime number.");
		}
		
		
		if (!prime){ //if prime is false
			System.out.println(input + " is not a prime number.");
		}else{ //if prime is true
			System.out.println(input + " is a prime number.");
		}
		
	}//ends main method
}//ends class definition
		