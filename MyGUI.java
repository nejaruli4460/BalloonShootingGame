import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MyGUI extends JFrame implements ActionListener{
	
	DrawPanel drawPanel = new DrawPanel();
	static int score=0;
	static int prev=0;
	public MyGUI() {
		setTitle("My GUI");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Timer t = new Timer(1, this);
		t.start();
	}

	private void initComponents() {
		add(drawPanel);	
	}

	public static void main(String[] args) {
		MyGUI gui = new MyGUI();
		gui.setVisible(true);
		

	}

	@Override 
	public void actionPerformed(ActionEvent e) {
//		drawPanel.pushBalloon();
//		if(Balloon.life<=0) {
//			System.exit(0);
//		}
		
		if(prev!=(MyGUI.score/10)) {
			prev=MyGUI.score/10;
			Balloon.life=Balloon.life++;
			
		}
		if(Balloon.life<=0) {
			new GameOver();
		}
		drawPanel.repaint();
	}
	

}
