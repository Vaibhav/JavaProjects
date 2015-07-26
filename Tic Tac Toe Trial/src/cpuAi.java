
public class cpuAi 
{

	public void update(controller c)
	{
		checkForTurn(c);
	}
	
	public void checkForTurn(controller c)
	{
		for(int tileCounter = 0; tileCounter < c.numberOfTiles; tileCounter++)
		{
			if(c.tiles[tileCounter].playerTurn == false)
			{
				makeMove();
			}
		}
	}
	
	public void makeMove()
	{
		
	}
	
}
