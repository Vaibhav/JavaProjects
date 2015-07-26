import java.awt.Color;
import java.awt.Graphics;


public class player {
	
	int x, y = 200, radius = 20;
	int movementSpeed = 5, jumpCounter = 0;
	double gravity = 6, gravityDx = 1;
	
	boolean left = false, right = false;
	boolean fall = true, jump = true, jumpCounterTF = false;;
	
	public void update(screen s){
		if(left  == true){
			x -= movementSpeed;
		}
		if(right == true){
			x += movementSpeed;
		}
		
		if(jump == true){
			fall = false;
			jumpCounterTF = true;
			jump(s);
		}else{
			fall = true;
		}
		if(fall == true){
		//	y += gravity;
			for(int platformCounter = 0; platformCounter < s.visiblePlatforms; platformCounter++){
				s.platforms[platformCounter].y -= gravity;
			}
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.PINK);
		g.fillOval(x, y, radius, radius);
	}
	
	public void jump(screen s){
		//gravity += gravityDx;
		if(jumpCounterTF == true){
			jumpCounter++;
		}
		if(jumpCounter < 30){
		//	gravityDx *= 1.65;
			for(int platformCounter = 0; platformCounter < s.visiblePlatforms; platformCounter++){
				s.platforms[platformCounter].y += gravity;
			}
		}
		if(jumpCounter > 30 && jumpCounter < 60){
		//	gravityDx *= 0.65;
			fall = true;
			fall = true;
			jumpCounter = 0;
			jumpCounterTF = false;
			jump = false;
		}
	}

}
