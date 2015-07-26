import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class platform {
	
	int x, y, width = 100, height = 5;
	
	boolean platformIsActive = false;
	
	public void platformIsActive(screen s){
		Random r = new Random();
		
		x = r.nextInt(s.getWidth());
		y = r.nextInt(s.getHeight());
		platformIsActive = true;
	}
	
	public void update(screen s){
		if(s.p.x  > x && s.p.x < x + width){
			if(s.p.y + s.p.radius < y && s.p.y + s.p.radius > y - height && s.p.jump == false){
				s.p.jumpCounter = 0;
				s.p.jump = true;
			}
		}
		if(y > s.getHeight()){
			platformReset(s);
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public void platformReset(screen s){
		Random r = new Random();
		x = r.nextInt(s.getWidth());
		y = 0 - height;
	}

}
