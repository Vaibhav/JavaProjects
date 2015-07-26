import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;


public class screen extends Applet implements Runnable 
{

	//buffer shit
	private Image i;
	private Graphics doubleG;
	
	public void init()
	{
		setSize(1200, 600);
		
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
			
		}
	}
	
	public void paint(Graphics g)
	{
		
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

}
