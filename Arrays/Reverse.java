/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Unit 10
*May 12, 2015
*/

import java.io.*;

//Output numbers in reverse order 

class Reverse{
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
		
		//declare variables 
		String inData;
		
		//create array
		int[] Rev = new int[10];
		
		//ask user to input 10 numbers
		 for(int i=0; i<10; i++){
		
		int r = i + 1;
		System.out.println("Enter number " + r + ":");
		inData = stdin.readLine();
		int n1 = Integer.parseInt(inData);
		//store those numbers into the array
		Rev [i] = n1;
		 
			 
		}
		
		//output array in reverse order 
		System.out.println("In reverse: " + Rev[9] +" "+ Rev[8] +" "+ Rev[7] +" "+ Rev[6] +" "+ Rev[5] +" "+ Rev[4] +" "+ Rev[3] +" "+ Rev[2] +" "+ Rev[1] +" "+ Rev[0]);
		
	}
	
	
}