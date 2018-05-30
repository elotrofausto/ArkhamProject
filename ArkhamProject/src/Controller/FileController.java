package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Clase Controlador de Ficheros Binarios. En este caso se utiliza para
 * gestionar el grabado y consulta de puntuaciones de juego.
 * 
 * @author Alberto Fausto
 *
 */
public class FileController {
	private String nombreE;
	private String nombreS;

	// Buffer de 300 bytes (10 líneas de 30 bytes)
	private static final int BUFFER_SIZE = 300;

	public FileController(String nombreE, String nombreS) {
		this.nombreE = nombreE;
		this.nombreS = nombreS;
	}

	public byte[] read() {
		byte[] buf = new byte[BUFFER_SIZE];

		try {
			FileInputStream ficheroEntrada = new FileInputStream(new File(nombreE));

			// Leemos el fichero y lo cargamos en el array de bytes buf
			ficheroEntrada.read(buf, 0, BUFFER_SIZE);

			ficheroEntrada.close();
		} catch (Exception errorDeFichero) {
			System.out.println("Ha habido problemas: " + errorDeFichero.getMessage());
		}
		return buf;
	}

	public void write(byte[] buf) {
		try {
			FileOutputStream ficheroSalida = new FileOutputStream(new File(nombreS));
			ficheroSalida.write(buf, 0, BUFFER_SIZE);
			ficheroSalida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
