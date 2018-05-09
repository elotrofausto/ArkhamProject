package Controller;

import Model.Locations.Tablero;
import View.View;

public class Controller {
	
	Tablero model;
	View vista;
	
	public Controller() {
		model = new Tablero();
		vista = new View(model);
	}

}
