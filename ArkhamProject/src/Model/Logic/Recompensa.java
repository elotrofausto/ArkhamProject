package Model.Logic;

public class Recompensa extends Evento {

	/** objeto Singleton */
	private static Recompensa instance = new Recompensa();
	
	private static float armeria[];
	private static float biblioteca[];
	private static float hospital[];
	private static float logia[];
	private static float calle[];
	
	private Recompensa(){
		armeria = new float[]{1.2F,1.1F,10.0F,1F,1F};
		biblioteca = new float[]{1.0F,1.0F,10F,1.05F,1.25F};
		hospital = new float[]{1.0F,1.0F,10.0F,1.25F,1.05F};
		logia = new float[]{1.1F,1.1F,0F,1.1F,1.1F};
		calle = new float[]{1F,1F,1F,1F,1F};
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
			recom=armeria;
			break;
		case "biblioteca":
			recom=biblioteca;
			break;
		case "hospital":
			recom=hospital;
			break;
		case "logia":
			recom=logia;
			break;
		default:
			recom=calle;
			break;
		}
		
		return recom;
	}
}
