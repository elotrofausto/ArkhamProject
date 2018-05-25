package Model.Logic;

public class RecompensaCombate extends Evento {

	/** objeto Singleton */
	private static RecompensaCombate instance = new RecompensaCombate();
	
	private static float cthonians[];
	private static float evilpumpkin[];
	private static float oldtree[];
	private static float evilwolf[];

	private RecompensaCombate() {
		cthonians = new float[] {10};
		evilpumpkin = new float[] {30};
		oldtree = new float[] {30};
		evilwolf = new float[] {50};
	}
	
	public static RecompensaCombate getInstance() {
		if(instance == null) {
	         instance = new RecompensaCombate();
	      }
	      return instance;
	}

	@Override
	protected float[] recompensar(String nombre) {
		float recom[] = null;
		
		switch (nombre) {
		case "cthonians":
			recom=cthonians;
			break;
		case "evilpumpkin":
			recom=evilpumpkin;
			break;
		case "oldtree":
			recom=oldtree;
			break;
		case "evilwolf":
			recom=evilwolf;
			break;
		}
		return recom;
	}

}
