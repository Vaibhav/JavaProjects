import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class paddle implements KeyListener
{

	int x, y = 550, width = 100, height = 10;
	int movementSpeed = 5;
	
	boolean left = false, right = false;
	
	public void update(screen s)
	{
		wallCollision(s);
		movements();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	private void wallCollision(screen s)
	{
		if(x + width >= s.getWidth())
		{
			x = s.getWidth() - width;
		}
		if(x <= 0)
		{
			x = 0;
		}
	}
	
	private void movements()
	{
		if(right == true)
		{
			x += movementSpeed;
		}
		if(left == true)
		{
			x -= movementSpeed;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_A:
			left = true;
		break;
		case KeyEvent.VK_D:
			right = true;
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_A:
			left = false;
		break; 
		case KeyEvent.VK_D:
			right = false;
		break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
