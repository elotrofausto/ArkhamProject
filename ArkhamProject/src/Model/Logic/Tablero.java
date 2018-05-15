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
	private Casilla[][] board;
	private Evento[] event;
	private int movimientos;
	private int dificultad;
	private int cont;

	public Tablero() {
		dificultad = 12;
		movimientos = 0;
		event = new Evento[2];
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

		// Añadimos enemigos tras el shuffle para que caigan en casillas
		// aleatorias
		arrayCasillas.get(0).setPj(new Protagonista()); // Primero añadimos al
														// protagonista
		for (int i = 1; i <= dificultad; i++) { // Y luego a los enemigos
			arrayCasillas.get(i).setPj(new Cthonian());
			i++;
			arrayCasillas.get(i).setPj(new Tree());
			i++;
			arrayCasillas.get(i).setPj(new Mentalista());
			i++;
			arrayCasillas.get(i).setPj(new Wolf());
			// La dificultad va por múltiplos de 4 enemigos (Sumamos 3 teniendo
			// en cuenta el
			// incremento del bucle)
		}

		// Volvemos a desordenar para que no queden todos al principio
		Collections.shuffle(arrayCasillas);

		// Asignamos las edificaciones, ya desordenadas de forma aleatoria, al
		// tablero
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
		int[] posicion = new int[3];

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
		posicion[2]=0;

		return posicion;
	}

	public int[] mover(String dir) {
		int pos[] = new int[3];
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

		if (pos[0] == origen[0] && pos[1] == origen[1]) {
			//Con la pos[2] controlamos si el personaje ha podido mover o no
			pos[2] = 0;
		} else{
			pos[2] = 1;
			board[pos[0]][pos[1]].setPj(board[origen[0]][origen[1]].getPj());
			board[origen[0]][origen[1]].setPj(null);
		}
		
		origen[0] = pos[0];
		origen[1] = pos[1];
		movimientos--;
		// comprobarEvento(pos);
		return pos;
	}

	public void moverMonstruos() {

	}

	// Comprueba si hay evento en la casilla, y dependiendo de si es de tipo
	// Localización o Combate lanza unas sentencias u otras.
	public void comprobarEvento(int[] pos) {

		float[] recompensa = new float[5];
		String nombreEdificio = "";
		if (board[pos[0]][pos[1]].getPj() != null && !(board[pos[0]][pos[1]].getPj() instanceof Protagonista)) {
			// Evento combate
			System.out.println("Combate");
		} else if (board[pos[0]][pos[1]].getPj() instanceof Protagonista) {
			// Evento de localización
			nombreEdificio = board[pos[0]][pos[1]].getEdificio().getImage();
			event[1] = Recompensa.getInstance();
			recompensa = event[1].recompensar(nombreEdificio);
			// Asignamos los valores nuevos a los atributos del personaje
			board[pos[0]][pos[1]].getPj().setFuerza(board[pos[0]][pos[1]].getPj().getFuerza() * recompensa[0]);
			board[pos[0]][pos[1]].getPj().setVelocidad(board[pos[0]][pos[1]].getPj().getVelocidad() * recompensa[1]);
			board[pos[0]][pos[1]].getPj().setOro(board[pos[0]][pos[1]].getPj().getOro() + recompensa[2]);
			board[pos[0]][pos[1]].getPj().setEnergía(board[pos[0]][pos[1]].getPj().getEnergía() * recompensa[3]);
			board[pos[0]][pos[1]].getPj().setSabiduría(board[pos[0]][pos[1]].getPj().getSabiduría() * recompensa[4]);
			// board[pos[0]][pos[1]].setEdificio(new Fire());
			movimientos = 0;
		}

	}

	// Método que calcula el movimiento disponible para el personaje
	public int calculaMovimiento() {
		int posicion[] = new int[3];

		posicion = buscarPersonaje("personaje");
		
		this.movimientos = (int) (Dado.tirarDado(6) * board[posicion[0]][posicion[1]].getPj().getVelocidad());
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