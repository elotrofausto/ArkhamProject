package Model.Logic;

import Model.Locations.Edificacion;
import Model.Pers.Personaje;

/**
 * Clase Casilla. Representa cada una de las casillas del tablero de juego. El Modelo tendrá una matriz de Casillas.
 * @author Alberto Fausto
 */
public class Casilla {

	private Edificacion edificio;
	private Personaje pj;
	private Evento evento;
	
	public Casilla(){
		//Los edificios y personajes se inicializan a null en el constructor por defecto. De este modo mediante el Set
		//los configuramos conforme nos interesa, de forma aleatoria.
		edificio=null;
		pj=null;
	}
	
	public Casilla(Edificacion edificio, Personaje pj) {
		this.edificio=edificio;
		this.pj=pj;
	}
	
	public Casilla(Casilla casilla) {
		this(casilla.getEdificio(),casilla.getPj());
	}

	public Edificacion getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificacion edificio) {
		this.edificio = edificio;
	}

	public Personaje getPj() {
		return pj;
	}

	public void setPj(Personaje pj) {
		this.pj = pj;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
}
