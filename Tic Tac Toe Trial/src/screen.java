import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;


public class screen extends Applet implements Runnable
{

	int screenWidth = 800, screenHeight = 800;
	boolean isRunning = true;
	
	//Double Buffer
	Image i;
	Graphics doubleG;
	
	//objects here
	controller c;
	
	public synchronized void init()
	{
		setSize(screenWidth, screenHeight);
		
		c = new controller();
		c.init(this);
		addMouseInterfaces();
	}
	
	public synchronized void start()
	{
		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void run()
	{
		while(isRunning)
		{
			try
			{
				Thread.sleep(17);
				repaint();
			}catch(InterruptedException e){}
			c.update();
		}
	}
	
	public void paint(Graphics g)
	{
		c.paint(g);
	}
	
	public void addMouseInterfaces()
	{
		for(int tileCounter = 0; tileCounter < c.numberOfTiles; tileCounter++)
		{
			addMouseListener(c.tiles[tileCounter]);
			addMouseMotionListener(c.tiles[tileCounter]);
		}
	}
	
	public void update(Graphics g){
		if(i == null){
			i = createImage(this.getWidth(), this.getHeight());
			doubleG = i.getGraphics();
		}
		
		doubleG.setColor(getBackground());
		doubleG.fillRect(0,0,this.getWidth(), this.getHeight());
		
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i, 0,  0,  this);
	}
	
}
