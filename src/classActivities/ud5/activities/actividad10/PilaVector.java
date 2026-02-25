package classActivities.ud5.activities.actividad10;

public class PilaVector implements Pila{

	//area de datos
	private Object[] pila;
	private int posVacia;
	
	public PilaVector (int tamaño) {
		pila = new Object[tamaño];
		posVacia = 0;
	}
	
	@Override
	public void insertar(Object o) {
		if (!this.pilaLlena()) {
			pila[posVacia] = o;
			posVacia++;
		}
	}

	@Override
	public Object quitar() {
		if (this.pilaVacia()) {
			return null;
		} else {
			posVacia--;
			return pila[posVacia];
		}
		
	}

	@Override
	public boolean pilaVacia() {
		
		return posVacia==0;
	}

	@Override
	public boolean pilaLlena() {
		
		return posVacia==pila.length;
	}

	@Override
	public void limpiarPila() {
		posVacia = 0;
	}

	@Override
	public int tamañoPila() {
		
		return posVacia;
	}

}
