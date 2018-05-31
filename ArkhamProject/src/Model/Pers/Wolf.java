package Model.Pers;

/**
 * Clase Wolf que extiende a la Clase Abstracta Personaje. Utiliza un superConstructor.
 * @author Alberto Fausto
 *
 */
public class Wolf extends Personaje{

	//Equivalente a la autoridad
	public Wolf() {
		super(1.5F,1F,50F,100F,1F,"evilwolf");
	}
	
}
