package Model.Locations;

/**
 * Clase Abstracta Edificación. Todas los tipos de edificaciones del juego son hijos de esta.
 * Como la clase Abstracta no se puede instanciar. Las hijas utilizarán un superConstructor.
 * @author Alberto Fausto
 *
 */
public abstract class Edificacion {

	private String image;
	private boolean activo;
	
	public Edificacion(String image){
		this.image=image;
		activo=true;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
