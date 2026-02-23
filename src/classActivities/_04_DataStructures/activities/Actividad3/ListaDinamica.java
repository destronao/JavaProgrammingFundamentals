package classActivities._04_DataStructures.activities.Actividad3;

import java.util.ArrayList;
import java.util.Random;

import classActivities._04_DataStructures.activities.actividad1.Orden;

/**
 * Implementa una lista dinámica de enteros basada en {@link ArrayList}.
 * Permite operaciones típicas como obtener, modificar, insertar, eliminar,
 * copiar, borrar por valor y ordenar.
 */
public class ListaDinamica {

    /** Lista interna de enteros. Solo accesible desde la propia clase. */
	private ArrayList<Integer> lista;

    /** Indica el orden actual (si se usa en la actividad). */
	private Orden orden;
	
	/**
     * Construye una lista dinámica con un tamaño inicial.
     * Inicializa todas las posiciones con valores aleatorios entre 0 y 200 (ambos incluidos).
     *
     * @param tamaño tamaño inicial de la lista.
     */
	public ListaDinamica (int tamaño){
		lista = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < tamaño; i++) {
			lista.add(r.nextInt(201));
		}
	}
	
	/**
     * Valida si un índice es válido para operaciones que requieren un elemento existente.
     * Se considera válido si {@code 0 <= indice < size()}.
     *
     * @param indice índice a validar.
     * @return {@code true} si el índice es válido; {@code false} en caso contrario.
     */
	private boolean validateIndex(int indice) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
     * Retorna el valor almacenado en el índice indicado.
     * Si el índice está fuera de rango, retorna {@link Integer#MIN_VALUE}.
     *
     * @param indice índice del elemento a obtener.
     * @return valor del índice o {@link Integer#MIN_VALUE} si el índice no es válido.
     */
	public Integer obtener (int indice) {
		if (validateIndex(indice)) {
			return lista.get(indice);
		} else {
			return Integer.MIN_VALUE;
		}
	}

	/**
     * Modifica el valor almacenado en el índice indicado.
     * Debe mostrarse un mensaje aclaratorio indicando si se ha podido modificar.
     *
     * @param indice índice a modificar.
     * @param nuevoValor nuevo valor a establecer.
     * @return {@code true} si se modifica; {@code false} si el índice no es válido.
     */
	public boolean modificar (int indice, Integer nuevoValor) {
		if (validateIndex(indice)) {
			lista.set(indice, nuevoValor);
			return true;
		}
		return false;
	}
	
	/**
     * Muestra el contenido de la lista usando un bucle {@code for} tradicional.
     */
	public void contenidoTradicional() {
		for (int i = 0; i < lista.size();i++) {
			System.out.print("l["+i+"]= "+ lista.get(i));
			if (i != lista.size()-1) {
				System.out.print(", ");
			} else {
				System.out.println(";");
			}
		}
	}
	
	/**
     * Muestra el contenido de la lista usando un bucle {@code foreach}.
     */
	public void contenidoRecomendable() {
		int i = 0;
		for (Integer numero : lista) {
			System.out.print("l["+i+"]= "+ numero);
			if (i != lista.size()-1) {
				System.out.print(", ");
			} else {
				System.out.println(";");
			}
			i++;
		}
	}
	
	/**
     * Elimina el elemento ubicado en el índice indicado si es posible.
     * Debe mostrarse un mensaje aclaratorio indicando si se ha eliminado o no.
     *
     * @param indice índice del elemento a eliminar.
     * @return {@code true} si se elimina; {@code false} si el índice no es válido.
     */
	public boolean eliminar (int indice) {
		if (validateIndex(indice)) {
			System.out.println("Entrada eliminada de la lista");
			lista.remove(indice);
			return true;
		}
		System.out.println("No se pudo eliminar la entrada."
				+ "\nIndice no encontrado.");
		return false;
	}
	
	/**
     * Elimina la primera ocurrencia del valor indicado si existe.
     * Debe mostrarse un mensaje aclaratorio indicando si se ha eliminado o no.
     *
     * @param valor valor a eliminar (primera ocurrencia).
     * @return {@code true} si se eliminó alguna ocurrencia; {@code false} si no existía.
     */
	public boolean eliminar (Integer valor) {
		boolean eliminado = lista.remove(valor);
		String mensaje = eliminado?
				"Entrada eliminada de la lista":
					"No se pudo eliminar la entrada";
		System.out.println(mensaje);
		return eliminado;
	}
	
	/**
     * Inserta un elemento al final de la lista.
     *
     * @param valor valor a insertar.
     * @return {@code true} si se inserta correctamente.
     */
	public boolean insertar (Integer valor) {
		return lista.add(valor);
	}
	
	/**
     * Inserta un elemento en el índice indicado si es posible; si no, lo añade al final.
     * Para insertar en un {@link ArrayList}, se acepta {@code 0 <= indice <= size()}.
     *
     * @param indice posición en la que se intenta insertar.
     * @param valor valor a insertar.
     * @return {@code true} si se inserta (ya sea en el índice o al final).
     */
	public boolean insertar (int indice, Integer valor) {
		if (validateIndex(indice)) {
			lista.add(indice,valor);
		} else {
			insertar(valor);
		}
		return true;
	}
	
	/**
     * Copia todos los elementos de la lista proporcionada dentro de la lista interna.
     * Si la lista interna tuviese elementos, se borran previamente.
     *
     * @param listaExterna lista desde la cual se copian elementos.
     * @return {@code true} si se copia; {@code false} si {@code listaExterna} es {@code null}.
     */
	public boolean copiar(ArrayList<Integer> listaExterna) {
		this.lista.clear();
		return this.lista.addAll(listaExterna);
	}
	
	/**
     * Elimina todas las ocurrencias del valor indicado.
     *
     * @param valor valor a eliminar.
     * @return {@code true} si se eliminó al menos una ocurrencia; {@code false} en caso contrario.
     */
	public boolean borrarTodos(Integer valor) {
		return lista.removeIf(numero -> numero.equals(valor));
	}
	
	/**
     * Ordena la lista de menor a mayor.
     *
     * @return {@code true} si se ha ejecutado la ordenación.
     */
	public boolean ordenar() {
		lista.sort(Integer::compare);
		return true;
	}
	
	/**
     * Retorna el número de elementos actuales en la lista.
     *
     * @return tamaño de la lista.
     */
	public int size() {
		return lista.size();
	}
	
}
