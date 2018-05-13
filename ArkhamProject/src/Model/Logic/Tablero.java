package Model.Logic;

import java.util.ArrayList;
import java.util.Collections;

import Model.Locations.Armeria;
import Model.Locations.Biblioteca;
import Model.Locations.Calle;
import Model.Locations.Hospital;
import Model.Locations.Logia;
import Model.Pers.Cthonian;
import Model.Pers.Mentalista;
import Model.Pers.Protagonista;
import Model.Pers.Tree;
import Model.Pers.Wolf;

public class Tablero {

	private ArrayList<Casilla> arrayCasillas;
	private ArrayList<int[]> arrayPosiciones;
	private Casilla[][] board;
	private int movimientos;
	private int dificultad;
	private int cont;

	public Tablero() {
		dificultad = 12;
		movimientos = Dado.tirarDado(6);
		arrayCasillas = new ArrayList<Casilla>();
		for (int i = 0; i < 120; i++) {
			arrayCasillas.add(new Casilla());
		}
		for (int i = 0; i < 6; i++) {
			arrayCasillas.get(i).setEdificio(new Armeria());
		}
		for (int i = 6; i < 12; i++) {
			arrayCasillas.get(i).setEdificio(new Biblioteca());
		}
		for (int i = 12; i < 18; i++) {
			arrayCasillas.get(i).setEdificio(new Hospital());
		}
		for (int i = 18; i < 24; i++) {
			arrayCasillas.get(i).setEdificio(new Logia());
		}
		for (int i = 24; i < 120; i++) {
			arrayCasillas.get(i).setEdificio(new Calle());
		}

		// Desordenamos las edificaciones
		Collections.shuffle(arrayCasillas);

		// Añadimos enemigos tras el shuffle para que caigan en casillas aleatorias
		arrayCasillas.get(0).setPj(new Protagonista()); // Primero añadimos al protagonista
		for (int i = 1; i <= dificultad; i++) { // Y luego a los enemigos
			arrayCasillas.get(i).setPj(new Cthonian());
			i++;
			arrayCasillas.get(i).setPj(new Tree());
			i++;
			arrayCasillas.get(i).setPj(new Mentalista());
			i++;
			arrayCasillas.get(i).setPj(new Wolf());
			// La dificultad va por múltiplos de 4 enemigos (Sumamos 3 teniendo en cuenta el
			// incremento del bucle)
		}

		// Volvemos a desordenar para que no queden todos al principio
		Collections.shuffle(arrayCasillas);

		// Asignamos las edificaciones, ya desordenadas de forma aleatoria, al tablero
		board = new Casilla[8][15];
		cont = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new Casilla(arrayCasillas.get(cont));
				cont++;
			}
		}

		// Asignamos el Personaje Principal al tablero

	}

	// Método para buscar a un personaje en el tablero
	public int[] buscarPersonaje(String nombre) {
		int[] posicion = new int[2];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].getPj() != null) {
					if (board[i][j].getPj().getNombre().equals(nombre)) {
						posicion[0] = i;
						posicion[1] = j;
					}
				}
			}
		}

		return posicion;
	}

	public int[] mover(String dir) {
		int pos[] = new int[2];
		int origen[] = new int[2];

		// Buscamos la posición del protagonista
		pos = buscarPersonaje("personaje");
		origen[0] = pos[0];
		origen[1] = pos[1];

		// Movemos según dirección
		switch (dir) {
		case "up":
			if (pos[0] - 1 >= 0) {
				pos[0] = pos[0] - 1;
			}
			break;
		case "down":
			if (pos[0] + 1 < board.length) {
				pos[0] = pos[0] + 1;
			}
			break;
		case "left":
			if (pos[1] - 1 >= 0) {
				pos[1] = pos[1] - 1;
			}
			break;
		case "right":
			if (pos[1] + 1 < board[0].length) {
				pos[1] = pos[1] + 1;
			}
			break;
		}

		board[pos[0]][pos[1]].setPj(board[origen[0]][origen[1]].getPj());
		board[origen[0]][origen[1]].setPj(null);
		origen[0] = pos[0];
		origen[1] = pos[1];
		movimientos--;
		comprobarEvento(pos);
		return pos;
	}

	public void moverMonstruos() {

	}

	public void comprobarEvento(int[] pos) {
		if (board[pos[0]][pos[1]].getPj() != null) {

		}
	}

	// Método que calcula el movimiento disponible para el personaje
	public int calculaMovimiento() {
		int posicion[] = new int[2];

		posicion = buscarPersonaje("personaje");

		this.movimientos = (int) (Dado.tirarDado(6) * board[posicion[0]][posicion[1]].getPj().getVelocidad());
		System.out.println(movimientos);
		return movimientos;
	}

	// Método que actualiza las estadísticas del personaje principal
	public void actualizaStats() {

	}

	public void finalizarturno() {
		int[] pos = new int[2];
		pos = buscarPersonaje("personaje");
		comprobarEvento(pos);
	}

	public Casilla[][] getBoard() {
		return board;
	}

	public void setBoard(Casilla[][] board) {
		this.board = board;
	}

	public int getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}

}