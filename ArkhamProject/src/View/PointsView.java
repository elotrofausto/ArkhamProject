package View;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Controller.FileController;
import Model.Logic.PuntosModel;

@SuppressWarnings("serial")
public class PointsView extends JDialog {

	JLabel fondo;
	FileController fc;
	JTextArea areaTexto;
	String ultimaPunt;
	String panelPuntos;
	String relleno;
	byte[] buf;

	public PointsView(PuntosModel modelo) {
		fondo = new JLabel(new ImageIcon("img/fondoPuntos.gif"));
		fc = new FileController("puntos.ark", "puntos.ark");
		areaTexto = new JTextArea();
		panelPuntos = "";
		buf = null;
		relleno = "";
		for (int i = 0; i < (30 - (modelo.getNombre().length() + modelo.getPuntos().toString().length())); i++) {
			relleno = relleno + "*";
		}
		ultimaPunt = modelo.getNombre() + relleno + modelo.getPuntos().toString();

		iniciarVistaPuntos();
	}

	public void iniciarVistaPuntos() {

		buf = fc.read();
		
		if (buf[0] != 0) {
			
			// Formateamos por líneas de 30
			for (int i = 0; i < buf.length; i++) {
				for (int j = 0; j < 30; j++) {
					panelPuntos = panelPuntos + (char) buf[i];
					i++;
				}
				panelPuntos = panelPuntos + "\n";
				i--;
			}
			
			System.out.println(panelPuntos);

		}
		else {
			//Si el fichero está vacío escribimos directamente la última puntuación
			System.out.println(ultimaPunt);
			fc.write(ultimaPunt.getBytes());
			
			//Leemos ahora que ya hay algo
			buf = fc.read();
			
			// Formateamos por líneas de 30
			for (int i = 0; i < buf.length; i++) {
				for (int j = 0; j < 30; j++) {
					panelPuntos = panelPuntos + (char) buf[i];
					i++;
				}
				panelPuntos = panelPuntos + "\n";
				i--;
			}
			
			System.out.println(panelPuntos);

		}
		

		
		//Configuramos la vista
		areaTexto.setText(panelPuntos);
		areaTexto.setSize(400,800);
		this.add(areaTexto);
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
