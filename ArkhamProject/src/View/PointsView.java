package View;

import Controller.FileController;
import Model.Logic.PuntosModel;

public class PointsView {

	FileController fc = new FileController("puntos.ark", "puntos.ark");
	String ultimaPunt;
	String panelPuntos;
	String relleno;

	public PointsView(PuntosModel modelo) {
		relleno = "";
		for (int i = 0; i < (30 - (modelo.getNombre().length() + modelo.getPuntos().toString().length())); i++) {
			relleno = relleno + "*";
		}
		ultimaPunt = modelo.getNombre() + relleno + modelo.getPuntos().toString();
		iniciarVistaPuntos();
	}

	public void iniciarVistaPuntos() {
		
	}

}
