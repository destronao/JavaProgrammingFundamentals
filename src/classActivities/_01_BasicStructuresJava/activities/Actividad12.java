package classActivities._01_BasicStructuresJava.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad12 {

	private static final Scanner SC = new Scanner(System.in); 
	private static int num1, num2;
	
	private static int scanInt() {
		int number;
		while (true) {
			System.out.print("Indique un numero: ");
			try {
				number = SC.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("El número no puede ser formateado a int.");
				SC.nextLine();
				continue;
			}
			break;
		}
		return number;
		
	}
	
	private static void printValues() {
		System.out.println("num1 = "+ num1 + "\n"
				+ "num2 = "+ num2);
	}
	
	private static void flipValues() {
		int aux;
		aux = num1;
		num1 = num2;
		num2 = aux;
	}
	
	public static void main(String[] args) {
		num1 = scanInt();
		num2 = scanInt();
		System.out.println("Valores iniciales:");
		printValues();
		flipValues();
		System.out.println("Valores finales:");
		printValues();

	}

}
