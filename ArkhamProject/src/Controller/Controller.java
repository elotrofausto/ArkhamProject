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

public class Controller implements MouseListener, KeyListener, ActionListener {

	Tablero model;
	View vista;

	public Controller() {
		model = new Tablero();
		vista = new View(model);

		initController();
	}

	private void initController() {
		vista.getLeyenda().addMouseListener(this);
		vista.getSalir().addMouseListener(this);
		vista.getUp().addActionListener(this);
		vista.getDown().addActionListener(this);
		vista.getLeft().addActionListener(this);
		vista.getRight().addActionListener(this);
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
		JMenu event = (JMenu) ev.getSource();
		if (event == this.vista.getSalir()) {
			System.exit(0);
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
			pos=this.model.mover("up");
			this.vista.efectuarMovimiento("up", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
			break;
		case KeyEvent.VK_DOWN:
			pos=this.model.mover("down");
			this.vista.efectuarMovimiento("down", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
			break;
		case KeyEvent.VK_LEFT:
			pos=this.model.mover("left");
			this.vista.efectuarMovimiento("left", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
			break;
		case KeyEvent.VK_RIGHT:
			pos=this.model.mover("right");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton event = (JButton) e.getSource();
		int[] pos = new int[2];
		if (event.getName()=="up") {
			pos=this.model.mover("up");
			this.vista.efectuarMovimiento("up", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
		}
		if (event.getName()=="down") {
			pos=this.model.mover("down");
			this.vista.efectuarMovimiento("down", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
		}
		if (event.getName()=="left") {
			pos=this.model.mover("left");
			this.vista.efectuarMovimiento("left", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
		}
		if (event.getName()=="right") {
			pos=this.model.mover("right");
			this.vista.efectuarMovimiento("right", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
		}
		
	}

}