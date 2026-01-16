package classActivities._01_BasicStructuresJava.activities;

import java.util.Scanner;

/**
 * Actividad 11 – Arcoíris.
 * <p>
 * Solicita al usuario si está lloviendo y si hace sol mediante respuestas
 * 'S' o 'N'. A partir de estas respuestas, determina si aparece o no el
 * arcoíris.
 * </p>
 *
 * <p>
 * El ejercicio se resuelve sin usar estructuras condicionales {@code if},
 * empleando operadores lógicos y el operador ternario.
 * </p>
 */
public class Actividad11 {
	

	private static final Scanner SC = new Scanner(System.in); 
	
	/**
	 * Método principal de la aplicación.
	 * <p>
	 * Lee las respuestas del usuario, evalúa la condición necesaria para que
	 * aparezca el arcoíris y muestra un mensaje descriptivo por pantalla.
	 * </p>
	 *
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		
		char lluvia;
		char sol;
		boolean arcoiris;
		String mensaje;
		
		System.out.print("¿Está lloviendo? S/N: ");
		lluvia = SC.next().toUpperCase().charAt(0);
		System.out.print("¿Hace sol? S/N: ");
		sol = SC.next().toUpperCase().charAt(0);
		
		arcoiris = (lluvia == 'S' && sol == 'S');
		
		//En lugar de usar true o false para la salida usaremos un mensaje.
		mensaje = (arcoiris)?"El arcoiris va a salir":"El arcoiris no va a salir";
		System.out.println(mensaje);

	}

}
