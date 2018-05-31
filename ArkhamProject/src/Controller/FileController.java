package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase Controlador de Ficheros Binarios. En este caso se utiliza para
 * gestionar el grabado y consulta de puntuaciones de juego.
 * @author Alberto Fausto
 *
 */
public class FileController {
	private String nombreE;
	private String nombreS;

	// Buffer de 300 bytes (10 líneas de 30 bytes)
	private static final int BUFFER_SIZE = 30;

	public FileController(String nombreE, String nombreS) {
		this.nombreE = nombreE;
		this.nombreS = nombreS;
	}

	public ArrayList<String> read() {
		ArrayList<String> listaPuntos = new ArrayList<String>();
		byte[] buf = new byte[BUFFER_SIZE];
		String cadena = "";

		try {
			FileInputStream ficheroEntrada = new FileInputStream(new File(nombreE));

			while (ficheroEntrada.read(buf, 0, BUFFER_SIZE) > 0) {
				for (int i = 0; i < BUFFER_SIZE; i++) {
					cadena = cadena + (char) buf[i];
				}
				listaPuntos.add(cadena);
				cadena = "";
			}

			ficheroEntrada.close();
		} catch (Exception errorDeFichero) {
			System.out.println("Ha habido problemas: " + errorDeFichero.getMessage());
		}

		return listaPuntos;
	}

	public void write(String cadena) {
		try {
			FileOutputStream ficheroSalida = new FileOutputStream(new File(nombreS), true);
			ficheroSalida.write(cadena.getBytes(), 0, cadena.length());
			ficheroSalida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
