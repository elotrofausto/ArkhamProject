package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import View.InfoView;

/**
 * Clase Controlador de la Vista que muestra instrucciones e información sobre
 * el juego.
 * 
 * @author Alberto Fausto
 *
 */
public class InfoController implements MouseListener {

	private InfoView leyenda;

	public InfoController() {
		leyenda = new InfoView();
		initController();
	}
	
	public void initController() {
		this.leyenda.getCerrar().addMouseListener(this);
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
		if (e.getSource() instanceof JButton) {
			JButton event = (JButton) e.getSource();
			if (event.getText() == "Cerrar") {
				this.leyenda.dispose();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}