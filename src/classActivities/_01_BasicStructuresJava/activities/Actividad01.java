package classActivities._01_BasicStructuresJava.activities;


/**
 * <h1>Actividad 01 - Hola Mundo</h1>
 *
 * <p>
 * Esta actividad tiene como objetivo introducir la salida de información
 * por consola en Java mediante el método {@code System.out.println}.
 * </p>
 *
 * <p>
 * Se muestran distintas formas de imprimir el mismo mensaje:
 * </p>
 * <ul>
 *   <li>Impresión directa desde el método {@code main}.</li>
 *   <li>Uso de un método específico para imprimir un mensaje concreto.</li>
 *   <li>Uso de un método genérico que recibe un mensaje como parámetro.</li>
 * </ul>
 *
 * <p>
 * En esta actividad no se utilizan variables, ya que su uso se abordará
 * en actividades posteriores.
 * </p>
 *
 * @author Destronao
 * @version 1.0
 */
public class Actividad01 {
	
	/**
	 * Imprime por consola el mensaje fijo {@code "Hola, mundo"}.
	 *
	 * <p>
	 * Este método representa un ejemplo de método específico,
	 * cuyo único propósito es mostrar un mensaje concreto.
	 * </p>
	 */
	private static void helloWorld() {
		System.out.println("Hola, mundo");
	}
	
	/**
	 * Imprime por consola el mensaje recibido como parámetro.
	 *
	 * <p>
	 * Este método es un ejemplo de método genérico que permite
	 * reutilizar la funcionalidad de impresión para cualquier texto.
	 * </p>
	 *
	 * @param message texto que se mostrará por consola
	 */
	private static void print(String message) {
		System.out.println(message);
	}
	
	/**
	 * Método principal de la aplicación.
	 *
	 * <p>
	 * Desde este método se comparan distintas formas de imprimir
	 * el mismo mensaje por consola:
	 * </p>
	 * <ul>
	 *   <li>Impresión directa.</li>
	 *   <li>Llamada a un método específico.</li>
	 *   <li>Llamada a un método genérico.</li>
	 * </ul>
	 *
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		
		//Aqui comparo 3 formas de imprimir el mismo mensaje: 
		//Un metodo directo, un metodo especifico y un método generico.
		System.out.println("Hola, mundo");
		
		helloWorld();
		print("Hola, mundo");
	}

}