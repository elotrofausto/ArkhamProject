package Model.Locations;

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
