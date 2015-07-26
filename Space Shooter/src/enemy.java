import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class enemy 
{
	Random r = new Random();
	
	int x = 1200, y = r.nextInt(608), width = 30, height = 30, movementSpeed = 5, type = 0, dropChance = r.nextInt(6), dropCounter;
	
	boolean movement = true, collide = false;
	
	int maxDrops = 10;
	drops[] drops = new drops[maxDrops];
	
	public void init()
	{
		for(dropCounter = 0; dropCounter < maxDrops; dropCounter++)
		{
			drops[dropCounter] = new drops();
		}
	}
	
	public void update(screen s)
	{
		if(movement == true)
		{
			/*
			 * Type:
			 * FKW: there are multiple different types of asteroids, the types are as follows
			 * 0: plain movement left to right
			 */
			switch(type)
			{
			case 0:
				x -= movementSpeed;
			}
			/*
			 * Hit detection
			 * FKW:
			 */
			if(s.p.x + s.p.width > x && s.p.x < x + height)
			{
				if(s.p.y + s.p.height > y && s.p.y < y + height)
				{
					s.p.health -= 1;
					enemyReset(s);
				}
			}
			
			if(x + width < 0)
			{
				enemyReset(s);
			}
			
			for(dropCounter = 0; dropCounter < maxDrops; dropCounter++)
			{
				if(drops[dropCounter].dropIsActive == true)
				{
					drops[dropCounter].update(s);
				}
			}
			
		}
	}
	
	public void paint(Graphics g, screen s)
	{
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		for(dropCounter = 0; dropCounter < maxDrops; dropCounter++)
		{
			if(drops[dropCounter].dropIsActive == true)
			{
				drops[dropCounter].paint(g, s);
			}
		}
		
	}
	
	public void enemyReset(screen s)
	{
		x = s.getWidth() + width;
		y = r.nextInt(s.getHeight());
	}
	
	public void dropCycle()
	{
		boolean dropFound = false;
		
		for(dropCounter = 0; dropCounter < maxDrops; dropCounter++)
		{
			if(drops[dropCounter].dropIsActive == false && dropFound == false)
			{
				drops[dropCounter].dropIsActive(x - movementSpeed, y, 1);
				dropFound = true;
			}
		}
	}
	
}
