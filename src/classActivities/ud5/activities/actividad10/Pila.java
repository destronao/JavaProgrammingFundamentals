package classActivities.ud5.activities.actividad10;

/**
 * Interfaz que define el comportamiento de una estructura de datos tipo
 * <strong>Pila (LIFO - Last In, First Out)</strong>.
 * <p>
 * En una pila, el último elemento insertado es el primero en ser extraído.
 * </p>
 * <p>
 * Las implementaciones pueden tener capacidad limitada o ilimitada.
 * </p>
 */
public interface Pila {

    /**
     * Inserta un elemento en el tope de la pila.
     *
     * @param o objeto que se desea insertar.
     *          Puede ser cualquier tipo de objeto.
     */
    public void insertar(Object o);

    /**
     * Extrae y devuelve el elemento situado en el tope de la pila.
     *
     * @return el objeto situado en el tope,
     *         o {@code null} si la pila está vacía.
     */
    public Object quitar();

    /**
     * Indica si la pila no contiene elementos.
     *
     * @return {@code true} si la pila está vacía,
     *         {@code false} en caso contrario.
     */
    public boolean pilaVacia();

    /**
     * Indica si la pila ha alcanzado su capacidad máxima.
     * <p>
     * En implementaciones sin límite de capacidad,
     * este método puede devolver siempre {@code false}.
     * </p>
     *
     * @return {@code true} si la pila está llena,
     *         {@code false} en caso contrario.
     */
    public boolean pilaLlena();

    /**
     * Elimina todos los elementos de la pila,
     * dejándola en estado vacío.
     */
    public void limpiarPila();

    /**
     * Devuelve el número actual de elementos almacenados en la pila.
     *
     * @return cantidad de elementos contenidos en la pila.
     */
    public int tamañoPila();
}
