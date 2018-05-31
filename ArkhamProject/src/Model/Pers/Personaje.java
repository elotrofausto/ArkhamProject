package Model.Pers;

/**
 * Clase Abstracta Personaje. Todas los tipos de personajes del juego son hijos
 * de esta. Como la clase Abstracta no se puede instanciar. Las hijas utilizarán
 * un superConstructor.
 * 
 * @author Alberto Fausto
 *
 */
public abstract class Personaje {

	protected float Fuerza;
	protected float Velocidad;
	protected float Oro;
	protected float Energia;
	protected float Sabiduria;
	protected String nombre;

	// Constructor por defecto
	public Personaje() {

	}

	// Constructor parametrizado
	public Personaje(float fuerza, float velocidad, float oro, float energia, float sabiduria, String nombre) {
		this.Fuerza = fuerza;
		this.Velocidad = velocidad;
		this.Oro = oro;
		this.Energia = energia;
		this.Sabiduria = sabiduria;
		this.nombre = nombre;
	}

	// Constructor copia
	public Personaje(Personaje modelo) {
		this(modelo.Fuerza, modelo.Velocidad, modelo.Oro, modelo.Energia, modelo.Sabiduria, modelo.nombre);
	}

	public float getFuerza() {
		return Fuerza;
	}

	public void setFuerza(float fuerza) {
		Fuerza = fuerza;
	}

	public float getVelocidad() {
		return Velocidad;
	}

	public void setVelocidad(float velocidad) {
		Velocidad = velocidad;
	}

	public float getOro() {
		return Oro;
	}

	public void setOro(float oro) {
		Oro = oro;
	}

	public float getEnergia() {
		return Energia;
	}

	public void setEnergia(float energia) {
		Energia = energia;
	}

	public float getSabiduria() {
		return Sabiduria;
	}

	public void setSabiduria(float sabiduria) {
		Sabiduria = sabiduria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
