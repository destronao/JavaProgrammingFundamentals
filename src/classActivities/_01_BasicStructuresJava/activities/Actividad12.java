package classActivities._01_BasicStructuresJava.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Actividad 12 – Intercambio de valores.
 * <p>
 * Solicita al usuario dos números enteros (num1 y num2), muestra sus valores
 * iniciales, intercambia los valores usando una variable auxiliar y finalmente
 * muestra los valores finales.
 * </p>
 */
public class Actividad12 {

	private static final Scanner SC = new Scanner(System.in); 
	private static int num1, num2;
	
	/**
	 * Solicita al usuario un número entero por consola.
	 * <p>
	 * Controla errores de formato y repite la lectura hasta que se introduce
	 * un valor entero válido.
	 * </p>
	 *
	 * @return número entero introducido por el usuario
	 */
	private static int scanInt() {
		int number;
		while (true) {
			System.out.print("Indique un numero: ");
			try {
				number = SC.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("El número no puede ser formateado a int.");
				SC.nextLine();
				continue;
			}
			break;
		}
		return number;
		
	}
	
	/**
	 * Muestra por pantalla los valores actuales de {@code num1} y {@code num2}.
	 */
	private static void printValues() {
		System.out.println("num1 = "+ num1 + "\n"
				+ "num2 = "+ num2);
	}
	
	/**
	 * Intercambia los valores de {@code num1} y {@code num2} usando una variable auxiliar.
	 */
	private static void flipValues() {
		int aux;
		aux = num1;
		num1 = num2;
		num2 = aux;
	}
	
	/**
	 * Método principal de la aplicación.
	 * <p>
	 * Lee los valores, los muestra, realiza el intercambio y vuelve a mostrarlos.
	 * </p>
	 *
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		num1 = scanInt();
		num2 = scanInt();
		System.out.println("Valores iniciales:");
		printValues();
		flipValues();
		System.out.println("Valores finales:");
		printValues();

	}

}
