package Controller;

import Model.Logic.PuntosModel;
import View.PointsView;

/**
 * Clase Controlador de la pequeña Vista que muestra las últimas puntuaciones.
 * @author Alberto Fausto
 *
 */
public class PointsController {

	@SuppressWarnings("unused")
	private FileController fc;
	private PuntosModel modelo;
	@SuppressWarnings("unused")
	private PointsView vistaPuntos;
	
	public PointsController() {
		fc = new FileController("puntos.ark","puntos.ark");
		modelo = PuntosModel.getInstance();
		vistaPuntos = new PointsView(modelo);
	}
	
	
}
