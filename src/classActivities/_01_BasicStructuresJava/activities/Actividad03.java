package classActivities._01_BasicStructuresJava.activities;

import java.util.Scanner;

public class Actividad03 {
	
	/**
	 * Scanner utilizado para leer la entrada del usuario desde la consola.
	 */
	private static final Scanner SC = new Scanner(System.in);
	
	/**
	 * Nombre introducido por el usuario.
	 */
	private static String nombre;
	/**
	 * Genera un mensaje de bienvenida utilizando el nombre almacenado
	 * en la constante {@code NOMBRE}.
	 * 
	 * @return mensaje de bienvenida con el formato "Hola, nombre"
	 */
	private static String WelcomeMessage () {
		return "Hola, " + nombre;
	}
	
	/**
	 * Solicita al usuario su nombre por teclado y lo almacena
	 * en la variable {@code nombre}.
	 */
	private static void askName() {
		System.out.print("Por favor, indique  su nombre: ");
		nombre = SC.next();
	}
	
	/**
	 * Imprime por consola el mensaje recibido como parámetro.
	 * 
	 * @param message mensaje a mostrar
	 */
	private static void print(String message) {
		System.out.println(message);
	}
	/**
	 * Método principal de la aplicación.
	 * 
	 * Gestiona el flujo del programa:
	 * <ul>
	 *   <li>Solicita el nombre al usuario</li>
	 *   <li>Genera el mensaje de bienvenida</li>
	 *   <li>Muestra el mensaje por consola</li>
	 * </ul>
	 * 
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		askName();
		String msg = WelcomeMessage ();
		print(msg);
		SC.close();
	}

}
