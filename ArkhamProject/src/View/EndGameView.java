package View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase EndGameView. Es la Clase en la que construimos la Vista que representará el Fin del juego.
 * @author Alberto Fausto
 */
@SuppressWarnings("serial")
public class EndGameView extends JFrame {

	private JLabel endgame;
	private JPanel panelOpciones;
	private JButton score, exit;
	private GridBagConstraints c;

	public EndGameView(int option) {
		if (option == -1) {
			endgame = new JLabel(new ImageIcon("img/gameover.png"));
		} else {
			endgame = new JLabel(new ImageIcon("img/goodending0.gif"));
		}
		panelOpciones = new JPanel();
		score = new JButton("Puntuaciones");
		exit = new JButton("Salir");
		c = new GridBagConstraints();
		initEndGameView();
	}

	public void initEndGameView() {
		panelOpciones.setOpaque(false);
		endgame.setLayout(new BorderLayout());
		panelOpciones.setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		panelOpciones.add(score, c);
		c.gridx = 1;
		c.gridy = 0;
		panelOpciones.add(Box.createHorizontalStrut(50), c);
		c.gridx = 2;
		c.gridy = 0;
		panelOpciones.add(exit, c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		panelOpciones.add(Box.createVerticalStrut(100), c);
		endgame.add(panelOpciones, BorderLayout.SOUTH);
		this.add(endgame);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);
	}

	public JButton getNewGame() {
		return score;
	}

	public void setNewGame(JButton newGame) {
		this.score = newGame;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	
	
}
