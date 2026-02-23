package classActivities._04_DataStructures.activities.Actividad3;

import java.util.ArrayList;

public class Actividad03 {

	public static void main(String[] args) {
		constructorYEstadoInicial();

	    modificarYObtener();
	    modificarNoDebeCambiarSize(); // NUEVO
	    obtenerFueraRango();

	    eliminarInsertarIndice();

	    eliminarPorValor();           // NUEVO
	    insertarAlFinal();            // NUEVO
	    insertarIndiceFueraRangoAlFinal(); // NUEVO
	    copiarLista();                // NUEVO
	    borrarTodosTest();            // NUEVO
	    ordenarTest();                // NUEVO
	}
	
	// ------------- Helpers ----------------
	
	private static void titulo(String t) {
		System.out.println("\n=== " + t + " ===");
	}
	
	private static void assertTrue(boolean cond, String msg) {
		System.out.println((cond ? "[OK] " : "[FAIL] ") + msg);
	}
	private static void assertThrows(Class<? extends Exception> tipoEsperado,Runnable codigo,String mensaje) {
    	try {
    		codigo.run();
    		System.out.println("[FAIL] " + mensaje + " (no se lanzó excepción)");
    	} catch (Exception e) {
    		if (tipoEsperado.isInstance(e)) {
    			System.out.println("[OK] " + mensaje);
    		} else {
    			System.out.println("[FAIL] " + mensaje +
    					" (excepción incorrecta: " + e.getClass().getSimpleName() + ")");
    		}
    	}
    }
	
	private static void assertEquals(int esperado, int actual, String msg) {
	    System.out.println((esperado == actual ? "[OK] " : "[FAIL] ") + msg +
	            " (esperado=" + esperado + ", actual=" + actual + ")");
	}

	private static void assertEquals(Object esperado, Object actual, String msg) {
	    boolean ok = (esperado == null) ? (actual == null) : esperado.equals(actual);
	    System.out.println((ok ? "[OK] " : "[FAIL] ") + msg +
	            " (esperado=" + esperado + ", actual=" + actual + ")");
	}
	
	// ---------------------- TESTS ---------------------------
	
	private static void constructorYEstadoInicial() {
		titulo("Constructor y Estado inicial");
		ListaDinamica l = new ListaDinamica(10);
		assertTrue(l.size()==10,"size() deber ser igual a 10");
	}
	
	private static void modificarYObtener() {
		titulo("Modificar y Obtener");
		ListaDinamica l = new ListaDinamica(10);
		assertTrue(l.modificar(0, -1),"debe haber modificado el primer valor de la lista");
		assertTrue(l.obtener(0)==-1,"obtener(0) debe ser igual a -1");
	}
	
	private static void obtenerFueraRango() {
		titulo("Obtener fuera de rango");
		ListaDinamica l = new ListaDinamica(10);
		assertTrue(l.obtener(100)==Integer.MIN_VALUE,"obtener debe retornar Integer.MIN_VALUE al acceder al indice 100");
		assertTrue(l.obtener(-1)==Integer.MIN_VALUE,"obtener debe retornar Integer.MIN_VALUE al acceder al indice -1");
	}
	
	private static void eliminarInsertarIndice() {
		titulo("Eliminar por indice");
		ListaDinamica l = new ListaDinamica(10);
		assertTrue(l.eliminar(0),"eliminar debe haber eliminado el primer valor de la lista");
		assertTrue(!(l.eliminar(-1)),"eliminar no debe haber eliminado nada");
		l.contenidoRecomendable();
		l.contenidoTradicional();
		assertTrue(l.size()==9,"size() debe ser 9");
		assertTrue(l.insertar(0,-1),"insertar debe haber insertado en el primer valor de la lista.");
		assertTrue(l.insertar(-1,-1),"insertar debe haber insertado en el ultimo valor de la lista.");
		assertTrue(l.size()==11,"size() debe ser 11");
	}
	
