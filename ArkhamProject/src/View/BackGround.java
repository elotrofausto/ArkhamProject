package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * Clase que actúa como un JPanel pero permite pintar un fondo mediante el Override del método paint
 * @author elotrofausto
 *
 */
public class BackGround extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image tapiz;

	public BackGround() {
		tapiz = new ImageIcon("img/tab_bg.png").getImage();
	}
	
	public BackGround(String ruta){
		tapiz = new ImageIcon(ruta).getImage();
	}
/**
 * Metodo para pintar el background del JPanel
 */
	@Override
	public void paint(Graphics g) {
		int ancho = this.getSize().width;
		int alto = this.getSize().height;
		if (this.tapiz != null) {
			g.drawImage(this.tapiz, 0, 0, ancho, alto, this);
		}
        this.setOpaque(false);
        super.paint(g);
	}
}
