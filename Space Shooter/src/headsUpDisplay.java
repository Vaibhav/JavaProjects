import java.awt.Graphics;


public class headsUpDisplay 
{
	
	int x , y, height = 288, width = 600;
	
	public void update(screen s)
	{
		x = 300;
		y = s.getHeight() - height;
	}
	
	public void paint(Graphics g, screen s)
	{
		g.drawImage(s.HUD, x, y, s);
	}

}
