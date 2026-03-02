package classActivities.ud5.activities.actividad10;

public class Actividad10Tests {

    public static void main(String[] args) {
        // PilaLista
        pilaLista_constructorYEstadoInicial();
        pilaLista_insertarYTamano();
        pilaLista_lifoBasico();
        pilaLista_quitarEnVacia();
        pilaLista_limpiar();

        // PilaVector
        pilaVector_constructorYEstadoInicial();
        pilaVector_insertarHastaLlenar();
        pilaVector_insertarEnLlenaNoDebeCambiar();
        pilaVector_lifoBasico();
        pilaVector_quitarEnVacia();
        pilaVector_limpiar();
        pilaVector_tamanoCeroCasoBorde();

        resumen();
    }

    // ----------------- Mini framework -----------------

    private static int ok = 0;
    private static int fail = 0;

    private static void titulo(String t) {
        System.out.println("\n=== " + t + " ===");
    }

    private static void assertTrue(boolean cond, String msg) {
        if (cond) {
            ok++;
            System.out.println("[OK]   " + msg);
        } else {
            fail++;
            System.out.println("[FAIL] " + msg);
        }
    }

    private static void assertFalse(boolean cond, String msg) {
        assertTrue(!cond, msg);
    }

    private static void assertEquals(int esperado, int actual, String msg) {
        boolean cond = (esperado == actual);
        if (cond) ok++; else fail++;
        System.out.println((cond ? "[OK]   " : "[FAIL] ") + msg +
                " (esperado=" + esperado + ", actual=" + actual + ")");
    }

    private static void assertEquals(Object esperado, Object actual, String msg) {
        boolean cond = (esperado == null) ? (actual == null) : esperado.equals(actual);
        if (cond) ok++; else fail++;
        System.out.println((cond ? "[OK]   " : "[FAIL] ") + msg +
                " (esperado=" + esperado + ", actual=" + actual + ")");
    }

    private static void assertNull(Object actual, String msg) {
        assertEquals(null, actual, msg);
    }

    private static void resumen() {
        System.out.println("\n========== TEST SUMMARY ==========");
        System.out.println("PASSED: " + ok);
        System.out.println("FAILED: " + fail);
        System.out.println("==================================");
    }

    // ---------------------- TESTS: PilaLista ----------------------

    private static void pilaLista_constructorYEstadoInicial() {
        titulo("PilaLista - Constructor y estado inicial");
        Pila p = new PilaLista();
        assertTrue(p.pilaVacia(), "pilaVacia() debe ser true al crearla");
        assertEquals(0, p.tamañoPila(), "tamañoPila() debe ser 0 al crearla");
        assertFalse(p.pilaLlena(), "pilaLlena() debe ser false (sin límite fijo)");
    }

    private static void pilaLista_insertarYTamano() {
        titulo("PilaLista - Insertar y tamaño");
        Pila p = new PilaLista();
        p.insertar("A");
        assertFalse(p.pilaVacia(), "Tras insertar, pilaVacia() debe ser false");
        assertEquals(1, p.tamañoPila(), "tamañoPila() debe ser 1 tras insertar 1 elemento");
    }

    private static void pilaLista_lifoBasico() {
        titulo("PilaLista - LIFO básico");
        Pila p = new PilaLista();
        p.insertar("A");
        p.insertar("B");
        p.insertar("C");

        assertEquals("C", p.quitar(), "quitar() debe devolver el último insertado (C)");
        assertEquals("B", p.quitar(), "quitar() debe devolver (B)");
        assertEquals("A", p.quitar(), "quitar() debe devolver (A)");

        assertTrue(p.pilaVacia(), "Al final debe quedar vacía");
        assertEquals(0, p.tamañoPila(), "Al final tamañoPila() debe ser 0");
    }

    private static void pilaLista_quitarEnVacia() {
        titulo("PilaLista - Quitar en vacía");
        Pila p = new PilaLista();
        assertNull(p.quitar(), "quitar() en vacía debe devolver null");
        assertTrue(p.pilaVacia(), "Debe seguir vacía");
        assertEquals(0, p.tamañoPila(), "tamañoPila() debe seguir siendo 0");
    }

