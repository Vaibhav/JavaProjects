import java.awt.Color;
import java.awt.Graphics;


public class menus 
{
	String play = "Play?";
	boolean mouseInPlay = false;
	
	int playX = 600, playY = 300, textBorderX = 550, textBorderY = 250, buttonWidth = 200, buttonHeight = 100;
	
	public void paint(Graphics g)
	{
		if(mouseInPlay == false)
		{
			g.setColor(Color.BLACK);
			g.drawString(play, playX, playY);
			g.drawRect(textBorderX, textBorderY, buttonWidth, buttonHeight);
		}
		
		if(mouseInPlay == true)
		{
			g.setColor(Color.RED);
			g.drawString(play, playX, playY);
			g.setColor(Color.BLACK);
			g.drawRect(textBorderX, textBorderY, buttonWidth, buttonHeight);
		}
		
		
		
	}
	
}
