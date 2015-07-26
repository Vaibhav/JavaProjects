import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;


public class screen extends Applet implements Runnable
{
	private static final int updateRate = 30;
	private static final int renderRate = 60;
	private boolean isRunning = true;
	
	private int tps = 0;
	private int fps = 0;
	private int totalTicks = 0;
	private Thread th;
	
	float interpolation;
	
	ball b;
	
	//Double Buffer
	private Image i;
	private Graphics doubleG;
	
	public void init()
	{
		setSize(642, 642);
		
		b = new ball();
	}
	
	public synchronized void start()
	{
		isRunning = true;
		th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() 
	{
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime = lastUpdateTime;
		
		final int ns = 1000000000;
		final double nsPerUpdate = (double) ns / updateRate;
		final double nsPerRender = (double) ns / renderRate;
		final int maxUpdatesBeforeRender = 5;
		
		int lastSecond = (int) lastUpdateTime / ns;
		int tickCount = 0;
		int renderCount = 0;
		
		
		while(isRunning)
		{
			long currentTime = System.nanoTime();
			int tps = 0;
			while((currentTime - lastUpdateTime) > nsPerUpdate && tps < maxUpdatesBeforeRender)
			{
				update();
				tickCount++;
				totalTicks ++;
				tps++;
				lastUpdateTime += nsPerUpdate;
			}
			
			if(currentTime - lastUpdateTime > nsPerUpdate)
			{
				lastUpdateTime = currentTime - nsPerUpdate;
			}
			
			interpolation = Math.min(1.0f, (float)((currentTime - lastUpdateTime) / nsPerUpdate));
			repaint();
			renderCount++;
			lastRenderTime = currentTime;
			
			int currentSecond = (int) (lastUpdateTime / ns);
			if(currentSecond > lastSecond)
			{
				tps = tickCount;
				fps = renderCount;
				tickCount = 0;
				renderCount = 0;
				lastSecond = currentSecond;
				System.out.println(tps + " TPS " + fps + " FPS");
			}
			
			while(currentTime - lastRenderTime < nsPerRender && currentTime - lastUpdateTime < nsPerUpdate)
			{
				Thread.yield();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentTime = System.nanoTime();
			}
		}
	}
	
	public void update()
	{
		//System.out.println(interpolation);
		b.update(interpolation, this);
	}
	
	public void paint(Graphics g)
	{
		b.paint(g);	
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
