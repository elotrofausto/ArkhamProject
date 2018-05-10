package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;

import Model.Logic.Tablero;
import View.View;

public class Controller implements MouseListener, KeyListener{
	
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
	public void mousePressed(MouseEvent e) {
		JMenu event = (JMenu) e.getSource();
		if (event == this.vista.getSalir()){
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
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up 
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down 
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
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
