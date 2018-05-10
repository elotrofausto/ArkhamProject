package Model.Logic;

import Model.Locations.Edificacion;
import Model.Pers.Personaje;

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


	
	
	
}
