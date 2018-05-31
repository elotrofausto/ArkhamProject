package Model.Locations;

/**
 * Clase Calle que extiende a la Clase Abstracta Edificación. Utiliza un superConstructor.
 * @author Alberto Fausto
 *
 */
public class Calle extends Edificacion {

	public Calle(){
		super("calle" + (int)Math.floor(Math.random()*(13-1+1)+(1)));
	}
	
}
