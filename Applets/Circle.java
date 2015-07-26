/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Unit 8
*April 10, 2015
*/

import java.awt.*;
import java.applet.Applet;
import java.applet.*;

//Creates an applet with my name in the center of a circle


public class Circle extends Applet //class extends to applet
{
	
	public void paint(Graphics g){ //overrides paint method
		
		//declare variables
		String str;
		int xc, yc;
		
		//assign variables
		str = "Ishu Khaitan";
		FontMetrics fm = g.getFontMetrics();
		Dimension d = getSize(); //get size of applet
			
		//makes text appear in the centre of the applet 
		xc = d.width/2 - fm.stringWidth(str)/2; 
		yc = d.height/2 - fm.getDescent();
		
		//draws a circle
		g.drawOval(1, 1, 300, 300);
		//plsaces my name in the center
		g.drawString(str,xc,yc);
		
	}
	
	
}
