package classActivities._01_BasicStructuresJava.activities;


/**
 * Actividad 1: Imprimir por pantalla "Hola, mundo",
 * vamos a usar distintos metodos para imprimir dicho mensaje.
 * 
 * Actualmente no vamos a utilizar variables ya que lo dejaremos para la Actividad 2.
 */
public class Actividad01 {
	
	/**
	 * Imprime "Hola, mundo" 
	 */
	private static void helloWorld() {
		System.out.println("Hola, mundo");
	}
	
	/**
	 * Imprime el mensaje pasado como argumento.
	 * @param message
	 */
	private static void print(String message) {
		System.out.println(message);
	}
	
	
	public static void main(String[] args) {
		
		//Aqui comparo 3 formas de imprimir el mismo mensaje: 
		//Un metodo directo, un metodo especifico y un método generico.
		System.out.println("Hola, mundo");
		
		helloWorld();
		print("Hola, mundo");
	}

}