/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Unit 8
*April 10, 2015
*/


import java.applet.*;
import java.awt.*;
import javax.swing.*;

//creates 3 concentric circles with 3 different colors

public class Circles extends Applet //class extends to applet
{
			
	public void paint(Graphics g){ //overrides paint method
		
		//for loop which creates 3 random colors
		for(int i = 0;i < 3;i++){
			
		int R = (int)(Math.random( )*256);
        int G = (int)(Math.random( )*256);
        int B = (int)(Math.random( )*256);
        Color randomColor = new Color(R, G, B);
		
		//set color to random color that was generated
		g.setColor(randomColor);
		//creates 3 circles with color set to random
		g.fillOval(100+i*10,100+i*10,100-i*20,100-i*20);
		}
		
	}
	
	
}