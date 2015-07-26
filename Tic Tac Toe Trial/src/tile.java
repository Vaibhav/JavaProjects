import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class tile implements MouseListener, MouseMotionListener
{
	/*
	 * Note ontype numbers, 0 = null, 1 = O and 2 = X;
	 */
	
	int x, y, width, height, type = 0, tileNumber;
	int mouseX, mouseY;
	
	boolean hightlighted = false, mouseClicked = false, playerTurn = true;
	
	public void variableAssignments(screen s)
	{
		width = s.screenWidth/s.c.numberOfRows;
		height = s.screenHeight/s.c.numberOfColumns;
	}
	
	public void tilePlacement(int givenX, int givenY, int givenTileNumber)
	{
		x = givenX;
		y = givenY;
		
		tileNumber = givenTileNumber;
	}
	
	public void update()
	{
		/*
		 * Check to ensure that every tile's playerTurn value is false
		 */
		//System.out.println(playerTurn);
		//System.out.println(tileNumber);
		
		mouseDetections();
	}
	
	private int mouseDetections()
	{
		if(mouseX > x && mouseX < x + width)
		{
			if(mouseY > y && mouseY < y + height)
			{
				hightlighted = true;
			}else
			{
				hightlighted = false;
			}
		}else
		{
			hightlighted = false;
		}
		
		if(hightlighted == true && mouseClicked == true && playerTurn == true)
		{
			type = 1;
		}
		
		return type;
	}
	
	public synchronized void paint(Graphics g)
	{
		if(hightlighted == false)
		{
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
		}else
		{
			g.setColor(Color.GRAY);
			g.fillRect(x, y, width, height);
		}
		
		if(type == 1)
		{
			g.setColor(Color.BLACK);
			g.drawOval(x + (width/4), y + (height/4), width/2, height/2);
		}
		
		if(type == 2)
		{
			g.setColor(Color.BLACK);
			g.fillRect(x + (width/4), y + (height/4), width/4, height/4);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		mouseClicked = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		mouseClicked = false;
		playerTurn = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
}
