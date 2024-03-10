import java.awt.Graphics;
import java.util.Random;

public class Bullet extends Thread implements DisplayObject{
	
	
	int r;
	static int y=405;
	static int z=550;
	int x=z;
	static boolean flag=true;
	
	public Bullet( int r) {
		this.x =Bullet.z;
		this.y = Bullet.y;
		this.r = r;
		start();
	}
	
	@Override
	public void run() {
		while(true) {
			x++;
			if(DrawPanel.bullet.size()>=1000) {
				for(int i=0;i<DrawPanel.bullet.size();i++) {
					DrawPanel.bullet.remove(i);
				}
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		
		g.drawOval(x, y, 20, 5);
	}

}
