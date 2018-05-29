package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class EndGameView extends JFrame{

	private JLabel endgame;

	public EndGameView(int option){
		if (option == -1){
			endgame = new JLabel(new ImageIcon("img/gameover.png"));
		}
		else{
			endgame = new JLabel(new ImageIcon("img/goodending.gif"));
		}
		initEndGameView();
	}
	
	public void initEndGameView(){
		this.add(endgame);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
}
