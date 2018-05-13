package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenu;

import Model.Logic.Tablero;
import View.View;

public class Controller implements MouseListener, KeyListener {

	Tablero model;
	View vista;

	public Controller() {
		model = new Tablero();
		vista = new View(model);

		initController();
	}

	private void initController() {
		// Mouse Listeners
		vista.getLeyenda().addMouseListener(this);
		vista.getSalir().addMouseListener(this);
		vista.getUp().addMouseListener(this);
		vista.getDown().addMouseListener(this);
		vista.getLeft().addMouseListener(this);
		vista.getRight().addMouseListener(this);
		vista.getLanzarDado().addMouseListener(this);
		// Key Listeners
		vista.getTab().addKeyListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
	public void mousePressed(MouseEvent ev) {
		if (ev.getSource() instanceof JMenu) {
			JMenu event = (JMenu) ev.getSource();
			if (event == this.vista.getSalir()) {
				System.exit(0);
			}
		} else {
			JButton event = (JButton) ev.getSource();
			System.out.println(event.getName());
			int[] pos = new int[2];
			if (event.getName() == "up" && model.getMovimientos() > 0) {
				pos = this.model.mover("up");
				this.vista.efectuarMovimiento("up", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				this.vista.repaint();
			}
			if (event.getName() == "down" && model.getMovimientos() > 0) {
				pos = this.model.mover("down");
				this.vista.efectuarMovimiento("down", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				this.vista.repaint();
			}
			if (event.getName() == "left" && model.getMovimientos() > 0) {
				pos = this.model.mover("left");
				this.vista.efectuarMovimiento("left", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				this.vista.repaint();
			}
			if (event.getName() == "right" && model.getMovimientos() > 0) {
				pos = this.model.mover("right");
				this.vista.efectuarMovimiento("right", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				this.vista.repaint();
			}
			if (event.getName() == "lanzarDado") {
				this.vista.getMovVar().setText(String.valueOf(this.model.calculaMovimiento()));
				this.vista.repaint();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int[] pos = new int[2];
		switch (keyCode) {
		case KeyEvent.VK_UP:
			System.out.println("Up");
			pos = this.model.mover("up");
			this.vista.efectuarMovimiento("up", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
			break;
		case KeyEvent.VK_DOWN:
			pos = this.model.mover("down");
			this.vista.efectuarMovimiento("down", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
			break;
		case KeyEvent.VK_LEFT:
			pos = this.model.mover("left");
			this.vista.efectuarMovimiento("left", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
			break;
		case KeyEvent.VK_RIGHT:
			pos = this.model.mover("right");
			this.vista.efectuarMovimiento("right", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}