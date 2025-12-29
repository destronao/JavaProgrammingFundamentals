package classActivities._01_BasicStructuresJava.activities;

/**
 * Actividad 2.
 * 
 * Declara una constante que almacena un nombre y muestra por pantalla
 * un mensaje de bienvenida utilizando dicho valor.
 * 
 * En esta actividad se introduce el uso de:
 * - Constantes (final)
 * - Métodos que devuelven valores
 * - Concatenación de cadenas
 */
public class Actividad02 {
	/**
	 * Nombre constante utilizado para generar el mensaje de bienvenida.
	 */
	private static final String NOMBRE = "Destronao";
	
	/**
	 * Genera un mensaje de bienvenida utilizando el nombre almacenado
	 * en la constante {@code NOMBRE}.
	 * 
	 * @return mensaje de bienvenida con el formato "Hola, nombre"
	 */
	private static String WelcomeMessage () {
		return "Hola, " + NOMBRE;
	}
	
	/**
	 * Método principal de la aplicación.
	 * 
	 * Llama al método {@code welcomeMessage()} y muestra el mensaje
	 * resultante por pantalla.
	 * 
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		String msg = WelcomeMessage ();
		System.out.println (msg);
	}

}
