import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class player implements MouseMotionListener
{

	private int x = 600, y = 400, width = 30, height = 40;
	private int mouseX, mouseY;
	
	public void update(screen s)
	{
		
	}
	
	public void paint(Graphics g)
	{
		//rectangle
		//g.drawRect(x, y, width, height);
		
		//mouseTriangle
		//hypotnuse
		g.drawLine(x + (width / 2), y, mouseX, mouseY);
		//flat line
		g.drawLine(x + (width / 2), y, mouseX, y);
		//from mouse to space
		g.drawLine(mouseX, mouseY, mouseX, y);
		
		double hyp = Math.sqrt(((x + ((width/2) + mouseX) - x) * (x + ((width/2) + mouseX) - x)) + ((x + ((width/2) + mouseX) - x) * (x + ((width/2) + mouseX) - x)));
		
		System.out.println();
		//System.out.println("HYP: " + hyp);
		
		//System.out.println(Math.toRadians(Math.cos(hyp)));
		
		//player
		g.setColor(Color.RED);
		g.drawLine(x + (width / 2), y, x, y + height);
		g.drawLine(x + (width / 2), y, x + width, y + height);
		g.drawLine(x, y + height, x + width, y + height);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
		
		//System.out.println("THIS IS MOUSE X: " + e.getX());
		//System.out.println("THIS IS MOUSE Y: " + e.getY());
	}
	
}
