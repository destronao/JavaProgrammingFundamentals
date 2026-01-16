package classActivities._01_BasicStructuresJava.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Actividad 08 – Edad para trabajar.
 * <p>
 * Solicita al usuario su edad por consola y determina si se encuentra
 * en edad legal para trabajar, considerando el rango entre 16 y 65 años
 * (ambos inclusive).
 * </p>
 *
 * <p>
 * El programa:
 * <ul>
 *   <li>Lee la edad del usuario como un número entero.</li>
 *   <li>Controla errores de formato en la entrada.</li>
 *   <li>Evalúa si la edad está dentro del rango permitido.</li>
 *   <li>Muestra el resultado como un valor booleano.</li>
 * </ul>
 * </p>
 */
public class Actividad08 {
	
	private static boolean edadTrabajar;
	private static final Scanner SC = new Scanner(System.in); 
	/**
	 * Solicita al usuario su edad por consola.
	 * <p>
	 * Controla errores de formato y repite la lectura hasta que se introduce
	 * un valor entero válido.
	 * </p>
	 *
	 * @return edad introducida por el usuario
	 */
	private static int scanAge() {
		int edad;
		while (true) {
			System.out.print("Indique su edad: ");
			try {
				edad = SC.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("La edad no puede ser formateado a int.");
				SC.nextLine();
				continue;
			}
			break;
		}
		return edad;
	}
	
	/**
	 * Determina si una edad se encuentra dentro del rango legal para trabajar.
	 *
	 * @param age edad a evaluar
	 * @return {@code true} si la edad está entre 16 y 65 años, {@code false} en caso contrario
	 */
	private static boolean ageForWork(int age) {
		return age>=16 && age <=65;
	}
	
	public static void main(String[] args) {
		int edad;
		
		edad = scanAge();
		edadTrabajar = ageForWork (edad);
		System.out.println("En edad de trabajar: " + edadTrabajar);

	}

}
