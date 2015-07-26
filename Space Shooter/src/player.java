import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class player 
{
	
	int x, y, width = 78, height = 18, movementSpeed = 5, health = 3, animationCounter = 0, amunition = 20;
	
	boolean movement = true, up = false, down = false, left = false, right = false;
	
	int maxLasers = 1000;
	laser[] lasers = new laser[maxLasers];
	
	public void init()
	{
		for(int laserCounter = 0; laserCounter < maxLasers; laserCounter++)
		{
			lasers[laserCounter] = new laser();
		}
	}
	
	public void update(screen s)
	{
		if(movement == true)
		{
			/*
			 * Movements
			 * FKW: the boolean values are triggered in the screen class(keyPressed and KeyReleased methods)
			 */
			if(left == true)
			{
				x -= movementSpeed;
			}
			if(right == true)
			{
				x += movementSpeed;
			}
			if(up == true)
			{
				y -= movementSpeed;
			}
			if(down == true)
			{
				y += movementSpeed;
			}
			/*
			 * Wall hit detections
			 * FKW: if the x/y is greater than the size of the canvas or less than 0(the minimum size of the canvas) it resets the values
			 */
			if(y + height > s.getHeight())
			{
				y = s.getHeight() - (1 + height);
			}
			if(y < 0)
			{
				y = 0 + 1;
			}
			if(x + width > s.getWidth())
			{
				x = s.getWidth() - (1 + width);
			}
			if(x < 0)
			{
				x = 0 + 1;
			}
			for(int laserCounter = 0; laserCounter < maxLasers; laserCounter++)
			{
				if(lasers[laserCounter].laserIsActive == true)
				{
					lasers[laserCounter].update(s);
				}
			}
			
			if(health == 0)
			{
				reset(s);
			}
		}
	}
	
	public void paint(Graphics g, screen s)
	{
		for(int laserCounter = 0; laserCounter < maxLasers; laserCounter++)
		{
			if(lasers[laserCounter].laserIsActive == true)
			{
				lasers[laserCounter].paint(g, s);
			}
		}
		
		if(up == false && down == false && left == false && right == false && health > 0)
		{
			shipAnimations(g, s);
		}
		if(right == true && up == false && down == false)
		{
			switch(health)
			{
			case 3:
				g.drawImage(s.spaceShip3, x, y, s);
			break;
			case 2:
				g.drawImage(s.damagedSpaceShip3, x, y, s);
			break;
			case 1:
				g.drawImage(s.veryDamagedSpaceShip3, x, y, s);
			break;
			}
		}
		if(left == true && up == false && down == false)
		{
			switch(health)
			{
			case 3:
				g.drawImage(s.spaceShip1, x, y, s);
			break;
			case 2:
				g.drawImage(s.damagedSpaceShip1, x, y, s);
			break;
			case 1:
				g.drawImage(s.veryDamagedSpaceShip1, x, y, s);
			break;
			}
		}
		if(down == true && health > 0)
		{
			g.drawImage(s.shipDown, x, y, s);
		}
		if(up == true && health > 0)
		{
			g.drawImage(s.shipUp, x, y, s);
		}
		
		/*
		 * FKW: Hud is here.
		 * FKW: Moved this due to the creation of the headsUpDisplay class.  
		 */
		/*g.setColor(Color.BLUE);
		Font HUD = new Font(null, Font.BOLD, 24);
		g.setFont(HUD);
		g.drawString("Amunition: " + amunition, 0, 600);*/
	}
	
	public void shipAnimations(Graphics g, screen s)
	{
		animationCounter++;
		if(animationCounter < 10)
		{
			switch(health)
			{
			case 3:
				g.drawImage(s.spaceShip1, x, y, s);
			break;
			case 2:
				g.drawImage(s.damagedSpaceShip1, x, y, s);
			break;
			case 1:
				g.drawImage(s.veryDamagedSpaceShip1, x, y, s);
			break;
			}
		}
		if(animationCounter <= 20 && animationCounter >= 10)
		{
			switch(health)
			{
			case 3:
				g.drawImage(s.spaceShip2, x, y, s);
			break;
			case 2:
				g.drawImage(s.damagedSpaceShip2, x, y, s);
			break;
			case 1:
				g.drawImage(s.veryDamagedSpaceShip2, x, y, s);
			break;
			}
		}
		if(animationCounter <= 30 && animationCounter >= 20)
		{
			switch(health)
			{
			case 3:
				g.drawImage(s.spaceShip3, x, y, s);
			break;
			case 2:
				g.drawImage(s.damagedSpaceShip3, x, y, s);
			break;
			case 1:
				g.drawImage(s.veryDamagedSpaceShip3, x, y, s);
			break;
			}
		}
		if(animationCounter == 30)
		{
			animationCounter = 0;
		}
	}
	
	public void laserCycle()
	{
		boolean laserIsFound = false;
		
		for(int laserCounter = 0; laserCounter < maxLasers; laserCounter++)
		{
			if(lasers[laserCounter].laserIsActive == false && laserIsFound == false)
			{
				lasers[laserCounter].laserIsActive(x, y);
				laserIsFound = true;
			}
		}
	}

	public void reset(screen s)
	{
		health = 3;
		x = 0;
		y = s.getHeight() / 2;
		s.enemyController.init();
		s.score = 0;
		amunition = 10;
	}
	
}
