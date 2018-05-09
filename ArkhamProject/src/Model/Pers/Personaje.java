package Model.Pers;

public abstract class Personaje {

	private float Fuerza;
	private float Velocidad;
	private float Oro;
	private float Energía;
	private float Sabiduría;
	private String nombre;
	
	public Personaje(float fuerza, float velocidad, float oro, float energía, float sabiduría, String nombre) {
		this.Fuerza = fuerza;
		this.Velocidad = velocidad;
		this.Oro = oro;
		this.Energía = energía;
		this.Sabiduría = sabiduría;
		this.nombre = nombre;
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
