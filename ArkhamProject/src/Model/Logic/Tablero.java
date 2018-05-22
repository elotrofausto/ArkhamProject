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
		posicion[2] = 0;

		return posicion;
	}

	// Método para mover los personajes. Recibe la dirección y ubicación como
	// parámtro
	public int[] mover(String dir, int[] pos) {
		int origen[] = new int[2];
		int movs = 0; // Variable para almacenar la cantidad de movimientos

		// Asignamos a la variable movs las casillas que movera el personaje de
		// golpe dependiendo del tipo
		if (board[pos[0]][pos[1]].getPj() instanceof Protagonista) {
			movs = 1;
		}
		if (board[pos[0]][pos[1]].getPj() instanceof Cthonian) {
			movs = 1;
		}
		if (board[pos[0]][pos[1]].getPj() instanceof Mentalista) {
			movs = 1;
		}
		if (board[pos[0]][pos[1]].getPj() instanceof Tree) {
			movs = 1;
		}
		if (board[pos[0]][pos[1]].getPj() instanceof Wolf) {
			movs = 1;
		}

		// Guardamos la posición de origen para siguientes comprobaciones
		origen[0] = pos[0];
		origen[1] = pos[1];

		// Movemos según dirección
		switch (dir) {
		case "up":
			if ((pos[0] - movs >= 0) && (board[pos[0] - movs][pos[1]].getPj() == null)
					|| (pos[0] - movs >= 0) && (board[pos[0] - movs][pos[1]].getPj() instanceof Protagonista)
					|| (pos[0] - movs >= 0) && (board[pos[0] - movs][pos[1]].getPj() != null)
							&& (board[pos[0]][pos[1]].getPj() instanceof Protagonista)) {
				pos[0] = pos[0] - movs;
			}
			break;
		case "down":
			if (pos[0] + movs < board.length && (board[pos[0] + movs][pos[1]].getPj() == null)
					|| (pos[0] + movs < board.length) && (board[pos[0] + movs][pos[1]].getPj() instanceof Protagonista)
					|| (pos[0] + movs < board.length) && (board[pos[0] + movs][pos[1]].getPj() != null)
							&& (board[pos[0]][pos[1]].getPj() instanceof Protagonista)) {
				pos[0] = pos[0] + movs;
			}
			break;
		case "left":
			if (pos[1] - movs >= 0 && (board[pos[0]][pos[1] - movs].getPj() == null)
				|| (pos[1] - movs >= 0) && (board[pos[0]][pos[1] - movs].getPj() instanceof Protagonista)
				|| (pos[1] - movs >= 0) && (board[pos[0]][pos[1] - movs].getPj() != null)
						&& (board[pos[0]][pos[1]].getPj() instanceof Protagonista)){
				pos[1] = pos[1] - movs;
			}
			break;
		case "right":
			if (pos[1] + movs < board[0].length && (board[pos[0]][pos[1] + movs].getPj() == null)
					|| (pos[1] + movs < board[0].length) && (board[pos[0]][pos[1] + movs].getPj() instanceof Protagonista)
					|| (pos[1] + movs < board[0].length) && (board[pos[0]][pos[1] + movs].getPj() != null)
							&& (board[pos[0]][pos[1]].getPj() instanceof Protagonista)) {
				pos[1] = pos[1] + movs;
			}
			break;
		}

		if (pos[0] == origen[0] && pos[1] == origen[1]) {
			// Con la pos[2] controlamos si el personaje ha podido mover o no
			pos[2] = 0;
		} else {
			pos[2] = 1;
			comprobarEvento(pos, origen);
			board[pos[0]][pos[1]].setPj(board[origen[0]][origen[1]].getPj());
			board[origen[0]][origen[1]].setPj(null);
		}

		if (movimientos >= 1)
			movimientos--;
		return pos;
	}

	public void moverMonstruos() {
		ArrayList<int[]> posiciones = new ArrayList<int[]>();
		String[] direcciones = { "up", "down", "right", "left" };
		int random;

		int k = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].getPj() != null) {
					if (!board[i][j].getPj().getNombre().equals("personaje")) {
						posiciones.add(new int[3]);
						posiciones.get(k)[0] = i;
						posiciones.get(k)[1] = j;
						posiciones.get(k)[2] = 0;
						k++;
					}
				}
			}
		}

		for (int i = 0; i < posiciones.size(); i++) {
			random = Dado.getInstance().tirarDado(4);
			mover(direcciones[random - 1], posiciones.get(i));
		}

	}

	// Comprueba si hay evento en la casilla, y dependiendo de si es de tipo
	// Localización o Combate lanza unas sentencias u otras.
	public void comprobarEvento(int[] pos, int[] origen) {

		float[] recompensa = new float[5];
		String nombreEdificio = "";
		if ((board[pos[0]][pos[1]].getPj() != null) && (board[origen[0]][origen[1]].getPj() != null)
				&& ((board[pos[0]][pos[1]].getPj() instanceof Protagonista)
						|| (board[origen[0]][origen[1]].getPj() instanceof Protagonista))) {
			// Evento combate
			if (board[pos[0]][pos[1]].getPj() instanceof Protagonista) {
				combate(origen, pos);
			} else {
				combate(pos, origen);
			}
			movimientos = 0;
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

	public void combate(int[] pos, int[] origen) {
		ArrayList<Integer> arrayDados = new ArrayList<Integer>();
		double damage, defense, result;

		System.out.println("Combate");
		System.out.println("Vida pers inicial " + board[origen[0]][origen[1]].getPj().getEnergía());

		while (board[pos[0]][pos[1]].getPj().getEnergía() > 0 && board[origen[0]][origen[1]].getPj().getEnergía() > 0) {

			// Calculamos el ataque del personaje
			arrayDados = Dado.getInstance().tirarDados(6, 6);
			damage = (((arrayDados.get(0) + arrayDados.get(1) + arrayDados.get(2))
					* board[origen[0]][origen[1]].getPj().getFuerza()) * 0.75)
					+ (((arrayDados.get(3) + arrayDados.get(4) + arrayDados.get(5))
							* board[origen[0]][origen[1]].getPj().getSabiduría()) * 0.25);

			// Calculamos la defensa del monstruo
			arrayDados = Dado.getInstance().tirarDados(6, 6);
			defense = (((arrayDados.get(0) + arrayDados.get(1) + arrayDados.get(2))
					* board[pos[0]][pos[1]].getPj().getFuerza()) * 0.75)
					+ (((arrayDados.get(3) + arrayDados.get(4) + arrayDados.get(5))
							* board[pos[0]][pos[1]].getPj().getSabiduría()) * 0.25);

			result = damage - defense;
			System.out.println(damage + " - " + defense + " = " + result);

			if (damage > defense) {
				board[pos[0]][pos[1]].getPj().setEnergía((float) (board[pos[0]][pos[1]].getPj().getEnergía() - result));
			} else {
				board[origen[0]][origen[1]].getPj()
						.setEnergía((float) (board[origen[0]][origen[1]].getPj().getEnergía() + result));
			}
			System.out.println("Vida pers " + board[origen[0]][origen[1]].getPj().getEnergía());
		}

		if (board[origen[0]][origen[1]].getPj().getEnergía() <= 0) {
			System.out.println("Has perdido la partida");
			System.exit(0);
		}
	}

	// Método que calcula el movimiento disponible para el personaje
	public int calculaMovimiento() {
		int posicion[] = new int[3];

		posicion = buscarPersonaje("personaje");

		this.movimientos = (int) (Dado.getInstance().tirarDado(6)
				* Math.floor(board[posicion[0]][posicion[1]].getPj().getVelocidad()));
		return movimientos;
	}

	// Método que actualiza las estadísticas del personaje principal
	public void actualizaStats() {

	}

	public void finalizarturno() {
		int[] pos = new int[2];
		pos = buscarPersonaje("personaje");
		comprobarEvento(pos, new int[2]);
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