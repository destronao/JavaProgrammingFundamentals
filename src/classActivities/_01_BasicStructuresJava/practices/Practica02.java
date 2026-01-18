package classActivities._01_BasicStructuresJava.practices;

import java.util.Scanner;
/**
 * Práctica 02 – Conversión de velocidad.
 * <p>
 * Solicita al usuario una velocidad en kilómetros por hora (km/h) y la
 * convierte a metros por segundo (m/s).
 * </p>
 *
 * <p>
 * Esta implementación prioriza la simplicidad y la corrección de la
 * conversión. La validación de datos y la separación en métodos se
 * abordarán en una fase posterior de refactorización.
 * </p>
 */
public class Practica02 {


	private static final Scanner SC = new Scanner(System.in);	
	/**
	 * Método principal de la aplicación.
	 * <p>
	 * Lee la velocidad en km/h desde consola, realiza la conversión a m/s
	 * y muestra el resultado.
	 * </p>
	 *
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		double velKmh, velMs;
		
		System.out.println("Indique la velocidad en Km/h");
		velKmh = Double.valueOf(SC.next().replace(',', '.'));
		velMs = velKmh / 3.6;
		
		System.out.println(velMs + " m/s");

	}

}
