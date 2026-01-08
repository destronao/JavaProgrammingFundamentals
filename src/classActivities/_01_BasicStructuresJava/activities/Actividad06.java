package classActivities._01_BasicStructuresJava.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Actividad 6 – Circunferencia.
 * <p>
 * Calcula el perímetro de una circunferencia a partir del radio introducido
 * por teclado.
 * </p>
 *
 * <p>
 * El programa:
 * <ul>
 *   <li>Define una constante para el valor de PI.</li>
 *   <li>Solicita al usuario un radio de tipo real.</li>
 *   <li>Valida la entrada del usuario.</li>
 *   <li>Calcula el perímetro usando la fórmula matemática correspondiente.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Nota: No se utiliza la clase {@code Math} según los requisitos del ejercicio.
 * </p>
 */
public class Actividad06 {
	
	private static final double PI = 3.14;
	
	private static final Scanner SC = new Scanner(System.in);
	
	/**
	 * Calcula el perímetro de una circunferencia a partir de su radio.
	 *
	 * @param radius radio de la circunferencia (debe ser mayor o igual que 0)
	 * @return perímetro de la circunferencia
	 * @throws IllegalArgumentException si el radio es negativo
	 */
	private static double getCirclePerimeter(double radius) {
		if (radius <0 ) {
			throw new IllegalArgumentException("radius can´t be negative.");
		}
		return 2*PI*radius;
	}
	
	/**
	 * Solicita al usuario el radio de la circunferencia por consola.
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
			System.out.print("Indique el radio del circulo.");
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
		System.out.println("Bienvenido, vamos a calular el perimetro de una circunferencia.");
		double radius = scanRadius();
		double longitud = getCirclePerimeter(radius);
		System.out.println("El perimetro de la circunferencia de radio " + radius + " es de " + longitud);
		SC.close();

	}

}
