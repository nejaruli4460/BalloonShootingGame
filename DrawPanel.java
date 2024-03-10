
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.*;
public class DrawPanel extends JPanel implements MouseListener,KeyListener{
	
	static List<DisplayObject> displayBuffer = new ArrayList<DisplayObject>();
	static List<DisplayObject> bullet = new ArrayList<DisplayObject>();
	static List<DisplayObject> gun = new ArrayList<DisplayObject>();
	int y=400;
	public DrawPanel() {
		setBackground(Color.WHITE);
			pushBalloon();
			addMouseListener(this);
			addKeyListener(this);
			setFocusable(true);
			displayBuffer.add(new Gun());
			
	}
	
	void pushBalloon() {
		Random rand = new Random();
		int n=6;
		
		
		int max=1300,min=800;
		int x=rand.nextInt(max - min + 1)+min;
		while(n!=0) {
			Random r=new Random();
			int c=r.nextInt(5);
			int b=r.nextInt(3);
			displayBuffer.add(new Balloon(x, 100, 20,c,b));
			
			n--;
			x=rand.nextInt(max - min + 1)+min;;
			
		}
	}
	void pushBullet() {
		bullet.add(new Bullet( 20));
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g)  {
		super.paintComponent(g);
		for(DisplayObject ob : displayBuffer) {
			ob.draw(g);
		}
		for(DisplayObject ob : bullet) {
			try {
				ob.draw(g);
			}catch(NullPointerException e){
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pushBullet();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_SPACE){
			pushBullet();
			}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(Gun.y>600) {
				Gun.y=Gun.y-10;
				Bullet.y=Bullet.y-10;
			}
			Gun.y=Gun.y+10;
			Bullet.y=Bullet.y+10;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(Gun.y<250) {
				Gun.y=Gun.y+10;
				Bullet.y=Bullet.y+10;
			}
			Gun.y=Gun.y-10;
			Bullet.y=Bullet.y-10;
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	


}
