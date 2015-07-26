import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class ball
{

	int x = 100, y = 500, radius = 20;
	int xMovementSpeed = 4, yMovementSpeed = 4;
	
	public void init()
	{
		
	}
	
	public void update(screen s)
	{
		wallCollision(s);
		paddleCollisions(s);
		movements();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval(x, y, radius, radius);
	}
	
	private void movements()
	{
		x += xMovementSpeed;
		y += yMovementSpeed;
	}
	
	public void bounce()
	{
		Random r = new Random();
		
		yMovementSpeed *= -1;
		if(r.nextInt(2) == 1)
		{
			xMovementSpeed *= -1;
		}
	}
	
	private void paddleCollisions(screen s)
	{
		Random r = new Random();
		if(x + radius >= s.p.x && x <= s.p.x + s.p.width)
		{
			if(y + radius >= s.p.y && y <= s.p.height + s.p.y)
			{
				yMovementSpeed *= -1;
				if(r.nextInt(2) == 1)
				{
					xMovementSpeed *= -1;
				}
			}
		}
	}
	
	private void wallCollision(screen s)
	{
		if(x >= s.getWidth() - radius || x <= 0)
		{
			xMovementSpeed *= -1;
		}
		if(y >= s.getHeight() - radius || y <= 0)
		{
			yMovementSpeed *= -1;
		}
	}
	
}
