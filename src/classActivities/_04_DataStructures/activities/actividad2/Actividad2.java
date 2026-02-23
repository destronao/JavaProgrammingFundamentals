package classActivities._04_DataStructures.activities.actividad2;

import classActivities._04_DataStructures.activities.actividad1.Orden;
import classActivities._04_DataStructures.activities.actividad1.Vector;

public class Actividad2 {
	 public static void main(String[] args) {
		 testConstructorYEstadoInicial();
		 testConstructorVacioYNegativo();
		 testVaciarYVacio();
		 
		 testRellenarNoCambiaSiCompleto();
		 testAniadirCuandoHayHueco();
		 testInsertarManteniendoOrdenAsc();
	 }
	 
	// ---------- Helpers ----------
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
	    
	// -----------Tests----------------
	    
	    private static void testConstructorYEstadoInicial() {
	    	titulo("Constructor/Estado Inicial");
	    	Tabla t = new Tabla(5,3);
	    	t.visualizarTabla();
	    	assertTrue(t.numeroElementos()==15,"Tras construir con 5 filas y 3 columnas, debe estar lleno (numeroElementos("+t.numeroElementos()+") = 15");
	    	assertTrue(t.estaCompleto(),"esta Completo debe ser true");
	    	assertTrue(!t.estaVacio(),"estaVacio debe ser false");
	    }
	    
	    private static void testConstructorVacioYNegativo() {
	    	titulo("Constructor Vacio y Negativo");
	    	assertThrows(
	    		    IllegalArgumentException.class,
	    		    () -> new Tabla(0, 5),
	    		    "Constructor con filas = 0 lanza IllegalArgumentException"
	    		);
	    	assertThrows(
	    		    IllegalArgumentException.class,
	    		    () -> new Tabla(1, -5),
	    		    "Constructor con columnas = -5 lanza IllegalArgumentException"
	    		);
	    }
	    
	    private static void testVaciarYVacio() {
	    	titulo("vaciar() deja la tabla vacío");
	    	Tabla t = new Tabla(5,3);
	    	t.vaciar();
	    	t.visualizarTabla();
	    	assertTrue(t.numeroElementos()==0,"numeroElementos() debe ser 0 tras vaciar()");
	    	assertTrue(t.estaVacio(),"estaVacio() debe ser true tras vaciar()");
	    	assertTrue(!t.estaCompleto(),"estaCompleto() debe ser false tras vaciar()");
	    }
	    
	    private static void testRellenarNoCambiaSiCompleto() {
	    	titulo("rellenar() no cambia si está completo");
	    	Tabla t = new Tabla(5,3);
	    	int antes = t.numeroElementos();
	    	t.rellenar();
	    	int despues = t.numeroElementos();
	    	assertTrue(t.estaCompleto(),"estaCompleto() debe ser true tras rellenar.");
	    	assertTrue(antes == despues, "numeroElementos() no cambia al llamar rellenar() estando completo.");
	    }
	    
	    private static void testAniadirCuandoHayHueco() {
	    	titulo("aniadir() cuando hay hueco");
	    	Tabla t = new Tabla(5,3);
	    	t.vaciar(); 
	    	boolean ok = t.aniadir(10);
	    	t.visualizarTabla();
	    	assertTrue(ok, "aniadir(10) debe devolver true");
	    	assertTrue(t.numeroElementos() == 1,"numeroElementos() debe ser 1");
	    	assertTrue(t.obtener(0, 0) == 10, "obtener(0, 0) debe ser 10");
	    }
	    
	    private static void testInsertarManteniendoOrdenAsc() {
	    	titulo("insertar() manteniendo orden ASC");
	    	Tabla t = new Tabla(5,3);
	    	t.visualizarTabla();
	    	t.vaciar();
	    	t.visualizarTabla();
	    	t.aniadir(3);
	    	t.aniadir(1);
	    	t.aniadir(5);
	    	t.aniadir(7);
	    	t.aniadir(6);
	    	t.visualizarTabla();
	    	t.ordena(Orden.ASC);
	    	t.visualizarTabla();
	    	
	    	//Vector v = t.toVector(Orden.ASC);
	    	//v.visualizarVector();
	    	
	    	
	    	boolean insertado = t.insertar(4);
	    	t.visualizarTabla();
	    	Position posicion = new Position(-1,-1);
	    	assertTrue(insertado,"insertar(4) debe retornar true");
	    	assertTrue(!t.buscar(4).equals(posicion), "buscar(4) debe encontrar el elemento insertado");
	    	assertTrue(t.getOrden() == Orden.ASC,"getOrden() debe ser Orden.ASC");
	    	
	    }
}


