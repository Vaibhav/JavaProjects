/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Unit 10
*May 12, 2015
*/

import java.io.*;

//average 10 numbers using arrays

class Average{
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
		
		//declares variables
		String inData;
		
		//creates an array
		double[] Avg = new double[10];
		
		//loop that asks for 10 numbers from the user 
		for(int i=0; i<10; i++){
		
		int r = i + 1;
		System.out.println("Enter number " +r+ ":");
		inData = stdin.readLine();
		double n1 = Double.parseDouble(inData);
		
		//assign the numbers into the array
		Avg [i] = n1;
				 
		}
		 
		double sum = 0;
		
		//gets the total of all the numbers in the array
			for( double average : Avg) {
				sum += average;
			}
		
		//divide the total by 10 to get average
		double average = (sum / 10);
		
		//output average
		System.out.println("Average is: " + average);
		
	}
	
	
	
	
}