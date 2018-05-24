package Model.Locations;

public class Calle extends Edificacion {

	public Calle(){
		super("calle" + (int)Math.floor(Math.random()*(13-1+1)+(1)));
	}
	
}
