package classActivities._04_DataStructures.activities.actividad1;

/**
 * Enumeración que representa el tipo de ordenación
 * que puede aplicarse a una estructura de datos.
 * 
 * <ul>
 *   <li>{@link #NONE} → Sin orden específico.</li>
 *   <li>{@link #ASC} → Orden ascendente (de menor a mayor).</li>
 *   <li>{@link #DESC} → Orden descendente (de mayor a menor).</li>
 * </ul>
 */
public enum Orden {

    /** Indica que no se ha aplicado ningún tipo de ordenación. */
    NONE,

    /** Indica orden ascendente (de menor a mayor). */
    ASC,

    /** Indica orden descendente (de mayor a menor). */
    DESC
}
