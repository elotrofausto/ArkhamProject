package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.Timer;

import View.CombatView;

public class CombatController implements MouseListener, KeyListener {
	private CombatView vistaCombate;
	private int contadorTimer;
	private Timer timer;
	private ArrayList<String> combate;

	public CombatController(ArrayList<String> combate) {
		
		this.combate = combate;
		vistaCombate = new CombatView(combate);
		iniciarControlCombate();
		contadorTimer = 1; // Se saltará la 1a pos del ArrayList
		timer = null;
	}

	public void iniciarControlCombate() {
		this.vistaCombate.getFight().addMouseListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton event = (JButton) e.getSource();
		if (event.getText() == "Combate!") {
			this.vistaCombate.getFight().setEnabled(false);
			combatTimer();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void combatTimer() {
		
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if (contadorTimer < vistaCombate.getCombate().size()) {
					if (Double.parseDouble(vistaCombate.getCombate().get(contadorTimer)) >= 0) {
						vistaCombate.getDamageEne().setText("-" + vistaCombate.getCombate().get(contadorTimer));
						vistaCombate.repaint();
						contadorTimer++;

					} else {
						vistaCombate.getDamagePj().setText(vistaCombate.getCombate().get(contadorTimer));
						vistaCombate.repaint();
						contadorTimer++;
					}
				}
				else {
					timer.stop();
					vistaCombate.dispose();
				}
			}
		};

		timer = new Timer(500, action);
		timer.setInitialDelay(0);
		timer.start();
		
	}

}
