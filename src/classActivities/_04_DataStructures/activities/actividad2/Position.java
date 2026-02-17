package classActivities._04_DataStructures.activities.actividad2;

public class Position {
	private int fila;
	private int columna;
	
	public Position (int fila, int columna) {
		if (fila <-1) {
			throw new IllegalArgumentException("No puede ser una posicion negativa.");
		}
		if (columna <-1) {
			throw new IllegalArgumentException("No puede ser una posicion negativa.");
		}
		this.fila = fila;
		this.columna = columna;
	}
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public void mostrarPosicion() {
		if (fila == -1 || columna == -1) {
			System.out.println("No existe.");
			return;
		}
		System.out.println("Fila: " + fila +"\n"
				+ "Columna: " + columna);
	}
	
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
