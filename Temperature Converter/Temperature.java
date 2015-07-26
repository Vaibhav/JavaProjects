/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Assignment J9
*March 23, 2015
*/

import java.io.*;

//This program will convert Celsius & Fahrenheit temperatures

//new class
class Converter
{
	
	double CTemp, FTemp; //initialize variables

	//create constructor which assigns variables
	public Converter(double input){
		CTemp = input;
		FTemp = input;
	}	
	
	//method to convert Celsius to Fahrenheit
	double CConvert(){
		FTemp = (9.0 / 5.0) * CTemp + 32;
		return FTemp;
	}
	
	//method to convert Fahrenheit to Celsius
	double FConvert(){
		CTemp  = (5.0 / 9.0) * (FTemp - 32);
		return CTemp;
	}
	
	//prints out Celsius 
	void Celsius(){
		System.out.println("Celsius: " + CTemp);
	}
	
	//prints our Fahrenheit
	void Farenheit(){
		System.out.println("Fahrenheit: " + FTemp);
	}
		
}


//main class 
public class Temperature{
	
	public static void main(String[] args) throws IOException
	{
		//creates a buffered reader
		InputStreamReader inStream = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (inStream);
		
		//declares variables
		String inData, inData2, conversion;
		double input;
		
		//Asks user what he wants to convert
		System.out.println("For Fahrenheit to Celsius Hit F ");
		System.out.println("For Celsius to Fahrenheit Hit C ");
		//reads the line and stores as string
		inData = stdin.readLine();
		conversion = inData;
		
		//if the string is equal to F then convert from Fahrenheit to Celsius 
		if (conversion.toLowerCase().trim().equals("f"))
		{
			//asks user to input the temperature
			System.out.println("Input a temperature: ");
			inData2 = stdin.readLine();
			input = Double.parseDouble(inData2);
			
			//sends input to constructor
			Converter c2 = new Converter(input);
			
			//calls methods
			c2.FConvert();
			c2.Celsius();
		}
		
		//if string is equal to C then convert from Celsius to Fahrenheit
		if(conversion.toLowerCase().trim().equals("c"))
		{
		//asks user to input the temperature
		System.out.println("Input a temperature: ");
		inData2 = stdin.readLine();
		input = Double.parseDouble(inData2);
		
		//sends input to constructor
		Converter c1 = new Converter(input);
		
		//calls methods 
		c1.CConvert();
		c1.Farenheit();
		}
		
		
	}//ends main method
}//ends class definition