	private static void eliminarPorValor() {
	    titulo("Eliminar por valor (primera ocurrencia)");
	    ListaDinamica l = new ListaDinamica(0);
	    l.insertar(7);
	    l.insertar(3);
	    l.insertar(7);
	    l.insertar(9);

	    assertTrue(l.eliminar(Integer.valueOf(7)), "Debe eliminar el primer 7");
	    assertEquals(3, l.size(), "size() debe ser 3 tras eliminar una ocurrencia");

	    // Ahora el primero debería ser 3
	    assertEquals(Integer.valueOf(3), l.obtener(0), "Tras eliminar 7, el índice 0 debe ser 3");
	    // Y aún queda un 7
	    assertTrue(l.eliminar(Integer.valueOf(7)), "Debe poder eliminar el segundo 7");
	    assertTrue(!l.eliminar(Integer.valueOf(7)), "Ya no queda 7, debe devolver false");
	}

	private static void modificarNoDebeCambiarSize() {
	    titulo("Modificar no debe cambiar size()");
	    ListaDinamica l = new ListaDinamica(10);
	    int antes = l.size();
	    l.modificar(0, 999);
	    int despues = l.size();
	    assertEquals(antes, despues, "modificar() NO debe cambiar el tamaño de la lista");
	}
	private static void insertarAlFinal() {
	    titulo("Insertar al final");
	    ListaDinamica l = new ListaDinamica(0);

	    assertTrue(l.insertar(10), "insertar(valor) debe devolver true");
	    assertEquals(1, l.size(), "size() debe ser 1");
	    assertEquals(Integer.valueOf(10), l.obtener(0), "El elemento insertado debe estar en el índice 0");

	    l.insertar(20);
	    assertEquals(2, l.size(), "size() debe ser 2");
	    assertEquals(Integer.valueOf(20), l.obtener(1), "El segundo insert debe quedar al final");
	}
	
	private static void insertarIndiceFueraRangoAlFinal() {
	    titulo("Insertar en índice fuera de rango => al final");
	    ListaDinamica l = new ListaDinamica(0);

	    l.insertar(1, 99); // size=0, índice 1 inválido => debe ir al final
	    assertEquals(1, l.size(), "Debe insertarse al final si el índice no es posible");
	    assertEquals(Integer.valueOf(99), l.obtener(0), "Debe quedar como último (y único) elemento");
	}
	private static void copiarLista() {
	    titulo("Copiar lista externa dentro de ListaDinamica");

	    ListaDinamica l = new ListaDinamica(0);
	    l.insertar(1);
	    l.insertar(2);

	    ArrayList<Integer> externa = new ArrayList<>();
	    externa.add(7);
	    externa.add(8);
	    externa.add(9);

	    boolean ok = l.copiar(externa);
	    assertTrue(ok, "copiar() debe devolver true si copia correctamente");
	    assertEquals(3, l.size(), "size() debe ser igual al tamaño de la lista externa");
	    assertEquals(Integer.valueOf(7), l.obtener(0), "Elemento 0 debe ser 7");
	    assertEquals(Integer.valueOf(8), l.obtener(1), "Elemento 1 debe ser 8");
	    assertEquals(Integer.valueOf(9), l.obtener(2), "Elemento 2 debe ser 9");
	}
	private static void borrarTodosTest() {
	    titulo("Borrar todos los elementos con un valor");
	    ListaDinamica l = new ListaDinamica(0);

	    l.insertar(5);
	    l.insertar(1);
	    l.insertar(5);
	    l.insertar(5);
	    l.insertar(2);

	    assertTrue(l.borrarTodos(5), "Debe devolver true si elimina algún 5");
	    assertEquals(2, l.size(), "Tras borrar 5s deben quedar 2 elementos");
	    assertEquals(Integer.valueOf(1), l.obtener(0), "Debe quedar 1 en índice 0");
	    assertEquals(Integer.valueOf(2), l.obtener(1), "Debe quedar 2 en índice 1");

	    assertTrue(!l.borrarTodos(5), "Si ya no hay 5, debe devolver false");
	}
	private static void ordenarTest() {
	    titulo("Ordenar de menor a mayor");
	    ListaDinamica l = new ListaDinamica(0);

	    l.insertar(10);
	    l.insertar(3);
	    l.insertar(7);
	    l.insertar(3);

	    l.ordenar();

	    assertEquals(Integer.valueOf(3), l.obtener(0), "Índice 0 debe ser 3");
	    assertEquals(Integer.valueOf(3), l.obtener(1), "Índice 1 debe ser 3");
	    assertEquals(Integer.valueOf(7), l.obtener(2), "Índice 2 debe ser 7");
	    assertEquals(Integer.valueOf(10), l.obtener(3), "Índice 3 debe ser 10");
	}
}
