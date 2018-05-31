package Model.Logic;

/**
 * Modelo para la pantalla inicial con los datos que se recogen inicialmente
 * para generar la partida.
 * 
 * @author Alberto Fausto
 */
public class InicioModel {

	private String nombrePlayer;
	private int dificultad;

	//Constructor por defecto
	public InicioModel() {
		// Valores por defecto de la partida, si el usuario no los cambia
		nombrePlayer = "Vagabundo";
		dificultad = 16;
	}

	//Constructor parametrizado
	public InicioModel(String nombrePlayer, int dificultad) {
		this.nombrePlayer = nombrePlayer;
		this.dificultad = dificultad;
	}
	
	//Constructor copia
	public InicioModel(InicioModel modelo) {
		this(modelo.nombrePlayer, modelo.dificultad);
	}


	public String getNombrePlayer() {
		return nombrePlayer;
	}

	public void setNombrePlayer(String nombrePlayer) {
		this.nombrePlayer = nombrePlayer;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

}
