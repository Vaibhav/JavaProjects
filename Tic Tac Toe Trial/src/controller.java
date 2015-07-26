import java.awt.Graphics;


public class controller 
{

	int numberOfTiles = 9;
	int numberOfRows = 3, numberOfColumns = 3;
	tile[] tiles = new tile[numberOfTiles];
	
	int[] playerSelectedTiles = new int[numberOfTiles];
	
	public synchronized void init(screen s)
	{
		for(int tileCounter = 0; tileCounter < numberOfTiles; tileCounter++)
		{
			tiles[tileCounter] = new tile();
			tiles[tileCounter].variableAssignments(s);
		}
		tilePlacement(s);
	}
	
	public void update()
	{
		for(int tileCounter = 0; tileCounter < numberOfTiles; tileCounter++)
		{
			tiles[tileCounter].update();
		}
		
		checkForPlayerSelectedTiles();
	}
	
	public void checkForPlayerSelectedTiles()
	{
		for(int tileCounter = 0; tileCounter < numberOfTiles; tileCounter++)
		{
			if(tiles[tileCounter].type == 1)
			{
				playerSelectedTiles[tileCounter] = 1;
			}
		}
	}
	
	private void tilePlacement(screen s)
	{
		for(int tileCounter = 0; tileCounter < numberOfTiles; tileCounter++)
		{
			
			int tileX = ((tileCounter)*tiles[tileCounter].width);
			int tileY = (tileCounter / numberOfColumns) * tiles[tileCounter].height;
			
			tileX += ((tileCounter / numberOfRows) * (tiles[tileCounter].width * -1) * numberOfRows);
					
			tiles[tileCounter].tilePlacement(tileX, tileY, tileCounter);
		}
	}
	
	public void paint(Graphics g)
	{
		for(int tileCounter = 0; tileCounter < numberOfTiles; tileCounter++)
		{
			tiles[tileCounter].paint(g);
		}
	}
	
}
