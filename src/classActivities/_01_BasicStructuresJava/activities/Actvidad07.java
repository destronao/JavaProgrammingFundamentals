package classActivities._01_BasicStructuresJava.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Actividad 7 – Mayor de edad.
 * <p>
 * Solicita al usuario su edad por teclado y determina si es mayor de edad.
 * </p>
 *
 * <p>
 * El programa:
 * <ul>
 *   <li>Lee la edad del usuario como un número entero.</li>
 *   <li>Valida la entrada para evitar errores de formato.</li>
 *   <li>Evalúa si la edad es mayor o igual a 18.</li>
 *   <li>Muestra el resultado por pantalla como un valor booleano.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Nota: No se utiliza la estructura {@code if} para cumplir con las
 * restricciones del ejercicio.
 * </p>
 */
public class Actvidad07 {
	
	private static boolean mayorDeEdad;
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
	public static void main(String[] args) {
		int edad;
		
		edad = scanAge();
		mayorDeEdad = edad>=18;
		System.out.println("Mayor de edad: " + mayorDeEdad);
		
	}

}
