package Model.Logic;

/**
 * Clase Recompensa que utiliza el patrón Singleton para evitar más de una instancia.
 * Es la Clase que utilizamos para hacer efectivas las recompensas de las diferentes Edificaciones.
 * Extiende a la clase Evento e implementa obligatoriamente su método abstracto recompensar().
 * @author Alberto Fausto
 */
public class Recompensa extends Evento {

	/** objeto Singleton */
	private static Recompensa instance = new Recompensa();
	
	//Las recompensas son constantes
	private static final float ARMERIA[] =  new float[]{1.2F,1.1F,10.0F,1F,1F};
	private static final float BIBLIOTECA[] = new float[]{1.0F,1.0F,10F,1.05F,1.25F};
	private static final float HOSPITAL[] = new float[]{1.0F,1.0F,10.0F,1.25F,1.05F};
	private static final float LOGIA[] = new float[]{1.1F,1.1F,0F,1.1F,1.1F};
	private static final float CALLE[] = new float[]{1F,1F,1F,1F,1F};
	
	//Constructor privado para asegurar que solo la propia clase pueda hacer la instancia
	private Recompensa(){

	}
	
	public static Recompensa getInstance() {
		if(instance == null) {
	         instance = new Recompensa();
	      }
	      return instance;
	}
	
	public float[] recompensar(String tipo){
		float[] recom= new float [5];
		
		switch (tipo) {
		case "armeria":
			recom=ARMERIA;
			break;
		case "biblioteca":
			recom=BIBLIOTECA;
			break;
		case "hospital":
			recom=HOSPITAL;
			break;
		case "logia":
			recom=LOGIA;
			break;
		default:
			recom=CALLE;
			break;
		}
		
		return recom;
	}
}
