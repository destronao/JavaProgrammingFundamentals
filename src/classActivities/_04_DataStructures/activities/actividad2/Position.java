package classActivities._04_DataStructures.activities.actividad2;

/**
 * Representa una posición dentro de una tabla bidimensional,
 * definida por una fila y una columna.
 * 
 * Una posición con valor -1 en fila o columna puede utilizarse
 * como indicador de que no existe una posición válida.
 */
public class Position {

    /** Número de fila de la posición. */
    private int fila;

    /** Número de columna de la posición. */
    private int columna;

    /**
     * Construye una nueva posición con los valores indicados.
     * 
     * @param fila número de fila.
     * @param columna número de columna.
     * @throws IllegalArgumentException si fila o columna son menores que -1.
     */
    public Position(int fila, int columna) {
        if (fila < -1) {
            throw new IllegalArgumentException("No puede ser una posicion negativa.");
        }
        if (columna < -1) {
            throw new IllegalArgumentException("No puede ser una posicion negativa.");
        }
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Retorna el valor de la fila.
     *
     * @return número de fila.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Establece el valor de la fila.
     *
     * @param fila nuevo valor de la fila.
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Retorna el valor de la columna.
     *
     * @return número de columna.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Establece el valor de la columna.
     *
     * @param columna nuevo valor de la columna.
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Muestra por consola la posición actual.
     * Si la fila o la columna son -1, indica que la posición no existe.
     */
    public void mostrarPosicion() {
        if (fila == -1 || columna == -1) {
            System.out.println("No existe.");
            return;
        }
        System.out.println("Fila: " + fila + "\n"
                + "Columna: " + columna);
    }

    /**
     * Compara esta posición con otra posición.
     * 
     * @param pos posición a comparar.
     * @return {@code true} si ambas posiciones tienen la misma fila y columna;
     *         {@code false} en caso contrario.
     */
    public boolean equals(Position pos) {
        if (fila != pos.getFila()) {
            return false;
        }
        if (columna != pos.getColumna()) {
            return false;
        }
        return true;
    }
}
