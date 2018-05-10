package Model.Logic;

import java.util.ArrayList;
import java.util.Collections;

import Model.Locations.Armeria;
import Model.Locations.Biblioteca;
import Model.Locations.Calle;
import Model.Locations.Hospital;
import Model.Locations.Logia;
import Model.Pers.Cthonian;
import Model.Pers.Fire;
import Model.Pers.Mentalista;
import Model.Pers.Protagonista;
import Model.Pers.Tree;
import Model.Pers.Wolf;

public class Tablero {

	private ArrayList<Casilla> arrayCasillas;
	private Casilla[][] board;
	private Dado dice;
	private int dificultad;
	private int cont;
	
	public Tablero(){
		dice = new Dado();
		dificultad=12;
		arrayCasillas = new ArrayList<Casilla>();
		for (int i=0; i<120; i++){
			arrayCasillas.add(new Casilla());
		}
		for (int i=0; i<6; i++){
			arrayCasillas.get(i).setEdificio(new Armeria());
		}
		for (int i=6; i<12; i++){
			arrayCasillas.get(i).setEdificio(new Biblioteca());
		}
		for (int i=12; i<18; i++){
			arrayCasillas.get(i).setEdificio(new Hospital());
		}
		for (int i=18; i<24; i++){
			arrayCasillas.get(i).setEdificio(new Logia());
		}
		for (int i=24; i<120; i++){
			arrayCasillas.get(i).setEdificio(new Calle());
		}
		
		//Desordenamos las edificaciones
		Collections.shuffle(arrayCasillas);
		
		//Añadimos enemigos tras el shuffle para que caigan en casillas aleatorias
		arrayCasillas.get(0).setPj(new Protagonista()); //Primero añadimos al protagonista
		for (int i=1; i<=dificultad; i++){ //Y luego a los enemigos
			arrayCasillas.get(i).setPj(new Cthonian());i++;
			arrayCasillas.get(i).setPj(new Tree());i++;
			arrayCasillas.get(i).setPj(new Mentalista());i++;
			arrayCasillas.get(i).setPj(new Wolf());
			//La dificultad va por múltiplos de 4 enemigos (Sumamos 3 teniendo en cuenta el incremento del bucle)
		}
		
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
	
	private int[] mover(String dir){
		int pos[] = new int[2];
		int origen[] = new int[2];

		//Buscamos la posición del protagonista
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if(board[i][j].getPj().getNombre()=="personaje"){
					pos[0]=i; pos[1]=j;
					origen[0]=1; origen[1]=j;
				}
			}
		}
		
		//Movemos según dirección
		switch (dir) {
		case "up":
			if(pos[0]-1 >=0){
			pos[0]=pos[0]-1;
			}
			break;
		case "down":
			if(pos[0]+1 <= board.length){
				pos[0]=pos[0]+1;
				}
			break;
		case "left":
			if(pos[1]-1 <= 0){
				pos[1]=pos[1]-1;
				}
			break;
		case "right":
			if(pos[1]-1 <= 0){
				pos[1]=pos[1]-1;
				}
			break;
		}
		
		board[origen[0]][origen[1]].setPj(null);
		board[pos[0]][pos[1]].setPj(null);
		
		return pos;
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
