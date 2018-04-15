package Model;

public class Casilla {

	private Edificacion edificio;
	private Personaje pj;
	
	Casilla(){
		//Los elementos se inicializan a null en el constructor por defecto. De este modo mediante el Set
		//los configuramos conforme nos interesa, según dificultad y de forma aleatoria.
		edificio=null;
		pj=null;
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
