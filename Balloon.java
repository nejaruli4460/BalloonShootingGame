

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;



public class Balloon extends Thread implements DisplayObject{
	
	int x,y,r,c,b;
	boolean flag=true;
	static int life=5;
	public Balloon(int x, int y, int r,int n,int b) {
		this.x = x;
		this.y = 110;
		this.r = r;
		this.c=n;
		this.b=b;
		start();
		
	}
void circleIntersect(int x1, int y1, int x2, int y2,
             int r1, int r2)
{
double d = Math.sqrt((x1 - x2) * (x1 - x2)
                   + (y1 - y2) * (y1 - y2));

if (d <= r1 - r2) {
	if(b==1) {
		life--;
	}
  MyGUI.score++;
  y=y+700;
}
else if (d <= r2 - r1) {
	if(b==1) {
		life--;
	}else {
		 MyGUI.score++;
	}
 
  y=y+700;
}
else if (d < r1 + r2) {
	if(b==1) {
		life--;
	}
	else {
		 MyGUI.score++;
	};
  y=y+700;
 
}
else if (d == r1 + r2) {
	if(b==1) {
		life--;
	}
	else {
		 MyGUI.score++;
	}
  y=y+700;

}
else {
 return;
}
}
	@Override
	public void run() {
		while(true) {
			
			Random rand = new Random();
			int n=rand.nextInt(20);
			y=y+n;
			if(y>=700&&flag==false) {
				life--;
			}
			if(y>=700) {
				y=110;
			}
			for(int i=0;i<DrawPanel.bullet.size();i++) {
				Bullet ob=(Bullet) DrawPanel.bullet.get(i);
				int x=ob.x;
				int y=ob.y;
				circleIntersect(this.x, this.y, ob.x, ob.y, this.r, ob.r);
				
				
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("YOUR SCORE \t"+MyGUI.score+"", 200, 100);
		g.drawString("LIFE \t"+Balloon.life+"", 400, 100);
		if(GameOver.recent.size()>0) {
			g.setColor(Color.GREEN);
			g.drawString("Max Score"+max(), 600, 100);
			g.setColor(Color.MAGENTA);
			g.drawString("Recent Score"+GameOver.recent.get(GameOver.recent.size()-1), 800, 100);
		}
		
		g.setColor(Color.black);
		g.drawLine(0, 120, 1500,120 );
		g.drawLine(799, 120, 799, 1500);
		
		g.setColor(Color.blue);
		g.drawString("V",x+18,y);
		
		
		if(c==1) {
			g.setColor(Color.red);
		}else if(c==2) {
			g.setColor(Color.cyan);
		}else if(c==3) {
			g.setColor(Color.green);
		}else if(c==4) {
			g.setColor(Color.pink);
		}else {
			g.setColor(Color.yellow);
		}
		if(b==1) {
			g.setColor(Color.BLACK);
		}
		g.fillOval(x, y, 40, 60);
	
		
	}
	private String max() {
		// TODO Auto-generated method stub
		int max=0;
		for(int i=0;i<GameOver.recent.size();i++) {
			if(GameOver.recent.get(i)>max) {
				max=GameOver.recent.get(i);
			}
		}
		return max+"";
	}

}
