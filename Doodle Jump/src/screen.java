import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class screen extends Applet implements Runnable, KeyListener {

	int maxPlatforms = 100, visiblePlatforms = 15;
	
	player p;
	platform[] platforms = new platform[maxPlatforms];
	
	//buffer shit
	private Image i;
	private Graphics doubleG;
	
	public void init(){
		setSize(400, 800);
		addKeyListener(this);
		
		p = new player();
		for(int platformCounter = 0; platformCounter < maxPlatforms; platformCounter++){
			platforms[platformCounter] = new platform();
		}
		for(int platformCounter = 0; platformCounter < visiblePlatforms; platformCounter++){
			platforms[platformCounter].platformIsActive(this);
		}
		
		Thread th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		while(true){
			try{
				Thread.sleep(17);
				repaint();
			}catch(InterruptedException e){}
			p.update(this);
			for(int platformCounter = 0; platformCounter < visiblePlatforms; platformCounter++){
				platforms[platformCounter].update(this);
			}
		}
	}
	
	public void paint(Graphics g){
		p.paint(g);
		for(int platformCounter = 0; platformCounter < visiblePlatforms; platformCounter++){
			platforms[platformCounter].paint(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_A:
			p.left = true;
		break;
		case KeyEvent.VK_D:
			p.right = true;
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_A:
			p.left = false;
		break;
		case KeyEvent.VK_D:
			p.right = false;
		break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(Graphics g) {
	if (i == null){
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
