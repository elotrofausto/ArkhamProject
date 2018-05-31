package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import View.EndGameView;

/**
 * Clase Controlador de la Vista de Fin de Juego. Gestiona la lógica de la vista y sus respectivos listeners.
 * @author Alberto Fausto
 *
 */
public class EndGameController implements MouseListener{
	
	private EndGameView vistaFinJuego;

	public EndGameController(int option){
		vistaFinJuego = new EndGameView(option);
		initEndGameController();
	}
	
	public void initEndGameController(){
		this.vistaFinJuego.getNewGame().addMouseListener(this);
		this.vistaFinJuego.getExit().addMouseListener(this);
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
		if (e.getSource() instanceof JButton){
		JButton event = (JButton) e.getSource();
		if (event.getText() == "Puntuaciones") {
			new PointsController();
		}
		else if (event.getText() == "Salir"){
			System.exit(0);
		}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
