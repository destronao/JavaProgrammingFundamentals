package classActivities.ud4.activities.actividad2;

import java.util.Random;

import classActivities.ud4.activities.actividad1.Orden;
import classActivities.ud4.activities.actividad1.Vector;

/**
 * Implementa una tabla (matriz) de enteros de tamaño fijo con gestión lógica de ocupación.
 *
 * <p>La ocupación se controla mediante {@code filaVacia} y {@code columnaVacia}, que indican la
 * primera posición libre en orden fila-columna. Por tanto, los elementos válidos son los que
 * quedarían al recorrer la tabla de izquierda a derecha y de arriba a abajo hasta esa posición.</p>
 *
 * <p>El estado {@code orden} indica si el contenido lógico está ordenado: {@link Orden#ASC},
 * {@link Orden#DESC} o {@link Orden#NONE}.</p>
 */
public class Tabla {
	private int[][] tabla;
	private int filaVacia;
	private int columnaVacia;
	private Orden orden;
	
	/**
	 * Construye una tabla de tamaño {@code filas} × {@code columnas} y la rellena con valores aleatorios.
	 *
	 * <p>Tras la construcción, la tabla queda completamente ocupada y el estado de orden se establece en
	 * {@link Orden#NONE}.</p>
	 *
	 * @param filas número de filas (debe ser > 0)
	 * @param columnas número de columnas (debe ser > 0)
	 * @throws IllegalArgumentException si {@code filas <= 0} o {@code columnas <= 0}
	 */
	Tabla (int filas, int columnas){
		validateFilas(filas);
		validateColumnas(columnas);
		tabla = new int[filas][columnas];
		filaVacia = 0;
		columnaVacia = 0;
		rellenar();
		orden = Orden.NONE;
	}
	/**
	 * Construye una tabla de tamaño {@code filas} × {@code columnas} e inicializa su contenido a partir de un {@link Vector}.
	 *
	 * <p>Se copian elementos del vector en orden (de izquierda a derecha y de arriba a abajo) hasta que
	 * se llena la tabla o se consumen los elementos del vector.</p>
	 *
	 * @param filas número de filas (debe ser > 0)
	 * @param columnas número de columnas (debe ser > 0)
	 * @param vector origen de los valores a copiar (no {@code null})
	 * @throws IllegalArgumentException si {@code filas <= 0} o {@code columnas <= 0}
	 * @throws NullPointerException si {@code vector} es {@code null}
	 */
	Tabla (int filas, int columnas, Vector vector){
		validateFilas(filas);
		validateColumnas(columnas);
		tabla = new int[filas][columnas];
		filaVacia = 0;
		columnaVacia = 0;
		rellenar(vector);
	}

	private void validateColumnas(int columnas) {
		if (columnas <= 0 ) {
			throw new IllegalArgumentException("No puedes crear una tabla con columnas negativas");
		}
	}

	private void validateFilas(int filas) {
		if (filas <= 0 ) {
			throw new IllegalArgumentException("No puedes crear una tabla con filas negativas");
		}
	}
	
	/**
	 * Rellena las posiciones no ocupadas de la tabla con valores aleatorios entre 0 y 100 (ambos inclusive).
	 *
	 * <p>Si existen posiciones libres, el contenido deja de considerarse ordenado y el estado pasa a {@link Orden#NONE}.</p>
	 *
	 * <p>Si la tabla está completa, no se realizan cambios.</p>
	 */
	public void rellenar() {
		if (estaCompleto()) {
			return;
		}

		Random random = new Random();
		for (int i = filaVacia; i < tabla.length; i++) {
			for (int j = columnaVacia; j < tabla[0].length; j++) {
				tabla[i][j] = random.nextInt(101);
				columnaVacia++;
			}
			columnaVacia=0;
			filaVacia++;
		}
	}
	
