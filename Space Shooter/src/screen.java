import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;


public class screen extends Applet implements Runnable, KeyListener, MouseMotionListener, MouseListener
{
	
	int score = 0, gameType = 0;
	boolean menu = true;
	
	player p;
	enemyController enemyController;
	headsUpDisplay headsUpDisplay;
	menus menus;
	
	Image spaceShip1, spaceShip2, spaceShip3, shipDown, shipUp, damagedSpaceShip1, damagedSpaceShip2, damagedSpaceShip3, veryDamagedSpaceShip1, 
	veryDamagedSpaceShip2, veryDamagedSpaceShip3, laser, feulCell, hullCell, HUD;
	
	//buffer shit
	private Image i;
	private Graphics doubleG;
	
	URL url;
	
	public void init()
	{
		setSize(1200, 608);
		addKeyListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		
		p = new player();
		menus = new menus();
		p.init();
		
		enemyController = new enemyController();
		enemyController.init();
		
		headsUpDisplay = new headsUpDisplay();
		
		try
		{
			url = getDocumentBase();
		}catch(Exception e){}
		
		spaceShip1 = getImage(url, "undamagedShip1.png");
		spaceShip2 = getImage(url, "undamagedShip2.png");
		spaceShip3 = getImage(url, "undamagedShip3.png");
		damagedSpaceShip1 = getImage(url, "damagedShip1.png");
		damagedSpaceShip2 = getImage(url, "damagedShip2.png");
		damagedSpaceShip3 = getImage(url, "damagedShip3.png");
		veryDamagedSpaceShip1 = getImage(url, "verydamagedShip1.png");
		veryDamagedSpaceShip2 = getImage(url, "verydamagedShip2.png");
		veryDamagedSpaceShip3 = getImage(url, "verydamagedShip3.png");
		shipDown = getImage(url, "shipDown.png");
		shipUp = getImage(url, "shipUp.png");
		laser = getImage(url, "lazer.png");
		feulCell = getImage(url, "fuelCell.png");
		hullCell = getImage(url, "hullCell.png");
		HUD = getImage(url, "HUD.png");
		
		Thread th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			try
			{
				Thread.sleep(17);
				repaint();
			}catch(InterruptedException e){}
			score ++;
			
			if(menu == false)
			{
				p.update(this);
				enemyController.update(this);	
				headsUpDisplay.update(this);
			}
			
		}
	}
	
	public void paint(Graphics g)
	{
		if(menu == false)
		{
			enemyController.paint(g, this);
			p.paint(g, this);
			headsUpDisplay.paint(g, this);
		}
		
		if(menu == true)
		{
			menus.paint(g);
		}
	}
	
	public void update(Graphics g) 
	{
		if (i == null)
		{
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}
	
	doubleG.setColor(getBackground());
	doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
	
	doubleG.setColor(getForeground());
	paint(doubleG);
	
	g.drawImage(i, 0, 0, this);
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_A:
			p.left = true;
		break;
		case KeyEvent.VK_W:
			if(p.down == false)
			{
				p.up = true;
			}
		break;
		case KeyEvent.VK_S:
			if(p.up == false)
			{
				p.down = true;
			}
		break;
		case KeyEvent.VK_D:
			p.right = true;
		break;
		case KeyEvent.VK_SPACE:
			if(p.amunition > 0)
			{
				p.laserCycle();
				p.amunition -= 1;
			}
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_A:
			p.left = false;
		break;
		case KeyEvent.VK_W:
			p.up = false;
		break;
		case KeyEvent.VK_S:
			p.down = false;
		break;
		case KeyEvent.VK_D:
			p.right = false;
		break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(menus.mouseInPlay == true)
		{
			menu = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		if(e.getX() > menus.textBorderX && e.getX() < menus.textBorderX + menus.buttonWidth)
		{
			if(e.getY() > menus.textBorderY && e.getY() < menus.textBorderY + menus.buttonHeight)
			{
				menus.mouseInPlay = true;
			}else
			{
				menus.mouseInPlay = false;
			}
		}else
		{
			menus.mouseInPlay = false;
		}
	}
	
}
