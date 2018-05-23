package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import Model.Logic.Tablero;
import View.InitView;

public class InitViewController implements MouseListener, ItemListener {

	InitView vistaInicial;
	Tablero model;

	public InitViewController() {
		model = new Tablero();
		vistaInicial = new InitView(model);
		iniciarControladores();
	}

	public void iniciarControladores() {
		this.vistaInicial.getContinuar().addMouseListener(this);
		this.vistaInicial.getSalir().addMouseListener(this);
		this.vistaInicial.getNombre().addMouseListener(this);
		this.vistaInicial.getFacil().addItemListener(this);
		this.vistaInicial.getMedio().addItemListener(this);
		this.vistaInicial.getDificil().addItemListener(this);
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
			if (event == this.vistaInicial.getContinuar()) {
				this.vistaInicial.dispose();
				new Controller(this.model);
			} else if (event == this.vistaInicial.getSalir()) {
				this.vistaInicial.dispose();
				System.exit(0);
			}
		} else if (e.getSource() instanceof JTextField) {
			if (this.vistaInicial.getNombre().getText().equals("Introduce tu nombre...")) {
				this.vistaInicial.getNombre().setText("");
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox event = (JCheckBox) e.getSource();
		if (event == this.vistaInicial.getFacil()) {
			this.model.setDificultad(6);
			System.out.println("Fácil" + this.model.getDificultad());
			
		}
		else if (event == this.vistaInicial.getFacil()) {
			this.model.setDificultad(12);
			System.out.println("Med");

		}
		else if (event == this.vistaInicial.getDificil()) {
			this.model.setDificultad(24);
			System.out.println("Difícil");
		}
		
	}

}