	/**
	 * Rellena las posiciones no ocupadas de la tabla copiando valores desde un {@link Vector}.
	 *
	 * <p>Los valores se copian en orden (fila-columna) empezando en la primera posición libre.
	 * Se detiene cuando se llena la tabla o cuando se han copiado todos los elementos del vector.</p>
	 *
	 * <p>No garantiza mantener el orden actual, por lo que el estado pasa a {@link Orden#NONE} si se escriben elementos.</p>
	 *
	 * @param vector vector origen de los valores (no {@code null})
	 * @throws NullPointerException si {@code vector} es {@code null}
	 */
	public void rellenar(Vector vector) {
		if (estaCompleto()) {
			return;
		}
		
		for (int i = filaVacia; i < tabla.length; i++) {
			for (int j = columnaVacia; j < tabla[0].length; j++) {
				if (numeroElementos() == vector.numeroElementos()) {
					return;
				}
				tabla[i][j] = vector.getValue(numeroElementos());
				columnaVacia++;
				
			}
			columnaVacia=0;
			filaVacia++;
		}
	}
	
	/**
	 * Muestra por consola los elementos almacenados en la tabla (rango lógico).
	 *
	 * <p>Formato de salida:</p>
	 * <pre>
	 * t[0][0]=..., t[0][1]=..., ...;
	 * t[1][0]=..., t[1][1]=..., ...;
	 * </pre>
	 *
	 * <p>Si la tabla está vacía, muestra {@code "Tabla Vacia"}.</p>
	 */
	public void visualizarTabla() {
		if (estaVacio()) {
			System.out.println("Tabla Vacia");
		} else {
			
			for (int i = 0; i <= filaVacia; i++) {
				if (i == tabla.length) {
					break;
				}
				if (i < filaVacia) {
					for (int j = 0; j < tabla[0].length; j++) {
						printFilaColumna(i, j);
					}
				} else {
					for (int j = 0; j < columnaVacia; j++) {
						printFilaColumna(i, j);
					}
				}
			}
		}
	}

	private void printFilaColumna(int i, int j) {
		System.out.print("t["+i+"]["+j+"] = "+ tabla[i][j]);
		if (j ==  tabla[0].length-1) {
			
			System.out.println(";");
		} else if (i == filaVacia && j == columnaVacia-1) {

			System.out.println(";");
		} else {
			System.out.print(", ");
		}
	}
	
	/**
	 * Busca un valor en la tabla (rango lógico) y devuelve la posición de su primera aparición.
	 *
	 * @param numero valor a buscar
	 * @return posición de la primera coincidencia; {@code (-1,-1)} si no se encuentra
	 */
	public Position buscar(int numero) {
		int fila;
		int columna;
		
		for (int i = 0; i < filaVacia; i++) {
			if (i != filaVacia-1) {
				for (int j = 0; j < tabla[0].length; j++) {
					if (tabla[i][j]==numero) {
						fila = i;
						columna = j;
						
						Position posicion = new Position(fila,columna);
						return posicion;
					}
				}
			} else {
				for (int j = 0; j < columnaVacia; j++) {
					if (tabla[i][j]==numero) {
						fila = i;
						columna = j;
						
						Position posicion = new Position(fila,columna);
						return posicion;
					}
				}
			}
			
		}
		Position posicion = new Position(-1,-1);
		return posicion;
	}
	
