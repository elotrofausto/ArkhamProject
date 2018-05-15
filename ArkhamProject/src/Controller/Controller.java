package Controller;

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
		vista.getFinTurno().addMouseListener(this);
		// Key Listeners
		vista.addKeyListener(this);
		vista.setFocusable(true);

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
			int[] pos = new int[3];
			if (event.getName() == "up" && model.getMovimientos() > 0) {
				pos = this.model.mover("up");
				if (pos[2] != 0) {
					this.vista.efectuarMovimiento("up", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				}
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				this.vista.repaint();
			}
			if (event.getName() == "down" && model.getMovimientos() > 0) {
				pos = this.model.mover("down");
				if (pos[2] != 0) {
					this.vista.efectuarMovimiento("down", pos,
							this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				}
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				this.vista.repaint();
			}
			if (event.getName() == "left" && model.getMovimientos() > 0) {
				pos = this.model.mover("left");
				if (pos[2] != 0) {
					this.vista.efectuarMovimiento("left", pos,
							this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				}
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				this.vista.repaint();
			}
			if (event.getName() == "right" && model.getMovimientos() > 0) {
				pos = this.model.mover("right");
				if (pos[2] != 0) {
					this.vista.efectuarMovimiento("right", pos,
							this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				}
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				this.vista.repaint();
			}
			if (event.getName() == "lanzarDado") {
				if (this.model.getMovimientos() == 0) {
					this.vista.getMovVar().setText(String.valueOf(this.model.calculaMovimiento()));
					this.vista.repaint();
				}
			}
			if (event.getName() == "finTurno") {
				this.model.comprobarEvento(pos = this.model.buscarPersonaje("personaje"));
				this.vista.actualizaStats(pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
				vista.repaint();
			}
		}
		vista.requestFocus();
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
			if (model.getMovimientos() > 0) {
				pos = this.model.mover("up");
				if (pos[2] != 0) {
					this.vista.efectuarMovimiento("up", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				}
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			break;
		case KeyEvent.VK_DOWN:
			if (model.getMovimientos() > 0) {
				pos = this.model.mover("down");
				this.vista.efectuarMovimiento("down", pos, this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			break;
		case KeyEvent.VK_LEFT:
			if (model.getMovimientos() > 0) {
				pos = this.model.mover("left");
				if (pos[2] != 0) {
					this.vista.efectuarMovimiento("left", pos,
							this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				}
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (model.getMovimientos() > 0) {
				pos = this.model.mover("right");
				if (pos[2] != 0) {
					this.vista.efectuarMovimiento("right", pos,
							this.model.getBoard()[pos[0]][pos[1]].getPj().getNombre());
				}
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			break;
		case KeyEvent.VK_ENTER:
			this.model.comprobarEvento(this.model.buscarPersonaje("personaje"));
			this.vista.actualizaStats(this.model.buscarPersonaje("personaje"));
			this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			break;
		case KeyEvent.VK_SPACE:
			if (this.model.getMovimientos() == 0) {
				this.vista.getMovVar().setText(String.valueOf(this.model.calculaMovimiento()));
			}
			break;
		}
		this.vista.repaint();
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