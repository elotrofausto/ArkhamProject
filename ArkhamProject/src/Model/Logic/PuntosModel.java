package Model.Logic;

/**
 * Clase PuntosModel que utiliza el patrón Singleton para evitar más de una instancia.
 * Es el Modelo que utilizaremos para cargar la última puntuación al final de la partida.
 * Necesitamos acceder de forma estática para actualizar o consultar los puntos a lo largo de la partida.
 * @author Alberto Fausto
 */
public class PuntosModel {

	/** objeto Singleton */
	private static PuntosModel instance = new PuntosModel();
	
	String nombre;
	Float puntos;
	
	//Constructor privado para asegurar que solo la propia clase pueda hacer la instancia
	private PuntosModel() {
		nombre="";
		puntos=0F;
	}
	
	public static PuntosModel getInstance() {
		if(instance == null) {
	         instance = new PuntosModel();
	      }
		return instance;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPuntos() {
		return puntos;
	}

	public void setPuntos(Float puntos) {
		this.puntos = puntos;
	}
	
	
	
}
