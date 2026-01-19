package classActivities._04_DataStructures.activities.actividad1;

import java.util.Random;

public class Vector {
	private int[] enteros;
	private int posVacia;
	private Random random = new Random();
	
	Vector (int tamaño){
		enteros = new int[tamaño];
		posVacia = 0;
		for (int i=0; i < tamaño;i++) {
			enteros[i] = random.nextInt(0, 21);
			posVacia++;
		}
	} 
	
	public void rellenar() {
		for (int i=posVacia;i < enteros.length;i++) {
			enteros[i] = random.nextInt(0, 101);
			posVacia++;
		}
	}
	public void vaciar() {
		enteros = new int[(enteros.length+1)];
		posVacia = 0;
	}
	
	public int numeroElementos() {
		return posVacia+1;
	}
	
	public void visualizarVector () {
		for (int i = 0; i <= posVacia; i++) {
			System.out.print("v["+i+"]="+enteros[i]);
			if (i!=posVacia) {
				System.out.print(",");
			}
		}
	}
	
	public boolean estaCompleto() {
		if (posVacia==enteros.length) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean estaOrdenado() {
		if (posVacia<=1) {
			return true;
		}
		for (int i = 1; i<enteros.length;i++) {
			if (enteros[i]>enteros[i+1]) {
				return false;
			}
		}
		return true;
	}
	//TODO: boolean estaOrdenado que almacene si el vector esta ordenado.
	public int buscar(int num) {
		if (estaOrdenado()) {
			for (int i = 0; i < enteros.length;i++) {
				if (num==enteros[i]) {
					return i;
				}
				if (num<enteros[i]) {
					return -1;
				}
			}
			return -1;
		} 
		
		for (int i = 0; i < enteros.length;i++) {
			if (num==enteros[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public double media() {
		double suma = 0.0;
		for (int i= 0; i< posVacia; i++) {
			suma += enteros[i];
		}
		return suma/posVacia;
	}
	
	public int sumaIndicePar () {
		int suma= 0;
		for (int i = 0; i < posVacia; i+=2) {
			suma += enteros[i];
		}
		return suma;
	}
	
	public int sumaIndiceImpar () {
		int suma= 0;
		for (int i = 1; i < posVacia; i+=2) {
			suma += enteros[i];
		}
		return suma;
	}
	
	public int sumaPares() {
		int suma= 0;
		for (int i = 0; i < posVacia; i++) {
			if (enteros[i]%2==0) {
				suma += enteros[i];
			}
		}
		return suma;
	}
	
	public int sumaImpares() {
		int suma= 0;
		for (int i = 0; i < posVacia; i++) {
			if (enteros[i]%2==1) {
				suma += enteros[i];
			}
		}
		return suma;
	}
	
	public void invertir () {
		for (int i = 0; i < posVacia; i++) {
			enteros[i]*=-1;
		}
	}
	
	public boolean aniadir (int elemento) {
		if (!estaCompleto()) {
			enteros[posVacia] = elemento;
			posVacia++;
		}
		return false;
	}
	
	
	
	public void eliminarUltimos (int numElementos) {
		for (int i = posVacia-1; i < (posVacia-numElementos);i--) {
			enteros[i]=0;
			if (posVacia>0) {
				posVacia--;
			}
		}
	}
	
	public boolean eliminar (int indice) {
		if (indice >= posVacia) {
			return false;
		}
		for (int i = indice; i < posVacia;i++) {
			if (i == posVacia-1) {
				enteros[i]=0;
				posVacia--;
			}
			enteros[i]=enteros[i+1];
		}
		return true;
		
	}
	
	public int obtener(int indice) {
		if (indice>=enteros.length) {
			System.out.println("Indice indicado esta fuera de rango.");
			return Integer.MIN_VALUE;
		}
		if (indice>=posVacia) {
			System.out.println("La posición en indice esta vacia");
			return Integer.MIN_VALUE;
		}
		return enteros[indice];
	}
	
	public int maximo() {
		if (posVacia==0) {
			return Integer.MIN_VALUE;
		}
		int maximo = enteros[0];
		for (int i = 0; i<posVacia;i++) {
			if (enteros[i]>maximo) {
				maximo = enteros[i];
			}
		}
		return maximo;
	}
	public int minimo() {
		if (posVacia==0) {
			return Integer.MAX_VALUE;
		}
		int minimo = enteros[0];
		for (int i = 0; i<posVacia;i++) {
			if (enteros[i]<minimo) {
				minimo = enteros[i];
			}
		}
		return minimo;
	}
	
	public void ordenaMenorMayor() {

		/*
		 * Cocktail sort restricted
		 * leemos de izq a der si el siguiente es menor intercambiamos valores
		 * queda el mayor al final, quitamos el ultimo del for para no volver a pasar.
		 * luego leemos de derecha a izquierda si es mayor que el anterior intercambiamos
		 * queda el menor al principio, quitamos ese del for.
		 * 
		 */ 	
		if (estaOrdenado()) {
			return;
		}
		
		int aux;
		int pasadas = 0;
		int intercambios;
		while (true) {
			intercambios = 0;
			for (int i=0+pasadas;i<posVacia-1-pasadas;i++) {
				if (enteros[i]>enteros[i+1]) {
					aux = enteros[i];
					enteros[i]= enteros[i+1];
					enteros[i+1]=aux;
					intercambios++;
				}
			}
			if (intercambios == 0) {
				return;
			}
			intercambios = 0;
			for (int i=posVacia-1-pasadas;i>0+pasadas;i--) {
				if (enteros[i]<enteros[i-1]) {
					aux = enteros[i];
					enteros[i]= enteros[i-1];
					enteros[i-1]=aux;
					intercambios++;
				}
			}
			pasadas++;
			if (intercambios == 0) {
				return;
			}
		}
	}
	
	public void insertar (int elemento) {
		if (estaCompleto()) {
			System.out.println("El vector esta lleno. No se puede insertar un valor.");
			return;
		}
		if(estaOrdenado()) {
			int aux;
			for (int i = 0; i < posVacia+1;i++) {
				if (i == posVacia) {
					enteros[i]=elemento;
					continue;
				}
				if (enteros[i]< elemento) {
					continue;
				}
				aux = enteros[i];
				enteros[i]=elemento;
				elemento = aux;
			}
		} else {
			enteros[posVacia] = elemento;
		}
		posVacia++;
	}
	
	public void borrar (int elemento) {
		int posNueva=0;
		for (int i = 0; i < posVacia;i++) {
			if (enteros[i]==elemento) {
				continue;
			}
			enteros[posNueva]=enteros[i];
			posNueva++;
		}
		posVacia = posNueva;
		
	}
	 
	
}
