package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controller.FileController;
import Model.Logic.PuntosModel;

/**
 * Clase PointsView. Es la Clase en la que construimos la Vista que representará la lista de Puntuaciones del juego.
 * @author Alberto Fausto
 */
@SuppressWarnings("serial")
public class PointsView extends JDialog {

	private BackGround fondo;
	private FileController fc;
	private JScrollPane scroll;
	private JTextArea areaTexto;
	private JLabel puntosTitle;
	private String ultimaPunt;
	private String panelPuntos;
	private String relleno;
	private int contador;
	private ArrayList<String> puntuaciones;

	public PointsView(PuntosModel modelo) {
		fondo = new BackGround("img/lovecraft.gif");
		fc = new FileController("puntos.ark", "puntos.ark");
		areaTexto = new JTextArea();
		scroll = new JScrollPane(areaTexto);
		puntosTitle = new JLabel(new ImageIcon("img/puntosTitle.png"));
		panelPuntos = "";
		puntuaciones = new ArrayList<String>();
		relleno = "";
		for (int i = 0; i < (30 - (modelo.getNombre().length() + modelo.getPuntos().toString().length())); i++) {
			relleno = relleno + "*";
		}
		ultimaPunt = modelo.getNombre() + relleno + modelo.getPuntos().toString();

		iniciarVistaPuntos();
	}

	public void iniciarVistaPuntos() {

		puntuaciones.add(ultimaPunt);
		fc.write(puntuaciones.get(0));
		puntuaciones = fc.read();

		// Formateamos por líneas de 30
		
		if (puntuaciones.size() > 10) contador = puntuaciones.size() - 10;
		else contador = 0;
		
		for (int i = contador; i < puntuaciones.size(); i++) {
			panelPuntos = panelPuntos + puntuaciones.get(i) + "\n";
		}

		// Configuramos la vista
		this.setLayout(new BorderLayout());
		areaTexto.setText(panelPuntos);
		areaTexto.setEnabled(false);
		areaTexto.setBackground(new Color(0,0,0,90));
		areaTexto.setFont(new Font("", 1, 20));
		areaTexto.setForeground(Color.RED);
		scroll.setOpaque(false);
		fondo.add(puntosTitle, BorderLayout.NORTH);
		fondo.add(scroll, BorderLayout.CENTER);
		this.setContentPane(fondo);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
