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
	protected float Energía;
	protected float Sabiduría;
	protected String nombre;

	// Constructor por defecto
	public Personaje() {

	}

	// Constructor parametrizado
	public Personaje(float fuerza, float velocidad, float oro, float energía, float sabiduría, String nombre) {
		this.Fuerza = fuerza;
		this.Velocidad = velocidad;
		this.Oro = oro;
		this.Energía = energía;
		this.Sabiduría = sabiduría;
		this.nombre = nombre;
	}

	// Constructor copia
	public Personaje(Personaje modelo) {
		this(modelo.Fuerza, modelo.Velocidad, modelo.Oro, modelo.Energía, modelo.Sabiduría, modelo.nombre);
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

	public float getEnergía() {
		return Energía;
	}

	public void setEnergía(float energía) {
		Energía = energía;
	}

	public float getSabiduría() {
		return Sabiduría;
	}

	public void setSabiduría(float sabiduría) {
		Sabiduría = sabiduría;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
