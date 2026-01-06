package classActivities._01_BasicStructuresJava.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Actividad 5 – Esfera.
 * <p>
 * Calcula el volumen de una esfera a partir de un radio introducido por teclado.
 * </p>
 *
 * <p>
 * El programa:
 * <ul>
 *   <li>Define una constante para el valor de PI.</li>
 *   <li>Solicita al usuario un radio de tipo real.</li>
 *   <li>Valida la entrada del usuario.</li>
 *   <li>Calcula el volumen de la esfera usando la fórmula matemática correspondiente.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Nota: No se utiliza la clase {@code Math} según los requisitos del ejercicio.
 * </p>
 */
public class Actividad05 {
	//Con Math.PI tendriamos el valor de PI pero se pide  no Usar Math
	private static final double PI = 3.14;
	private static final Scanner SC = new Scanner(System.in);
	
	/**
	 * Calcula el volumen de una esfera a partir de su radio.
	 *
	 * @param radius radio de la esfera (debe ser mayor o igual que 0)
	 * @return volumen de la esfera
	 * @throws IllegalArgumentException si el radio es negativo
	 */
	private static double  getSphereVolume (double radius) {
		if (radius < 0 ) {
			throw new IllegalArgumentException("radius can´t be negative.");
		}
		return 4.0/3.0 * PI * radius * radius * radius; 
		//Con Math.pow se podria expresar mejor la potencia
	}
	
	/**
	 * Solicita al usuario el radio de la esfera por consola.
	 * <p>
	 * Controla errores de formato y repite la lectura hasta que se introduce
	 * un valor numérico válido.
	 * </p>
	 *
	 * @return radio introducido por el usuario
	 */
	private static double scanRadius() {
		double radius;
		while (true) {
			System.out.print("Indique el radio de la esfera.");
			try {
				radius = SC.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("El radio no puede ser formateado a double.");
				SC.nextLine();
				continue;
			}
			break;
		}
		return radius;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido, vamos a calular el volumen de una esfera.");
		double radius = scanRadius();
		double volume = getSphereVolume(radius);
		System.out.println("El volumen de la esfera de radio " + radius + " es de " + volume);
		SC.close();
	}

}
