package classActivities._01_BasicStructuresJava.practices;

import java.util.Scanner;

public class Practica02 {


	private static final Scanner SC = new Scanner(System.in);	
	
	public static void main(String[] args) {
		double velKmh, velMs;
		
		System.out.println("Indique la velocidad en Km/h");
		velKmh = Double.valueOf(SC.next().replace(',', '.'));
		velMs = velKmh / 3.6;
		
		System.out.println(velMs + " m/s");

	}

}
