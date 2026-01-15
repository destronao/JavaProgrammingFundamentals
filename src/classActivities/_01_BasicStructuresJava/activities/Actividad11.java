package classActivities._01_BasicStructuresJava.activities;

import java.util.Scanner;

public class Actividad11 {
	

	private static final Scanner SC = new Scanner(System.in); 
	
	
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
