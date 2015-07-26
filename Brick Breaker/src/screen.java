import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;


public class screen extends Applet implements Runnable
{

	boolean gameIsRunning = true;
	
	//Double Buffer
	Image i;
	Graphics doubleG;
	
	// objects
	paddle p;
	controller c;
	
	public void init()
	{
		setSize(600,600);
		
		// initalization of objects
		p = new paddle();
		addKeyListener(p);
		
		c = new controller();
		c.init(this);
	}
	
	public void start()
	{
		Thread th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() 
	{
		while(gameIsRunning)
		{
			try
			{
				Thread.sleep(17);
				repaint();
			}catch(InterruptedException e){}
			p.update(this);
			c.update(this);
		}
	}
	
	public void paint(Graphics g)
	{
		c.paint(g);
		p.paint(g);
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
