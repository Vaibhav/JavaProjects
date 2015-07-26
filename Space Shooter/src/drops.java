import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class drops 
{
	Random r = new Random();
	
	int x, y, width = 20, height = 20, movementSpeed = 3, type = r.nextInt(2), resetType = 0;
	
	boolean dropIsActive = false;
	
	public void dropIsActive(int dropX, int dropY, int dropResetType)
	{
		x = dropX;
		y = dropY;
		/*
		 * FKW: note on the drop types. 
		 * 0 = drops that fly by randomly
		 * 1 = drops that set by a asteroid breaking
		 */
		resetType = dropResetType;
		
		dropIsActive = true;
	}
	
	public void update(screen s)
	{
		if(dropIsActive)
		{
			x -= movementSpeed;
			
			if(s.p.x + s.p.width > x && s.p.x < x + height)
			{
				if(s.p.y + s.p.height > y && s.p.y < y + height)
				{
					switch(type)
					{
					case 0:
						s.p.amunition += 3;
					break;
					case 1:
						if(s.p.health < 3)
						{
							s.p.health += 1;
						}
					break;
					}
					dropReset();
				}
			}
			
			if(x < 0)
			{
				dropReset();
			}
		}
	}
	
	public void paint(Graphics g, screen s)
	{
		switch(type)
		{
		case 0:
			g.drawImage(s.feulCell, x, y, s);
		break;
		case 1:
			g.drawImage(s.hullCell, x, y, s);
		break;
		}
	}
	
	public void dropReset()
	{
		switch(resetType)
		{
		case 0:
			x = r.nextInt(4800) + 1200;
			y = r.nextInt(608);
			System.out.println("ResetType 0");
		break;
		case 1:
			type = r.nextInt(2);
			dropIsActive = false;
		break;
		}
	}

}
