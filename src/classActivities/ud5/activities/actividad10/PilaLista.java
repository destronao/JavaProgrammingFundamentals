package classActivities.ud5.activities.actividad10;

import java.util.ArrayList;

public class PilaLista implements Pila{
	
	private ArrayList<Object> pila;
	
	public PilaLista() {
		pila = new ArrayList<Object>();
	}
	
	@Override
	public void insertar(Object o) {
		pila.add(o);
	}

	@Override
	public Object quitar() {
		if (pilaVacia()) {
			return null;
		}
		return pila.removeLast();
	}

	@Override
	public boolean pilaVacia() {
		return (pila.size()==0);
	}

	@Override
	public boolean pilaLlena() {
		return false;
	}

	@Override
	public void limpiarPila() {
		pila.clear();
	}

	@Override
	public int tamañoPila() {
		
		return pila.size();
	}
	
}