    private static void pilaLista_limpiar() {
        titulo("PilaLista - Limpiar pila");
        Pila p = new PilaLista();
        p.insertar("A");
        p.insertar("B");
        p.limpiarPila();

        assertTrue(p.pilaVacia(), "limpiarPila() debe dejar la pila vacía");
        assertEquals(0, p.tamañoPila(), "limpiarPila() debe dejar tamaño 0");
        assertNull(p.quitar(), "quitar() tras limpiar debe devolver null");
        assertFalse(p.pilaLlena(), "pilaLlena() debe seguir siendo false");
    }

    // ---------------------- TESTS: PilaVector ----------------------

    private static void pilaVector_constructorYEstadoInicial() {
        titulo("PilaVector - Constructor y estado inicial (capacidad 3)");
        PilaVector p = new PilaVector(3);

        assertTrue(p.pilaVacia(), "pilaVacia() debe ser true al crearla");
        assertEquals(0, p.tamañoPila(), "tamañoPila() debe ser 0 al crearla");
        assertFalse(p.pilaLlena(), "pilaLlena() debe ser false al inicio");
    }

    private static void pilaVector_insertarHastaLlenar() {
        titulo("PilaVector - Insertar hasta llenar (capacidad 3)");
        PilaVector p = new PilaVector(3);
        p.insertar("A");
        p.insertar("B");
        p.insertar("C");

        assertTrue(p.pilaLlena(), "Tras 3 inserciones, pilaLlena() debe ser true");
        assertEquals(3, p.tamañoPila(), "tamañoPila() debe ser 3");
        assertFalse(p.pilaVacia(), "pilaVacia() debe ser false");
    }

    private static void pilaVector_insertarEnLlenaNoDebeCambiar() {
        titulo("PilaVector - Insertar en llena no debe cambiar tamaño/tope");
        PilaVector p = new PilaVector(3);
        p.insertar("A");
        p.insertar("B");
        p.insertar("C");
        assertTrue(p.pilaLlena(), "Precondición: debe estar llena");

        p.insertar("D"); 

        assertEquals(3, p.tamañoPila(), "Insertar en llena no debe cambiar tamaño");
        assertEquals("C", p.quitar(), "El tope debe seguir siendo C (no debe entrar D)");
    }

    private static void pilaVector_lifoBasico() {
        titulo("PilaVector - LIFO básico");
        PilaVector p = new PilaVector(3);
        p.insertar("A");
        p.insertar("B");
        p.insertar("C");

        assertEquals("C", p.quitar(), "quitar() debe devolver C");
        assertEquals("B", p.quitar(), "quitar() debe devolver B");
        assertEquals("A", p.quitar(), "quitar() debe devolver A");

        assertTrue(p.pilaVacia(), "Al final debe quedar vacía");
        assertEquals(0, p.tamañoPila(), "Al final tamañoPila() debe ser 0");
        assertFalse(p.pilaLlena(), "Al final no debe estar llena");
    }

    private static void pilaVector_quitarEnVacia() {
        titulo("PilaVector - Quitar en vacía");
        PilaVector p = new PilaVector(3);

        assertNull(p.quitar(), "quitar() en vacía debe devolver null");
        assertTrue(p.pilaVacia(), "Debe seguir vacía");
        assertEquals(0, p.tamañoPila(), "tamañoPila() debe seguir siendo 0");
    }

    private static void pilaVector_limpiar() {
        titulo("PilaVector - Limpiar pila");
        PilaVector p = new PilaVector(3);
        p.insertar("A");
        p.insertar("B");
        p.limpiarPila();

        assertTrue(p.pilaVacia(), "limpiarPila() debe dejar la pila vacía");
        assertEquals(0, p.tamañoPila(), "limpiarPila() debe dejar tamaño 0");
        assertFalse(p.pilaLlena(), "Tras limpiar no debe estar llena");
        assertNull(p.quitar(), "quitar() tras limpiar debe devolver null");
    }

    private static void pilaVector_tamanoCeroCasoBorde() {
        titulo("PilaVector - Caso borde capacidad 0");
        PilaVector p = new PilaVector(0);

        // Con capacidad 0: está vacía y también "llena" (no cabe nada)
        assertTrue(p.pilaVacia(), "Con tamaño 0, pilaVacia() debe ser true");
        assertTrue(p.pilaLlena(), "Con tamaño 0, pilaLlena() debe ser true");
        assertEquals(0, p.tamañoPila(), "Con tamaño 0, tamañoPila() debe ser 0");

        p.insertar("X"); 
        assertEquals(0, p.tamañoPila(), "Insertar con tamaño 0 no debe cambiar tamaño");
        assertNull(p.quitar(), "quitar() sigue devolviendo null");
    }
}