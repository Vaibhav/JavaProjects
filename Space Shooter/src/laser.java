import java.awt.Graphics;


public class laser 
{
	
	int x, y, width = 24, height = 6, movementSpeed = 14;
	boolean laserIsActive = false;
	
	public void laserIsActive(int laserX, int laserY)
	{
		x = laserX;
		y = laserY + 10;
		
		laserIsActive = true;
	}
	
	public void update(screen s)
	{
		if(laserIsActive == true)
		{
			x += movementSpeed;
			
			for(int enemyCounter = 0; enemyCounter <= s.enemyController.activeEnemies; enemyCounter++)
			{
				if(x > s.enemyController.enemies[enemyCounter].x && x < s.enemyController.enemies[enemyCounter].x + s.enemyController.enemies[enemyCounter].width)
				{
					if(y + height > s.enemyController.enemies[enemyCounter].y && y < s.enemyController.enemies[enemyCounter].y + s.enemyController.enemies[enemyCounter].height)
					{
						if(s.enemyController.enemies[enemyCounter].dropChance == 2)
						{
							s.enemyController.enemies[enemyCounter].dropCycle();
						}
						s.enemyController.enemies[enemyCounter].enemyReset(s);
						laserIsActive = false;
					}
				}
			}
			
			if(x > s.getWidth())
			{
				laserReset(s);
			}
			
		}
	}
	
	public void paint(Graphics g, screen s)
	{
		g.drawImage(s.laser, x, y, s);
	}
	
	public void laserReset(screen s)
	{
		laserIsActive = false;
	}
	
}
