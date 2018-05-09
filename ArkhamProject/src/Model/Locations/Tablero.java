package Model.Locations;

import java.util.ArrayList;
import java.util.Collections;

import Model.Pers.Cthonian;
import Model.Pers.Mentalista;
import Model.Pers.Protagonista;
import Model.Pers.Tree;
import Model.Pers.Wolf;

public class Tablero {

	private ArrayList<Casilla> arrayCasillas;
	private Casilla[][] board;
	private Dado dice;
	private int cont;
	
	public Tablero(){
		dice = new Dado();
		arrayCasillas = new ArrayList<Casilla>();
		for (int i=0; i<120; i++){
			arrayCasillas.add(new Casilla());
		}
		for (int i=0; i<5; i++){
			arrayCasillas.get(i).setEdificio(new Armeria());
		}
		for (int i=5; i<10; i++){
			arrayCasillas.get(i).setEdificio(new Biblioteca());
		}
		for (int i=10; i<15; i++){
			arrayCasillas.get(i).setEdificio(new Hospital());
		}
		for (int i=15; i<20; i++){
			arrayCasillas.get(i).setEdificio(new Logia());
		}
		for (int i=20; i<120; i++){
			arrayCasillas.get(i).setEdificio(new Calle());
		}
		
		//Desordenamos las edificaciones
		Collections.shuffle(arrayCasillas);
		
		//Añadimos enemigos tras el shuffle para que caigan en casillas aleatorias
		for (int i=0; i<5; i++){
			arrayCasillas.get(i).setPj(new Cthonian());
		}
		for (int i=5; i<10; i++){
			arrayCasillas.get(i).setPj(new Tree());
		}
		for (int i=10; i<15; i++){
			arrayCasillas.get(i).setPj(new Mentalista());
		}
		for (int i=15; i<20; i++){
			arrayCasillas.get(i).setPj(new Wolf());
		}
		arrayCasillas.get(20).setPj(new Protagonista());
		
		//Volvemos a desordenar para que no queden todos al principio
		Collections.shuffle(arrayCasillas);
		
		//Asignamos las edificaciones, ya desordenadas de forma aleatoria, al tablero
		board = new Casilla[8][15];
		cont=0;
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				board[i][j]=new Casilla(arrayCasillas.get(cont));
				cont++;
			}
		}
		
		//Asignamos el Personaje Principal al tablero

	}

	public Casilla[][] getBoard() {
		return board;
	}

	public void setBoard(Casilla[][] board) {
		this.board = board;
	}

	public Dado getDice() {
		return dice;
	}

	public void setDice(Dado dice) {
		this.dice = dice;
	}
	
	
	
}
