
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class BackGround extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image tapiz;

	public BackGround() {
		//this.setPreferredSize(new Dimension(975,650)); No mantiene la proporción del tablero
		tapiz = new ImageIcon("img/tab_bg.png").getImage();
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
