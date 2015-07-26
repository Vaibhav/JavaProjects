/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Unit 8
*April 22, 2015
*/


import java.awt.*;
import java.applet.*;
import java.util.*;

//this applet creates a snowman and snows. 

public class Snowman extends Applet implements Runnable{ 
//declares class and extends applet functions

	//for double buffer
	Graphics buffer; 
	Image image; 
	//for snowfall
	Thread Snowfall;
	
	int counter = 0, yposition = -5;
	
	//for random colour generator
	Random rand = new Random();

	
	
	//when applet starts
	public void start(){
		
		//creating image for double buffer
		image = createImage(500,800);
		buffer = image.getGraphics();
		
		//initializing thread for snowfall
		if (Snowfall == null){
			Snowfall = new Thread(this);
			Snowfall.start();
		}
		
	}
	
	
	
	public void run(){
		
		//looping snowfall 
		while (true && counter < 999999999)
		{
			//snowfall rate is 5 pixels per loop
			yposition += 5;
			
			//resets snowfall when hits the ground
			if (yposition >= 489)
			{
				yposition = 0;
			}
			
			repaint();
			//for thread errors 
			try {Snowfall.sleep(50);}
			catch (InterruptedException e){}
			counter++;
			
		}
	}
	
	
	//updates the paint method for double buffering
	public void update(Graphics gr){
		paint(gr);
	}
	
		
	
	public void paint(Graphics g){
	
	/*creates a background
	this is a random color generator
	applies random color to the background*/
	
	Color c = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
	buffer.clearRect(0, 0, 500, 800);
	buffer.setColor(c);
	buffer.fillRect(0,0,500,500);
		
	
	//creates the sun
	buffer.setColor(Color.ORANGE);
	buffer.fillOval(-25, -25, 150, 150);
	
	//creates the snowman's bottom
	buffer.setColor(Color.WHITE);
	buffer.fillOval(145, 290, 200, 200);
	
	//creates the snowman's torso
	buffer.setColor(Color.WHITE);
	buffer.fillOval(170, 215, 150, 150);
	
	
	//creates the snowman's head
	buffer.setColor(Color.WHITE);
	buffer.fillOval(195, 135, 100, 100);
	
	//creates the snowman's mouth
	buffer.setColor(Color.BLACK);
	buffer.drawArc(234, 193, 20, 10, 190, 160);
	
	
	//creates the snowman's eyes
	buffer.setColor(Color.BLACK);
	buffer.fillRect(225, 160, 7, 7);
	buffer.fillRect(260, 160, 7, 7);
	
	//creates the snowman's hat
	buffer.fillRect(205, 130, 80, 10);
	buffer.fillRect(225, 70, 42, 60);
	
	//creates the snowman's arms
	buffer.drawLine(170, 275, 130, 200);
	buffer.drawLine(318, 275, 360, 200);
	
	//creates the horizon
	buffer.drawLine(0, 490, 500, 490);
	
	//creates the ground
	buffer.setColor(Color.GRAY);
	buffer.fillRect(0, 490, 500, 500);
	
	//creates the snowman's buttons
	buffer.fillOval(245, 255, 7, 7);
	buffer.fillOval(245, 305, 7, 7);
	buffer.fillOval(245, 355, 7, 7);
	

	//snowfall and snowflakes - initial position of each snowflake
	buffer.setColor(Color.white);
	buffer.fillOval(80, yposition-12, 8, 8);
	buffer.fillOval(140, yposition, 6, 6);
	buffer.fillOval(150, yposition-12, 6, 6);
	buffer.fillOval(160, yposition, 6, 6);
	buffer.fillOval(180, yposition-12, 8, 8);
	buffer.fillOval(190, yposition-10, 8, 8);
	buffer.fillOval(200, yposition, 6, 6);
	buffer.fillOval(220, yposition-10, 6, 6);
	buffer.fillOval(210, yposition-2, 8, 8);
	buffer.fillOval(290, yposition-8, 8, 8);
	buffer.fillOval(250, yposition-10, 6, 6);
	buffer.fillOval(260, yposition, 8, 8);
	buffer.fillOval(275, yposition-5, 6, 6);
	buffer.fillOval(360, yposition-4, 8, 8);
	buffer.fillOval(370, yposition, 6, 6);
	buffer.fillOval(390, yposition-12, 8, 8);
	buffer.fillOval(310, yposition, 6, 6);
	buffer.fillOval(330, yposition-12, 8, 8);
	buffer.fillOval(340, yposition, 6, 6);
	buffer.fillOval(400, yposition-12, 8, 8);
	buffer.fillOval(420, yposition, 4, 4);
	buffer.fillOval(450, yposition -7, 8, 8);
	buffer.fillOval(460, yposition, 6, 6);
	buffer.fillOval(470, yposition - 12, 8, 8);
	buffer.fillOval(490, yposition, 6, 6);

	
	//draws the whole image 
	g.drawImage(image, 0,0, null);
	
	
	}

} //ends class 