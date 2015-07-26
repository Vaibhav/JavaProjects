/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Unit 10
*May 12, 2015
*/

import java.awt.*;
import java.util.*;
import java.applet.*;

//Scrolling text with arrays inside applets 

public class ArraysAndApplets extends Applet implements Runnable{
	
	//for double buffer
	Graphics buffer; 
	Image image; 
	
	//for random colour generator
	Random rand = new Random();
	
	//for font
	Font font = new Font("Arial", Font.BOLD, 24);
	
	//Declare Arrays
	String[] songs = {"Cheerleader","Hollywood","Choosin' Up","All Night","6 God"};
	Color[] color = {Color.blue, Color.green, Color.magenta, Color.red, Color.cyan};
	
	
	Thread s;
	
	int x=1 , y=1, i=0; 

	
	//when applet starts
	public void start(){
		
		//creating image for double buffer
		image = createImage(500,500);
		buffer = image.getGraphics();
		
		//initializing thread for the text animations
		if (s == null){
			s = new Thread(this);
			s.start();
		}
		
	}
	
	public void run(){
		
		while (true){
			
			//increases y value until y=250
			if (y<250){
				y+=10;
			}
			
			//then increases x value to scroll text to the right
			if (y>=250){
				x+=10;
			}
			
			//as text gets off the screen reset x and y values and increase value of i by 1
			if (x>=500){
				i++;
				y = 0;
				x = 0;
			}
			
			//resets array once it gets to 5th value. 
			if (i >= 5){
				i = 0;
			}
			
			
			repaint();
			//for thread errors 
			try {s.sleep(100);}
			catch (InterruptedException e){}
			
		}
	}
	
	//updates the paint method for double buffering
	public void update(Graphics gr){
		paint(gr);
	}
		
	
	public void paint(Graphics g){
		
		//random color generator for the background
		Color C = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		buffer.clearRect(0, 0, 500, 500);
		buffer.setColor(C);
		buffer.fillRect(0,0,500,500);
		
		//changes song and color for the text every time i increments. 
		String str = songs[i];
		Color c = color[i];
		
		//sets color for the new string and draws new string onto the applet
		buffer.setColor(c);
		buffer.setFont(font);
		buffer.drawString(str,x,y);
		
		//draws the whole image 
		g.drawImage(image,0,0,null);
		
	}
	
	
}//ends class 