import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

public class Gun extends Thread implements DisplayObject{
	static int y=400;
	static int x=430;
	public Gun() {
		start();
	}
	public void run(){
		y=y;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.drawLine(x, y, x+120, y);
		g.drawLine(x+20, y+20, x+120, y+20);
		g.drawLine(x, y, x, y+50);
		g.drawLine(x+20, y+20, x+20, y+50);
		g.drawLine(x, y+50, x+20, y+50);
		
	}

}
