/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Assignment J7
*March 1, 2015
*/

//This program will create a guessing game

import java.io.*;
//tells java input and output will be used

public class Striker //defines class
{ //begins class definition
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		System.out.println(" "); //when program starts, it prints these lines out
		System.out.println("Welcome to Striker! The guessing game!"); //just for fun
		System.out.println(" "); 
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
        
		//declares variables
        String inData, inData2;
		int p1, p2, counter, guesscounter;
		counter = 1; //assigns variables
		guesscounter = 1;
		
		System.out.print("Player one please enter the number to be guessed:");
		inData = stdin.readLine (); //gets user input as a string
		p1 = Integer.parseInt(inData);//converts string to integer
		Math.abs(p1); //takes absolute value of integer
		
		while ((1000 <= p1)){ //number has to be less than 1000 or else this will loop
		
			System.out.println("Enter an integer between 1 and 1000");
			System.out.println("Player one please enter the number to be guessed:");
			inData = stdin.readLine (); //gets user input as a string
			p1 = Integer.parseInt(inData);
			
		}
		
		while(counter != 75){ 
			System.out.println(" ");
			++counter;
		} //makes a bunch of lines so second user can not see the first player's number
		
		System.out.println("Don't cheat!");
		
		
	
		System.out.println("Player two guess a number:");
		inData2 = stdin.readLine (); //gets user input as a string
		p2 = Integer.parseInt(inData2);//converts string to integer
		Math.abs(p2); //takes absolute value of integer
		
		while (p2 != p1)
		{
			
		if (p2 > p1){
			System.out.println("Your guess is too high!  Try a lower number.");
			System.out.println("Player two guess another number:");
			inData = stdin.readLine (); //gets user input as a string
			p2 = Integer.parseInt(inData);//converts string to integer
			guesscounter++;//adds 1 to guess counter
		}else{
			System.out.println("Your guess is too low!  Try a higher number.");
			System.out.println("Player two guess another number:");
			inData = stdin.readLine (); //gets user input as a string
			p2 = Integer.parseInt(inData);//converts string to integer
			guesscounter++;//adds one to guess counter	
			}
		}
		
		
		
		if (p2 == p1){ //if guessed correctly
			System.out.println("Congratulations, you guessed it!"); //tell user they guessed it
			System.out.println("It took you " + guesscounter + " guesses!"); //output number of guesses
		}
		
	
		
	}//ends main method
}//ends class definition