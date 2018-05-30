package Controller;

import Model.Logic.PuntosModel;
import View.PointsView;

public class PointsController {

	FileController fc;
	PuntosModel modelo;
	PointsView vistaPuntos;
	
	public PointsController() {
		fc = new FileController("puntos.ark","puntos.ark");
		modelo = PuntosModel.getInstance();
		vistaPuntos = new PointsView(modelo);
	}
	
}
