package classActivities._01_BasicStructuresJava.practices;

import java.util.Scanner;
/**
 * Práctica 01 – Conversión de temperatura.
 * <p>
 * Solicita al usuario una temperatura en grados centígrados y la convierte
 * a grados Fahrenheit utilizando la fórmula correspondiente.
 * </p>
 *
 * <p>
 * Esta versión prioriza una implementación simple. La validación de datos
 * y la separación en métodos se abordarán en un refactor posterior.
 * </p>
 */
public class Practica01 {

	private static final Scanner SC = new Scanner(System.in);	
	/**
	 * Método principal de la aplicación.
	 * <p>
	 * Lee la temperatura en grados centígrados desde consola, realiza la conversión
	 * a grados Fahrenheit y muestra el resultado.
	 * </p>
	 *
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		double tempCent;
		double tempFah;
		
		System.out.println("Ingrese temperatura en ºC");
		tempCent = Double.valueOf(SC.next().replace(',', '.'));
		tempFah = 32 + (9*tempCent / 5);
		System.out.println("El resultado es: " + tempFah + "ºF");

	}

}
