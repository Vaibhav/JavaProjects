import java.awt.Graphics;


public class controller 
{
	
	int numberOfRows = 10, numberOfColumns = 6;
	int numberOfTiles = 60;
	
	ball b;
	tile[] tiles = new tile[numberOfTiles];
	
	public void init(screen s)
	{
		b = new ball();
		
		for(int tileCounter = 0; tileCounter < numberOfTiles; tileCounter++)
		{
			tiles[tileCounter] = new tile();
			tiles[tileCounter].init(tileCounter, s);
		}
	}
	
	public void update(screen s)
	{
		b.update(s);
		
		for(int tileCounter = 0; tileCounter < numberOfTiles; tileCounter++)
		{
			if(tiles[tileCounter].tileIsActive == true)
			{
				tiles[tileCounter].update(s);
			}
		}
	}
	
	public void paint(Graphics g)
	{
		b.paint(g);
		
		for(int tileCounter = 0; tileCounter < numberOfTiles; tileCounter++)
		{
			if(tiles[tileCounter].tileIsActive == true)
			{
				tiles[tileCounter].paint(g);	
			}
		}
	}
	
}
