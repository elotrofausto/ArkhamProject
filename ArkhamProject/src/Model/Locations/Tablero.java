package Model.Locations;

import java.util.ArrayList;

public class Tablero {

	private ArrayList<Casilla> arrayCasillas;
	private Casilla[][] board;
	private Dado dice;
	
	public Tablero(){
		dice = new Dado();
		arrayCasillas = new ArrayList<Casilla>();
		for (int i=0; i<130; i++){
			arrayCasillas.add(new Casilla());
		}
		
		for (int i=0; i<5; i++){
			arrayCasillas.get(i).setEdificio(new Armeria());;
		}
		for (int i=10; i<15; i++){
			arrayCasillas.get(i).setEdificio(new Biblioteca());;
		}
		for (int i=15; i<20; i++){
			arrayCasillas.get(i).setEdificio(new Hospital());;
		}
		for (int i=20; i<25; i++){
			arrayCasillas.get(i).setEdificio(new Logia());;
		}
		
		
		board = new Casilla[8][15];

	}
	
	
}
