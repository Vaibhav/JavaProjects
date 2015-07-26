/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Assignment J5
*Feb 26, 2015
*/

//This program will process a HomeDepot order


import java.io.*;
//tells java input and output will be used

public class HomeDepot //defines class
{ //begins class definition
	
	//program starts running when main method is called
	public static void main (String[] args) throws IOException, InterruptedException
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
		
		
		System.out.println(" "); //when program starts, it prints these lines out
		System.out.println("Welcome to the Home Depot order page."); //just for fun
		System.out.println(" "); 
		
		
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (inStream);
        
		
		//declares variables
        String inData, inData2, inData3;
        int nuts, bolts, washers;
		int nutprice, boltprice, washerprice;
		nutprice = 5;
		boltprice = 5;
		washerprice = 2;
		//assigns value to variables
		
		
		System.out.println("Please enter quantity for nuts:");
		inData = stdin.readLine (); //gets user input as a string
		nuts = Integer.parseInt(inData); //turns input into an integer and assigns it to variable
		
		while(nuts <= 50){ 
		//while requested amount is under 50 program will loop notifying reader to order more
		
			System.out.println( nuts + " nuts have been requested.");
			System.out.println("A minimum of 50 nuts must be ordered before your order can be processed. Please re-enter the minimum amount.");
			System.out.println("Please enter quantity for nuts:"); //asks user to enter amount of nuts again
			inData = stdin.readLine (); //gets user input as a string
			nuts = Integer.parseInt(inData); //turns input into an integer and assigns it to variable
			
		}
		System.out.println( nuts + " nuts have been requested."); //if order amount is greater than 50 it will request the amount.




		System.out.println("Please enter quantity for bolts:");
		inData2 = stdin.readLine (); //gets user input as a string
		bolts = Integer.parseInt(inData2); //turns input into an integer and assigns it to variable
		
		while((bolts <= 50)){
		//while requested amount is under 50 program will loop notifying reader to order more
		
			System.out.println( bolts + " bolts have been requested.");
			System.out.println("A minimum of 50 bolts must be ordered before your order can be processed.  Please re-enter the minimum amount.");
			System.out.println("Please enter quantity for bolts:");
			inData2 = stdin.readLine (); //gets user input as a string
			bolts = Integer.parseInt(inData2); //turns input into an integer and assigns it to variable
			
		}
		System.out.println( bolts + " bolts have been requested."); //if order amount is greater than 50 it will request the amount.
		
		
		
		System.out.println("Please enter quantity for washers:");
		inData3 = stdin.readLine (); //gets user input as a string
		washers = Integer.parseInt(inData3); //turns input into an integer and assigns it to variable
		
		while((washers <= 50)){
		//while requested amount is under 50 program will loop notifying reader to order more
		
			System.out.println( washers + " washers have been requested.");
			System.out.println("A minimum of 50 washers must be ordered before your order can be processed.  Please re-enter the minimum amount.");
			System.out.println("Please enter quantity for washers:");
			inData3 = stdin.readLine (); //gets user input as a string
			washers = Integer.parseInt(inData3); //turns input into an integer and assigns it to variable
			
		}
		System.out.println( washers + " washers have been requested."); //if order amount is greater than 50 it will request the amount.
		
		
		
		System.out.println("Please wait while your order is processed.");//asks user to wait
		Thread.sleep (2000);
		System.out.print("."); 
		Thread.sleep (2000);
		System.out.print(".");
		Thread.sleep (2000);
		System.out.println("."); //makes user wait 6 seconds before order is processed
		
		

		int NutTotal = (nuts * nutprice); //calculates price of nuts in cents
		int NutTotalDollar = (NutTotal / 100); //gets number of dollars
		int NutTotalCents = (NutTotal % 100); //gets number of cents
		System.out.println("Nuts: $" + NutTotalDollar + "." + NutTotalCents); //prints out cost of nuts
		
		
		
		int BoltTotal = (bolts * boltprice); //calculates price of bolts in cents
		int boltTotalDollar = (BoltTotal / 100); //gets number of dollars
		int boltTotalCents = (BoltTotal % 100); //gets number of cents
		System.out.println("Bolts: $" + boltTotalDollar + "." + boltTotalCents); //prints out cost of bolts
		
		
		
		int washerTotal = (washers * washerprice); //calculates price of washers in cents
		int washerTotalDollar = (washerTotal / 100); //gets number of dollars
		int washerTotalCents = (washerTotal % 100); //gets number of cents
		System.out.println("Washers: $" + washerTotalDollar + "." + washerTotalCents); //prints out cost of washers
		
		
		
		int SubTotal = (NutTotal + BoltTotal + washerTotal); //Subtotal in Cents
		int SubTotalDollar = (SubTotal/100); //gets number of dollars
		int SubTotalCents =  (SubTotal % 100); //gets number of cents
		System.out.println("SubTotal: $" + SubTotalDollar + "." + SubTotalCents); //prints out subtotal
		
		
		
		double HST = (SubTotal * 0.13); //changes to double to add tax
		double HSTTotalDollar = (HST/100);
		System.out.println("HST: $" + HSTTotalDollar); //prints total in tax
		//java too outdated to make value print only 2 decimals.
		
		
		double Total = (SubTotal + HST); //add tax to subtotal
		double TotalDollar = (Total/100);
		System.out.println("Total: $" + TotalDollar); //prints out total
		//java too outdated to make value print only 2 decimals.
		
		System.out.println("Thank for shopping at Home Depot");
		
	}//ends main method
}//ends class definition
		
		
		
		
		