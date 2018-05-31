package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase que actúa como un JLabel pero permite pintar un fondo mediante el
 * Override del método paint
 * @author elotrofausto
 *
 */
public class BgLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private Image tapiz;

	public BgLabel(String ruta) {
		tapiz = new ImageIcon(ruta).getImage();
	}

	/**
	 * Metodo para pintar el background del JLabel
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

	public Image getTapiz() {
		return tapiz;
	}

	public void setTapiz(Image tapiz) {
		this.tapiz = tapiz;
	}
	
	@Override
	public void update(Graphics g){
		paint(g);
	}

}
