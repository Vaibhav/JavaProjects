/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Unit 10
*May 12, 2015
*/

import java.io.*;

/*
Write a Java program that will fill a two-dimensional array table with numbers entered by the user from the command line. 

Your program should:
•	ask the user to input 20 numbers, one at a time, from the command line.
•	output the array table.
•	output the average of all the numbers in each of the five columns with a statement similar to:
The average of the first column is 67.
*/



class ArrayTableAverage//defines class
{ //begins class definition
	
	
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException 
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
		
		//declare variables
		String inData;
		int k = 1; 
		
		//create 2D array
		int[][] num = new int[4][5];
		 
		 //for loop to gather all the number to create a table using arrays
		 for(int i=0; i<4; i++){
			 for(int j=0; j<5; j++){	
			 
			//asking user to input numbers 
			System.out.println("Enter number " + k++ + ":");
			inData = stdin.readLine();
			int n1 = Integer.parseInt(inData);
			//assigning the entered variable to the array
			num [i][j] = n1;
			k=k++;
			
			} 
		}
		
		//acts as a separator 
		System.out.println(" ");
		System.out.println("===============");
		System.out.println(" ");
		
		//prints the entered numbers as a table in cmd
		for(int rows = 0; rows<4; rows++)
		{
				for(int columns = 0; columns<5; columns++)
				{
					System.out.print(num[rows][columns] + "  ");
				}
			System.out.println();
		}
		
		//acts as a separator 
		System.out.println(" ");
		System.out.println("===============");
		System.out.println(" ");
		
		//averaging all 5 columns
		int Av1 = (num[0][0] + num[1][0] + num[2][0] + num[3][0]) / 4;
		int Av2 = (num[0][1] + num[1][1] + num[2][1] + num[3][1]) / 4;
		int Av3 = (num[0][2] + num[1][2] + num[2][2] + num[3][2]) / 4;
		int Av4 = (num[0][3] + num[1][3] + num[2][3] + num[3][3]) / 4;
		int Av5 = (num[0][4] + num[1][4] + num[2][4] + num[3][4]) / 4;
		
		//output the averages of each column
		System.out.println("Average of the first column is: "  + Av1);
		System.out.println("Average of the second column is: "  + Av2);
		System.out.println("Average of the third column is: "  + Av3);
		System.out.println("Average of the fourth column is: "  + Av4);
		System.out.println("Average of the fifth column is: "  + Av5);
	
	}
}