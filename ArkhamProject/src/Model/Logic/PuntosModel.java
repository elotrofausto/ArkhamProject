package Model.Logic;

public class PuntosModel {

	/** objeto Singleton */
	private static PuntosModel instance = new PuntosModel();
	
	String nombre;
	Float puntos;
	
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
