package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.Timer;

import View.CombatView;

public class CombatController implements MouseListener{
	
	private CombatView vistaCombate;
	private int contadorTimer;
	private Timer timer;
	private ArrayList<String> combate;

	public CombatController(ArrayList<String> combate) {
		
		this.combate = combate;
		vistaCombate = new CombatView(combate);
		iniciarControlCombate();
		contadorTimer = 3;
		timer = null;
	}

	public void iniciarControlCombate() {
		this.vistaCombate.getFight().addMouseListener(this);
		this.vistaCombate.addMouseListener(this);
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
		if (event.getText() == "Combate!" && this.vistaCombate.getFight().isEnabled()) {
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
				if (contadorTimer < vistaCombate.getCombate().size()-1) {
					if (Double.parseDouble(vistaCombate.getCombate().get(contadorTimer)) >= 0) {
						vistaCombate.getDamagePj().setText("");
						vistaCombate.getDamageEne().setText("GOLPEAS! - " + vistaCombate.getCombate().get(contadorTimer) + " VIT");
						vistaCombate.getEneLife().setValue((int) vistaCombate.getEneLife().getValue() - (int) Double.parseDouble(vistaCombate.getCombate().get(contadorTimer)));
						vistaCombate.repaint();
						contadorTimer++;

					} else {
						vistaCombate.getDamageEne().setText("");
						vistaCombate.getDamagePj().setText("RECIBES! " + vistaCombate.getCombate().get(contadorTimer) + " VIT");
						vistaCombate.getPjLife().setValue((int) vistaCombate.getPjLife().getValue() + (int) Double.parseDouble(vistaCombate.getCombate().get(contadorTimer)));
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

		timer = new Timer(700, action);
		timer.setInitialDelay(0);
		timer.start();
		
	}

	public ArrayList<String> getCombate() {
		return combate;
	}

	public void setCombate(ArrayList<String> combate) {
		this.combate = combate;
	}

}
