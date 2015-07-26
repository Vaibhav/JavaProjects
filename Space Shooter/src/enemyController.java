import java.awt.Graphics;
import java.util.Random;

public class enemyController {
	Random r = new Random();
	
	int maxEnemies = 1000, activeEnemies = 20;
	enemy[] enemies = new enemy[maxEnemies];
	
	int maxDrops = 4;
	drops[] drops = new drops[maxDrops];
	
	public void init()
	{
		for(int dropCounter = 0; dropCounter < maxDrops; dropCounter++)
		{
			drops[dropCounter] = new drops();
			drops[dropCounter].dropIsActive(r.nextInt(2400) + 1200, r.nextInt(608), 0);
		}
		
		for(int enemyCounter = 0; enemyCounter < maxEnemies; enemyCounter++)
		{
			enemies[enemyCounter] = new enemy();
			enemies[enemyCounter].init();
		}
	}
	
	public void update(screen s)
	{
		/*
		 * Game types:
		 * FKW: gametype 0 = infinite mode.
		 * gametype 1 = stage one
		 */
		switch(s.gameType)
		{
		case 0:
			activeEnemies = s.score / 200;
			for(int dropCounter = 0; dropCounter < maxDrops; dropCounter++)
			{
				drops[dropCounter].update(s);
			}
		break;
		}
		for(int enemyCounter = 0; enemyCounter < activeEnemies; enemyCounter++)
		{
				enemies[enemyCounter].update(s);
				if(enemies[enemyCounter].collide == true)
				{
					init();
				}
		}
		
	}
	
	public void paint(Graphics g, screen s)
	{
		for(int dropCounter = 0; dropCounter < maxDrops; dropCounter++)
		{
			if(drops[dropCounter].dropIsActive)
			{
				drops[dropCounter].paint(g, s);
			}
		}
		
		for(int enemyCounter = 0; enemyCounter < activeEnemies; enemyCounter++)
		{
			enemies[enemyCounter].paint(g, s);
		}
	}
	
	

}
