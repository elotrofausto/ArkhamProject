package Model.Locations;

import Model.Pers.Personaje;

public class Casilla {

	private Edificacion edificio;
	private Personaje pj[];
	
	public Casilla(){
		//Los edificios se inicializan a null en el constructor por defecto. De este modo mediante el Set
		//los configuramos conforme nos interesa, de forma aleatoria.
		edificio=null;
		pj=new Personaje[2];
	}

	public Edificacion getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificacion edificio) {
		this.edificio = edificio;
	}

	public Personaje[] getPj() {
		return pj;
	}

	public void setPj(Personaje[] pj) {
		this.pj = pj;
	}


	
	
	
}
