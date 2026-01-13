package classActivities._01_BasicStructuresJava.activities;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Actividad 10 – Estatura por género.
 * <p>
 * Solicita la estatura de tres personas y un carácter indicando el género
 * de la muestra ('M' o 'H'). Calcula la media de las estaturas y determina
 * si supera la media nacional correspondiente:
 * </p>
 *
 * <ul>
 *   <li>Hombres: 1.76 m</li>
 *   <li>Mujeres: 1.62 m</li>
 * </ul>
 *
 * <p>
 * En esta actividad se practica el uso del operador ternario como alternativa
 * a estructuras condicionales.
 * </p>
 */
public class Actividad10 {
	private static final Scanner SC = new Scanner(System.in); 
	private static float mediaReal; 
	/**
	 * Solicita al usuario una estatura por consola.
	 * <p>
	 * Controla errores de formato y repite la lectura hasta que se introduce
	 * un valor decimal válido.
	 * </p>
	 *
	 * @return estatura introducida por el usuario
	 */
	private static float scanHeight() {
		float height;
		while (true) {
			System.out.print("Indique la altura: ");
			try {
				height = SC.nextFloat();
			} catch (InputMismatchException e) {
				System.out.println("La altura no puede ser formateado a float.");
				SC.nextLine();
				continue;
			}
			break;
		}
		return height;
		
	}
	/**
	 * Solicita al usuario el género de la muestra por consola.
	 *
	 * @return carácter representando el género ('M' o 'H')
	 */
	private static char scanGender() {
		char gender;
		while (true) {
			System.out.print("Indique el género de la muestra: ");
			gender = SC.next().toUpperCase().charAt(0);
			break;
		}
		return gender;
		
	}
	
	/**
	 * Calcula la media aritmética de tres estaturas.
	 *
	 * @param h1 primera estatura
	 * @param h2 segunda estatura
	 * @param h3 tercera estatura
	 * @return media de las tres estaturas
	 */
	private static float getMedia (float h1, float h2, float h3) {
		return (h1 + h2 + h3)/3f;
	}
	/**
	 * Selecciona la media nacional a comparar en función del género.
	 * <p>
	 * Usa el operador ternario para evitar estructuras condicionales.
	 * </p>
	 *
	 * @param gender género de la muestra ('M' o 'H')
	 */
	private static void selectMediaReal (char gender) {
		mediaReal = (gender=='H')?1.76f:1.62f;
	}
	/**
	 * Método principal de la aplicación.
	 * <p>
	 * Lee las estaturas y el género, calcula la media y muestra si se supera
	 * la media nacional correspondiente.
	 * </p>
	 *
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		float altura1 = scanHeight();
		float altura2 = scanHeight();
		float altura3 = scanHeight();
		char gender = scanGender();
		selectMediaReal(gender);
		float media = getMedia(altura1, altura2, altura3);
		System.out.println("¿Supera la media nacional?"
				+ "\nGenero: " + gender
				+ "\nSuperada: " + (media>mediaReal));

	}

}
