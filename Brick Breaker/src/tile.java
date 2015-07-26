import java.awt.Color;
import java.awt.Graphics;


public class tile 
{
	
	int x, y, width = 60, height = 35;
	int tileNumber;
	
	boolean tileIsActive = false;
	
	public void init(int givenTileNumber, screen s)
	{
		tileIsActive = true;
		tileNumber = givenTileNumber;
		tilePlacement(s);
	}
	
	public void update(screen s)
	{
		checkForBallHits(s.c.b);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}
	
	private void checkForBallHits(ball b)
	{
		if(b.x >= x && b.x <= x + width)
		{
			if(b.y + b.radius >= y && b.y <= y + height)
			{
				b.bounce();
				tileIsActive = false;
			}
		}
	}
	
	private void tilePlacement(screen s)
	{
		x = ((tileNumber)*width);
		y = (tileNumber / s.c.numberOfRows) * height;
		
		x += ((tileNumber / s.c.numberOfRows) * (width * -1) * s.c.numberOfRows);
	}
	
}
