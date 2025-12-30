package classActivities._01_BasicStructuresJava.activities;

import java.util.Scanner;


/**
 * Actividad 04.
 * 
 * Programa que solicita dos números enteros por teclado y muestra
 * la suma de ambos.  
 * 
 * La lectura de datos incluye control de errores para evitar
 * entradas no válidas y la suma se realiza en tipo {@code long}
 * para prevenir desbordamientos del tipo {@code int}.
 */
public class Actividad04 {
	/**
	 * Scanner utilizado para leer la entrada del usuario desde la consola.
	 * 
	 * Se define como constante para reutilizarlo en distintos métodos.
	 */
	private static final Scanner SC = new Scanner(System.in);
	
	/**
	 * Solicita al usuario un número entero por consola.
	 * 
	 * El método controla posibles errores de formato y repite la lectura
	 * hasta que el usuario introduce un valor válido.
	 * 
	 * @return número entero introducido por el usuario
	 */
	private static int readInt () {
		System.out.print("Por favor, indique un número entero: ");
		int num;
		while (true) {

			try {
				String line = SC.nextLine();
				num = Integer.valueOf(line);
			} catch (NumberFormatException e) {
				System.out.print("Lectura erronea, debe indicar un número entero. \n"
						+ "Por favor, indique un número entero: ");
				continue;
			} 
			break;
		}
		return num;
	}
	/**
	 * Calcula la suma de dos números enteros.
	 * 
	 * La operación se realiza utilizando el tipo {@code long} para evitar
	 * posibles desbordamientos cuando la suma supera el rango de {@code int}.
	 * 
	 * @param num1 primer número entero
	 * @param num2 segundo número entero
	 * @return resultado de la suma en tipo {@code long}
	 */
	private static long suma(int num1, int num2) {
		long resultado = (long) num1 + num2;	
		return resultado;
	}
	/**
	 * Método principal del programa.
	 * 
	 * Solicita dos números al usuario, calcula su suma y muestra
	 * el resultado por pantalla.
	 * 
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		int a = readInt();
		int b = readInt();
		long suma = suma(a,b);
		
		System.out.println("La suma de "+ a + " + " + b + " = " + suma);
	}

}
