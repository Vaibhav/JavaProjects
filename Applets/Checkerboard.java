/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Unit 8
*April 15, 2015
*/

import java.awt.*;
import javax.swing.*;
import java.applet.*;

//This program creates a checker board applet

public class Checkerboard extends Applet //class extends to applet
{
	//declares integers	
	int row, column, x, y;
	
	public void init(){ //overrides initialize method
		setBackground(Color.BLACK); //set background color to black
	}
		
	public void paint(Graphics g) //overrides paint method
	{
		
		for (row = 0; row < 8; row++){ //a for loop to generate 8 rows of red boxes
			
			for(column = 0;column<8; column++ ){ //a for loop to generate 8 columns of red boxes
			
			//x and y coordinates for 20x20 squares
			x = column * 20;
			y = row * 20;
			
			if((row % 2) == (column % 2)){
				g.setColor(Color.RED); //sets box colour to red
				g.fillRect(x, y, 20, 20); //creates the 20x20 square. 
			}
				
			}
			
		}
		
	}
	
}