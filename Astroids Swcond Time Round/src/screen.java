import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;


public class screen extends Applet implements Runnable
{

	boolean isRunning = true;
	
	//Double Buffer
	Image i;
	Graphics doubleG;
	
	//objects here
	player p;
	
	public synchronized void init()
	{
		setSize(1200, 800);
		
		p = new player();
		addMouseMotionListener(p);
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
			p.update(this);
		}
	}
	
	public void paint(Graphics g)
	{
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
