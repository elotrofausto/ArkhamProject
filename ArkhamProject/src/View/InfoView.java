package View;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * Clase InfoView. Es la Clase en la que construimos la Vista que muestra instrucciones e información sobre el juego.
 * @author Alberto Fausto
 */
@SuppressWarnings("serial")
public class InfoView extends JDialog{

	private JLabel instrucciones;
	private JButton cerrar;
	
	public InfoView() {
		instrucciones = new JLabel(new ImageIcon("img/leyenda.png"));
		cerrar = new JButton("Cerrar");
		iniciaLeyenda();
	}
	
	public void iniciaLeyenda() {
		instrucciones.setLayout(new BorderLayout());
		instrucciones.add(cerrar, BorderLayout.SOUTH);
		this.add(instrucciones);
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.requestFocus();
		this.setVisible(true);
	}

	public JLabel getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(JLabel instrucciones) {
		this.instrucciones = instrucciones;
	}

	public JButton getCerrar() {
		return cerrar;
	}

	public void setCerrar(JButton cerrar) {
		this.cerrar = cerrar;
	}
	
	
}
