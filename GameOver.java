import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameOver implements ActionListener{
	static ArrayList<Integer> recent=new ArrayList<Integer>();
	public GameOver(){
		int b=JOptionPane.showConfirmDialog(null, "GameOver Press Yes restart Again If You Click ok then Save If You Click Cancel then without save if you click no then game will exited ");
		if(b==0) {
			recent.add(MyGUI.score);
			Balloon.life=5;
			MyGUI.score=0;
		}else if(b==1) {
			System.exit(0);
		}else {
			Balloon.life=5;
			MyGUI.score=0;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
