package Model;

import java.util.ArrayList;

public class Tablero {

	private ArrayList<Casilla> array;
	private Casilla[][] board;
	private Dado dice;
	
	public Tablero(){
		dice = new Dado();
		array = new ArrayList<Casilla>();
		for (int i=0; i<130; i++){
			array.add(new Casilla());
		}
		
		
		board = new Casilla[8][15];

	}
	
	
}
