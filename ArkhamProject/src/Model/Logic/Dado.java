package Model.Logic;

import java.util.ArrayList;

/**
 * Clase Dado que utiliza el patrón Singleton para evitar más de una instancia.
 * @author Alberto Fausto
 */
public class Dado {
	private static Dado instance;
	
	//Constructor privado para asegurar que solo la propia clase pueda hacer la instancia
	private Dado(){
		
	}
	
	public static Dado getInstance(){
		if (instance == null){
			instance = new Dado();
		}
		
		return instance;
	}
	
    public int tirarDado(int rango) {
        double resultado;
        resultado=Math.floor(Math.random()*(rango)+1);
        return (int)resultado;
    }
    
    public ArrayList<Integer> tirarDados(int numero, int rango) {
        ArrayList<Integer> resultados=new ArrayList<Integer>();
        for (int i=0; i<numero; i++) {
            resultados.add(Dado.getInstance().tirarDado(rango));
        }
        return resultados;
    }
}