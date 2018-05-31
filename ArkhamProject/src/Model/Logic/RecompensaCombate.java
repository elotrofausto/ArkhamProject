package Model.Logic;

/**
 * Clase RecompensaCombate que utiliza el patrón Singleton para evitar más de
 * una instancia. Es la Clase que utilizamos para hacer efectivas las
 * recompensas después de ganar un combate. Extiende a la clase Evento e
 * implementa obligatoriamente su método abstracto recompensar().
 * 
 * @author Alberto Fausto
 */
public class RecompensaCombate extends Evento {

	/** objeto Singleton */
	private static RecompensaCombate instance = new RecompensaCombate();

	// Recompensas constantes. Se gastan arrays por exigencias de la clase Abstracta
	// Evento y la clase hermana de esta Recompensa.
	private static final float CTHONIANS[] = new float[] { 10 };
	private static final float EVILPUMPKIN[] = new float[] { 30 };
	private static final float OLDTREE[] = new float[] { 30 };
	private static final float EVILWOLF[] = new float[] { 50 };

	// Constructor privado para asegurar que solo la propia clase pueda hacer la
	// instancia
	private RecompensaCombate() {

	}

	public static RecompensaCombate getInstance() {
		if (instance == null) {
			instance = new RecompensaCombate();
		}
		return instance;
	}

	@Override
	protected float[] recompensar(String nombre) {
		float recom[] = null;

		switch (nombre) {
		case "cthonians":
			recom = CTHONIANS;
			break;
		case "evilpumpkin":
			recom = EVILPUMPKIN;
			break;
		case "oldtree":
			recom = OLDTREE;
			break;
		case "evilwolf":
			recom = EVILWOLF;
			break;
		}
		return recom;
	}

}
