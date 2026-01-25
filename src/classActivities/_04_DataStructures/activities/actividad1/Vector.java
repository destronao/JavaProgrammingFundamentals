package classActivities._04_DataStructures.activities.actividad1;

import java.util.Random;

/**
 * Implementa un vector de enteros de tamaño fijo.
 *
 * <p>El vector se gestiona de forma lógica mediante {@code posVacia}, que indica el índice de la
 * primera posición libre. Por tanto, los elementos válidos están en el rango {@code [0, posVacia)}.</p>
 *
 * <p>La propiedad {@code orden} indica el estado de ordenación del contenido lógico del vector:
 * ASC (ascendente), DESC (descendente) o NONE (sin orden garantizado).</p>
 */
public class Vector {
	private int[] enteros;
	private int posVacia;
	private Orden orden;
	
	
	/**
	 * Crea un vector de tamaño fijo y lo inicializa con valores aleatorios.
	 *
	 * <p>Tras la construcción, el vector queda completamente ocupado y el estado de orden se establece en
	 * {@link Orden#NONE}.</p>
	 *
	 * @param tamaño capacidad del vector (número máximo de elementos que puede almacenar)
	 * @throws IllegalArgumentException si tamaño <= 0
	 */
	Vector (int tamaño){
		if (tamaño > 0 ) {
			enteros = new int[tamaño];
			posVacia = 0;
			this.rellenar();
			orden = Orden.NONE;
		} else {
			throw new IllegalArgumentException();
		}
	} 
	
	/**
	 * Rellena las posiciones no ocupadas del vector con valores aleatorios entre 0 y 20 (ambos inclusive).
	 *
	 * <p>Si existen posiciones libres, el contenido deja de considerarse ordenado y el estado de orden
	 * pasa a {@link Orden#NONE}.</p>
	 *
	 * <p>Si el vector está completo, no se realizan cambios.</p>
	 */
	public void rellenar() {
		if (!estaCompleto()) {
			orden = Orden.NONE;
			
			Random random = new Random();
			for (int i=posVacia;i < enteros.length;i++) {
				enteros[i] = random.nextInt(21);
				posVacia++;
			}
		}
	}
	
	/**
	 * Vacía el vector de forma lógica, permitiendo reescribir sus elementos.
	 *
	 * <p>No borra físicamente el array; únicamente reinicia {@code posVacia} y establece el estado de orden
	 * en {@link Orden#NONE}.</p>
	 */
	public void vaciar() {
		posVacia = 0;
		orden = Orden.NONE;
	}
	/**
	 * Devuelve el número de elementos almacenados actualmente en el vector.
	 *
	 * <p>Equivale al índice de la primera posición libre ({@code posVacia}).</p>
	 *
	 * @return número de elementos almacenados en el vector
	 */
	public int numeroElementos() {
		return posVacia;
	}
	
