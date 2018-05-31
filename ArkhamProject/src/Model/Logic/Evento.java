package Model.Logic;

/**
 * Clase Abstracta Evento. Las hijas deberán emplear el método recompensa, que cambiará  de funcionamiento dependiendo de
 * si el evento es de recompensa por casilla o por combate.
 * @author Alberto Fausto
 */
public abstract class Evento {

protected abstract float[] recompensar(String nombre);
	
}
