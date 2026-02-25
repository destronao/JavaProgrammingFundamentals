package classActivities.ud5.activities.actividad10;

public interface Pila {

	public void insertar(Object o);
	public Object quitar();
	
	public boolean pilaVacia();
	public boolean pilaLlena();
	public void limpiarPila();
	public int tamañoPila();
	
}
