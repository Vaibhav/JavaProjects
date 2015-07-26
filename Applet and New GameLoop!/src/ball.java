import java.awt.Color;
import java.awt.Graphics;


public class ball 
{

	private int x = 300, y, width = 40, height = 40, movementSpeed = 20;
	
	public void update(float interpolation, screen s)
	{
		movements(interpolation);
		wallDetections(s, interpolation);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
	}
	
	private void movements(float interpolation)
	{
		x += (movementSpeed / 2) * interpolation;
		y += movementSpeed * interpolation;
	}
	
	private void wallDetections(screen s, float interpolation)
	{
		if(x + width > s.getWidth() || x < 0 || y < 0 || (y + height) > s.getHeight())
		{
			movementSpeed *= -1;
		}
	}
	
}