	/**
	 * Muestra por consola los elementos almacenados en el vector.
	 *
	 * <p>Formato de salida (ejemplo para vector={1,2,3,4,5}):</p>
	 * <pre>
	 * v[0]=1,v[1]=2,v[2]=3,v[3]=4,v[4]=5
	 * </pre>
	 *
	 * <p>Si el vector está vacío, muestra el mensaje {@code "Vector vacio"}.</p>
	 */
	public void visualizarVector () {
		for (int i = 0; i < posVacia; i++) {
			System.out.print("v["+i+"]="+enteros[i]);
			if (i!=posVacia-1) {
				System.out.print(",");
			} else {
				System.out.println("");
			}
		}
		if (estaVacio()) {
			System.out.println("Vector vacio");
		}
	}
	/**
	 * Indica si el vector está completo.
	 *
	 * @return {@code true} si no quedan posiciones libres (posVacia == capacidad), {@code false} en caso contrario
	 */
	public boolean estaCompleto() {
		if (posVacia==enteros.length) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Indica si el vector está vacío (sin elementos almacenados).
	 *
	 * @return {@code true} si no hay elementos (posVacia == 0), {@code false} en caso contrario
	 */
	public boolean estaVacio() {
		if (posVacia==0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Comprueba si el vector lógico está ordenado y actualiza el estado {@code orden}.
	 *
	 * <p>Se considera ordenado si es no decreciente (ASC) o no creciente (DESC). Se permiten valores repetidos.</p>
	 *
	 * @return {@code true} si está ordenado ascendente o descendente; {@code false} si no hay orden
	 */
	public boolean estaOrdenado() {
	    if (posVacia <= 1) {
	        orden = Orden.ASC;
	        return true;
	    }

	    boolean asc = true;
	    boolean desc = true;

	    for (int i = 1; i < posVacia; i++) {
	        if (enteros[i - 1] > enteros[i]) {
	            asc = false;
	        }
	        if (enteros[i - 1] < enteros[i]) {
	            desc = false;
	        }

	        if (!asc && !desc) {
	            orden = Orden.NONE;
	            return false;
	        }
	    }

	    if (asc) {
	        orden = Orden.ASC;
	        return true;
	    }
	    orden = Orden.DESC;
	    return true;
	}
	
	/**
	 * Busca un valor en el vector y devuelve el índice de su primera aparición.
	 *
	 * <p>Si el estado de orden es {@link Orden#ASC} o {@link Orden#DESC}, la búsqueda puede finalizar
	 * anticipadamente al detectar que el valor no puede aparecer más adelante.</p>
	 *
	 * @param num valor a buscar
	 * @return índice de la primera coincidencia; -1 si no se encuentra
	 */
	public int buscar(int num) {
		if (orden == Orden.ASC) {
			for (int i = 0; i < posVacia;i++) {
				if (num==enteros[i]) {
					return i;
				}
				if (num<enteros[i]) {
					return -1;
				}
			}
			return -1;
		} 
		if (orden == Orden.DESC) {
			for (int i = 0; i < posVacia;i++) {
				if (num==enteros[i]) {
					return i;
				}
				if (num>enteros[i]) {
					return -1;
				}
			}
			return -1;
		}
		for (int i = 0; i < posVacia;i++) {
			if (num==enteros[i]) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Calcula la media aritmética de los elementos almacenados en el vector.
	 *
	 * @return media aritmética de los elementos, si esta vacio retorna 0.0
	 */
	public double media() {
		if (estaVacio()) {
			return 0.0;
		}
		double suma = 0.0;
		for (int i= 0; i< posVacia; i++) {
			suma += enteros[i];
		}
		return suma/posVacia;
	}
	
	/**
	 * Suma los elementos almacenados en posiciones de índice par (0, 2, 4, ...).
	 *
	 * @return suma de los elementos en índices pares del rango {@code [0, posVacia)}
	 */
	public int sumaIndicePar () {
		int suma= 0;
		for (int i = 0; i < posVacia; i+=2) {
			suma += enteros[i];
		}
		return suma;
	}
	/**
	 * Suma los elementos almacenados en posiciones de índice impar (1, 3, 5, ...).
	 *
	 * @return suma de los elementos en índices impares del rango {@code [0, posVacia)}
	 */
	public int sumaIndiceImpar () {
		int suma= 0;
		for (int i = 1; i < posVacia; i+=2) {
			suma += enteros[i];
		}
		return suma;
	}
	/**
	 * Suma los elementos almacenados cuyo valor es par.
	 *
	 * @return suma de los elementos pares del vector lógico
	 */
	public int sumaPares() {
		int suma= 0;
		for (int i = 0; i < posVacia; i++) {
			if (enteros[i]%2==0) {
				suma += enteros[i];
			}
		}
		return suma;
	}
	/**
	 * Suma los elementos almacenados cuyo valor es impar.
	 *
	 * @return suma de los elementos impares del vector lógico
	 */
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
		int aux;
		for (int i = 0; i < posVacia/2; i++) {
			int j = posVacia -1 - i;
			aux = enteros[i];
			enteros[i]=enteros[j];
			enteros[j]= aux;
		}
		if (orden == Orden.ASC) {
			orden = Orden.DESC;
		}
		else if (orden == Orden.DESC) {
			orden = Orden.ASC;
		}
	}
	/**
	 * Añade un elemento al final del vector (en la siguiente posición libre).
	 *
	 * @param elemento valor a añadir
	 * @return {@code true} si se añadió correctamente; {@code false} si el vector estaba completo
	 */
	public boolean aniadir (int elemento) {
		if (!estaCompleto()) {
			enteros[posVacia] = elemento;
			posVacia++;
			return true;
		}
		return false;
	}
	
	
	/**
	 * Elimina lógicamente los últimos {@code numElementos} elementos almacenados.
	 *
	 * <p>Reduce {@code posVacia} y deja disponibles esas posiciones para futuras inserciones.</p>
	 *
	 * @param numElementos número de elementos a eliminar desde el final
	 */
	public void eliminarUltimos (int numElementos) {
		for (int i = posVacia-1; i >= (posVacia-numElementos);i--) {
			if (!estaVacio()) {
				enteros[i]=0;
			}
		}
		posVacia-=numElementos;
	}
	
	/**
	 * Elimina el elemento situado en el índice indicado, desplazando a la izquierda los elementos posteriores.
	 *
	 * @param indice posición del elemento a eliminar dentro del rango {@code [0, posVacia)}
	 * @return {@code true} si el índice era válido y se eliminó; {@code false} si el índice no corresponde a un elemento almacenado
	 */
	public boolean eliminar (int indice) {
		if (indice >= posVacia) {
			return false;
		}
		for (int i = indice; i < posVacia;i++) {
			if (i == posVacia-1) {
				enteros[i]=0;
				posVacia--;
			} else {
				enteros[i]=enteros[i+1];
			}
		}
		return true;
		
	}
	/**
	 * Devuelve el elemento almacenado en el índice indicado.
	 *
	 * <p>Si el índice está fuera de rango o apunta a una posición no ocupada, muestra un mensaje por consola
	 * y devuelve {@link Integer#MIN_VALUE} como valor centinela.</p>
	 *
	 * @param indice índice a consultar
	 * @return valor almacenado o {@link Integer#MIN_VALUE} si el índice no es válido
	 */
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
	/**
	 * Devuelve el valor máximo del vector lógico.
	 *
	 * @return máximo valor almacenado; {@link Integer#MIN_VALUE} si el vector está vacío
	 */
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
	/**
	 * Devuelve el valor mínimo del vector lógico.
	 *
	 * @return mínimo valor almacenado; {@link Integer#MAX_VALUE} si el vector está vacío
	 */
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
	/**
	 * Ordena los elementos almacenados en orden ascendente (menor a mayor).
	 *
	 * <p>Solo se ordena el rango lógico {@code [0, posVacia)}.</p>
	 */
	public void ordenaMenorMayor() {	
		if (orden == Orden.ASC) {
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
				orden = Orden.ASC;
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
				orden = Orden.ASC;
				return;
			}
		}
	}
	/**
	 * Ordena los elementos almacenados en orden descendente (mayor a menor).
	 *
	 * <p>Solo se ordena el rango lógico {@code [0, posVacia)}.</p>
	 */
	public void ordenaMayorMenor() {	
		if (orden == Orden.DESC) {
			return;
		}
		if (orden == Orden.ASC) {
			invertir();
			return;
		}
		
		int aux;
		int pasadas = 0;
		int intercambios;
		while (true) {
			intercambios = 0;
			for (int i=0+pasadas;i<posVacia-1-pasadas;i++) {
				if (enteros[i]<enteros[i+1]) {
					aux = enteros[i];
					enteros[i]= enteros[i+1];
					enteros[i+1]=aux;
					intercambios++;
				}
			}
			if (intercambios == 0) {
				orden = Orden.DESC;
				return;
			}
			intercambios = 0;
			for (int i=posVacia-1-pasadas;i>0+pasadas;i--) {
				if (enteros[i]>enteros[i-1]) {
					aux = enteros[i];
					enteros[i]= enteros[i-1];
					enteros[i-1]=aux;
					intercambios++;
				}
			}
			pasadas++;
			if (intercambios == 0) {
				orden = Orden.DESC;
				return;
			}
		}
	}
	/**
	 * Inserta un elemento en el vector.
	 *
	 * <p>Si el estado es {@link Orden#ASC}, inserta manteniendo el orden ascendente (desplazando elementos).
	 * En cualquier otro caso, añade el elemento al final.</p>
	 *
	 * @param elemento valor a insertar
	 */
	public void insertar (int elemento) {
		if (estaCompleto()) {
			System.out.println("El vector esta lleno. No se puede insertar un valor.");
			return;
		}
		if(orden == Orden.ASC) {
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
		} else if (orden == Orden.DESC) {
			int aux;
			for (int i = 0; i < posVacia+1;i++) {
				if (i == posVacia) {
					enteros[i]=elemento;
					continue;
				}
				if (enteros[i]>elemento) {
					aux = enteros[i];
					enteros[i]=elemento;
					elemento = aux;
				}
			}
		
		} else {
			enteros[posVacia] = elemento;
		}
		posVacia++;
	}
	/**
	 * Elimina todas las apariciones del valor indicado del vector lógico.
	 *
	 * <p>Compacta el array desplazando los elementos no eliminados y actualiza {@code posVacia}.</p>
	 *
	 * @param elemento valor a eliminar
	 */
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
	public Orden getOrden() {
	    return orden;
	}
	
}