	/**
	 * Calcula la media aritmética de los elementos almacenados (rango lógico).
	 *
	 * @return media aritmética; si la tabla está vacía devuelve {@code 0.0}
	 */
	public double media () {
		int suma = 0;
		double media;
		for (int i = 0; i < filaVacia; i++) {
			if (i != filaVacia-1) {
				for (int j = 0; j < tabla[0].length; j++) {
					suma += tabla[i][j];
				}
			} else {
				for (int j = 0; j < columnaVacia; j++) {
					suma += tabla[i][j];
				}
			}
		}
		media = (double) suma / numeroElementos();
		return media;
	}
	/**
	 * Devuelve el valor almacenado en la posición indicada de la tabla.
	 *
	 * <p>La posición debe estar dentro de los límites físicos de la tabla
	 * (no necesariamente dentro del rango lógico de ocupación).</p>
	 *
	 * @param fila índice de fila
	 * @param columna índice de columna
	 * @return valor almacenado en la posición indicada
	 * @throws IndexOutOfBoundsException si la fila o columna están fuera de rango
	 */
	public int obtener (int fila, int columna) {
		if (columna < 0 || columna >= tabla[0].length) {
			throw new IndexOutOfBoundsException(
		            "Comlumna fuera de rango: " + columna
		        );
		}
		if (fila < 0 || fila >= tabla.length) {
			throw new IndexOutOfBoundsException(
		            "Fila fuera de rango: " + fila
		        );
		}
		return tabla[fila][columna];
	}
	/**
	 * Devuelve el número de elementos almacenados actualmente en la tabla (rango lógico).
	 *
	 * <p>El cálculo se realiza a partir de {@code filaVacia} y {@code columnaVacia},
	 * considerando que la tabla se rellena de izquierda a derecha y de arriba a abajo.</p>
	 *
	 * @return número total de elementos almacenados
	 */
	public int numeroElementos() {
		return ((filaVacia)*tabla[0].length) + columnaVacia;
	}
	/**
	 * Indica si la tabla está completa (sin posiciones libres).
	 *
	 * @return {@code true} si no quedan posiciones libres; {@code false} en caso contrario
	 */
	public boolean estaCompleto() {
		if (filaVacia != tabla.length) {
			return false;
		}
		return true;
	}
	/**
	 * Indica si la tabla está vacía (sin elementos almacenados).
	 *
	 * @return {@code true} si no hay elementos; {@code false} en caso contrario
	 */
	public boolean estaVacio() {
		if (filaVacia == 0) {
			if (columnaVacia == 0 ) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Vacía la tabla de forma lógica.
	 *
	 * <p>No elimina físicamente los valores del array, sino que reinicia
	 * {@code filaVacia} y {@code columnaVacia} a cero, dejando la tabla
	 * sin elementos almacenados.</p>
	 *
	 * <p>El estado de orden pasa a {@link Orden#NONE}.</p>
	 */
	public void vaciar() {
		filaVacia = 0;
		columnaVacia = 0;
	}
	/**
	 * Añade un elemento en la siguiente posición libre de la tabla,
	 * siguiendo el orden de relleno fila-columna.
	 *
	 * <p>Si la tabla está completa, no se realiza ninguna modificación.</p>
	 *
	 * <p>La inserción no garantiza mantener el orden actual,
	 * por lo que el estado pasa a {@link Orden#NONE}.</p>
	 *
	 * @param elemento valor a añadir
	 * @return {@code true} si el elemento se añadió correctamente;
	 *         {@code false} si la tabla estaba completa
	 */
	public boolean aniadir(int elemento) {
		if (estaCompleto()) {
			return false;
		}
		tabla[filaVacia][columnaVacia]= elemento;

		if (columnaVacia+1<tabla[0].length) {
			columnaVacia++;
		} else {
			filaVacia++;
			columnaVacia = 0;
		}
		return true;
	}
	/**
	 * Invierte el orden lógico de los elementos de la tabla.
	 *
	 * <p>La inversión se realiza convirtiendo la tabla en un {@link Vector},
	 * invirtiendo dicho vector y volviendo a rellenar la tabla.</p>
	 *
	 * <p>Si el estado era {@link Orden#ASC}, pasa a {@link Orden#DESC};
	 * si era {@link Orden#DESC}, pasa a {@link Orden#ASC}.
	 * En cualquier otro caso, el estado pasa a {@link Orden#NONE}.</p>
	 */
	public void invertir() {
		Vector v = toVector(Orden.NONE);
		vaciar();
		v.invertir();
		rellenar(v);
	}
	/**
	 * Ordena el contenido lógico de la tabla según el tipo de orden indicado.
	 *
	 * <p>La ordenación se realiza convirtiendo la tabla en un {@link Vector},
	 * aplicando el orden correspondiente y volviendo a rellenar la tabla.</p>
	 *
	 * @param orden tipo de orden deseado ({@link Orden#ASC} o {@link Orden#DESC})
	 */
	public void ordena(Orden orden) {
		if (orden == Orden.ASC) {
			ordenarAscendente();
			
		} else if (orden == Orden.DESC) {
			ordenarDescendente();
			
		}
		this.orden = orden;
		return;
		
	}
	
	private void ordenarAscendente() {
		if (orden == Orden.DESC) {
			invertir();
		} else {
			Vector v = toVector(Orden.ASC);
			vaciar();
			rellenar(v);
		}
	}
	
	private void ordenarDescendente() {
		if (orden == Orden.ASC) {
			invertir();
		} else {
			Vector v = toVector(Orden.DESC);
			vaciar();
			rellenar(v);
		}
	}
	
	/**
	 * Inserta un elemento en la tabla manteniendo el orden actual si es posible.
	 *
	 * <p>La tabla se convierte previamente en un {@link Vector} con capacidad
	 * suficiente para permitir la inserción (si no está completa).</p>
	 *
	 * <p>Si la tabla está completa, no se insertará el elemento.</p>
	 *
	 * @param elemento valor a insertar
	 * @return {@code true} si el elemento se insertó correctamente;
	 *         {@code false} si no pudo insertarse
	 */
	public boolean insertar(int elemento) {
		Vector v = toVectorInsert(orden);
		vaciar();
		boolean insertado = v.insertar(elemento);
		rellenar(v);
		return insertado;
	}
	/**
	 * Devuelve el estado de ordenación del contenido lógico.
	 *
	 * @return estado de orden actual
	 */
	public Orden getOrden() {
	    return orden;
	}
	/**
	 * Convierte el contenido lógico de la tabla en un {@link Vector}.
	 *
	 * <p>Los elementos se copian en el mismo orden de recorrido (fila-columna). El vector resultante
	 * puede ordenarse según el parámetro {@code orden}.</p>
	 *
	 * @param orden orden que se aplicará al vector resultante ({@link Orden#ASC}, {@link Orden#DESC} o {@link Orden#NONE})
	 * @return vector con los elementos actuales de la tabla
	 */
	public Vector toVector(Orden orden) {
		Vector v = new Vector(numeroElementos());
		v.vaciar();
		
		v.ordena(orden);
		
		for (int i = 0; i <= filaVacia; i++) {
			if (i == tabla.length) {
				break;
			}
			if (i < filaVacia) {
				for (int j = 0; j < tabla[0].length; j++) {
					v.insertar(tabla[i][j]);
				}
			} else {
				for (int j = 0; j < columnaVacia; j++) {
					v.insertar(tabla[i][j]);
				}
			}
		}
		
		return v;
	} 
	/**
	 * Convierte el contenido lógico de la tabla en un {@link Vector} preparado para una inserción.
	 *
	 * <p>Si la tabla no está completa, el vector se crea con capacidad {@code numeroElementos()+1} para
	 * permitir insertar un elemento adicional. Si está completa, se crea con capacidad {@code numeroElementos()}.</p>
	 *
	 * <p>Los elementos se copian en orden fila-columna y el vector puede ordenarse según {@code orden}.</p>
	 *
	 * @param orden orden que se aplicará al vector resultante ({@link Orden#ASC}, {@link Orden#DESC} o {@link Orden#NONE})
	 * @return vector con los elementos actuales y, si hay hueco, una posición libre adicional
	 */
	public Vector toVectorInsert(Orden orden) {
		Vector v;
		if (!estaCompleto()) {
			v = new Vector(numeroElementos() + 1);
		} else {
			v = new Vector(numeroElementos());
		}
		
		v.vaciar();
		
		v.ordena(orden);
		
		for (int i = 0; i <= filaVacia; i++) {
			if (i == tabla.length) {
				break;
			}
			if (i < filaVacia) {
				for (int j = 0; j < tabla[0].length; j++) {
					v.insertar(tabla[i][j]);
				}
			} else {
				for (int j = 0; j < columnaVacia; j++) {
					v.insertar(tabla[i][j]);
				}
			}
		}
		
		return v;
	} 
	
}
