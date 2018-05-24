package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JMenu;

import Model.Logic.InicioModel;
import Model.Logic.Tablero;
import View.View;

public class Controller implements MouseListener, KeyListener {

	InicioModel modeloInicio;
	Tablero model;
	View vista;

	public Controller(InicioModel modeloInicio) {
		this.modeloInicio = modeloInicio;
		model = new Tablero(modeloInicio);
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
		int[] pos = new int[3];
		if (ev.getSource() instanceof JMenu) {
			JMenu event = (JMenu) ev.getSource();
			if (event == this.vista.getSalir()) {
				System.exit(0);
			}
		} else {
			JButton event = (JButton) ev.getSource();
			if (event.getName() == "up" && model.getMovimientos() > 0) {
				pos = this.model.buscarPersonaje("personaje");
				pos = this.model.mover("up", pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			if (event.getName() == "down" && model.getMovimientos() > 0) {
				pos = this.model.buscarPersonaje("personaje");
				pos = this.model.mover("down", pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			if (event.getName() == "left" && model.getMovimientos() > 0) {
				pos = this.model.buscarPersonaje("personaje");
				pos = this.model.mover("left", pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			if (event.getName() == "right" && model.getMovimientos() > 0) {
				pos = this.model.buscarPersonaje("personaje");
				pos = this.model.mover("right", pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			if (event.getName() == "lanzarDado") {
				if (this.model.getMovimientos() == 0) {
					this.model.moverMonstruos();
					this.vista.getMovVar().setText(String.valueOf(this.model.calculaMovimiento()));
				}
			}
			if (event.getName() == "finTurno") {
				this.model.comprobarEvento(pos = this.model.buscarPersonaje("personaje"), new int[2]);
				if (this.model.getBoard()[pos[0]][pos[1]].getEdificio().isActivo()) {
					this.vista.actualizaStats(pos);
				}
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
		}
		pos = this.model.buscarPersonaje("personaje");
		this.vista.getEnerVar()
				.setText(String.format("%.2f", (float) (model.getBoard()[pos[0]][pos[1]].getPj().getEnergía())));
		this.vista.repintarTablero();
		this.vista.repaint();
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
				pos = this.model.buscarPersonaje("personaje");
				pos = this.model.mover("up", pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			break;
		case KeyEvent.VK_DOWN:
			if (model.getMovimientos() > 0) {
				pos = this.model.buscarPersonaje("personaje");
				pos = this.model.mover("down", pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			break;
		case KeyEvent.VK_LEFT:
			if (model.getMovimientos() > 0) {
				pos = this.model.buscarPersonaje("personaje");
				pos = this.model.mover("left", pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (model.getMovimientos() > 0) {
				pos = this.model.buscarPersonaje("personaje");
				pos = this.model.mover("right", pos);
				this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			}
			break;
		case KeyEvent.VK_ENTER:
			this.model.comprobarEvento(pos = this.model.buscarPersonaje("personaje"), new int[2]);

			if (this.model.getBoard()[pos[0]][pos[1]].getEdificio().isActivo()) {
				this.vista.actualizaStats(pos);
			}
			this.vista.getMovVar().setText(String.valueOf(this.model.getMovimientos()));
			break;
		case KeyEvent.VK_SPACE:
			if (this.model.getMovimientos() == 0) {
				this.model.moverMonstruos();
				this.vista.getMovVar().setText(String.valueOf(this.model.calculaMovimiento()));
			}
			break;
		}
		//Enviamos a la vista los resultados del combate para su representación
		if (!this.model.getCombate().isEmpty()) {
			System.out.println("Ha habido combate");
			new CombatController(model.getCombate());
			//this.vista.reFullScreen(); Lanzar al terminar
			//this.model.getCombate().removeAll(this.model.getCombate());
		}
		
		//Actualización de estadísticas y tablero
		pos = this.model.buscarPersonaje("personaje");
		this.vista.getEnerVar()
				.setText(String.format("%.2f", (float) (model.getBoard()[pos[0]][pos[1]].getPj().getEnergía())));
		this.vista.repintarTablero();
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