package classActivities._01_BasicStructuresJava.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Actividad 09 – Altura media.
 * <p>
 * Solicita por teclado la estatura de tres personas y calcula su media.
 * A continuación, determina si dicha media supera la estatura media
 * nacional (1.69 metros).
 * </p>
 *
 * <p>
 * El programa:
 * <ul>
 *   <li>Lee tres valores decimales correspondientes a estaturas.</li>
 *   <li>Controla errores de formato en la entrada.</li>
 *   <li>Calcula la media de las tres estaturas.</li>
 *   <li>Muestra por pantalla un valor booleano indicando si supera la media nacional.</li>
 * </ul>
 * </p>
 */
public class Actividad09 {
	
	private static final Scanner SC = new Scanner(System.in); 
	
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
	
	
	public static void main(String[] args) {
		float altura1 = scanHeight();
		float altura2 = scanHeight();
		float altura3 = scanHeight();
		
		System.out.println("Supera la media nacional: " + (getMedia(altura1,altura2,altura3)>1.69f));

	}

}
