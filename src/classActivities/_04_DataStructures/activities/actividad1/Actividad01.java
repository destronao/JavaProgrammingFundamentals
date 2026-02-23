package classActivities._04_DataStructures.activities.actividad1;

public class Actividad01 {

    public static void main(String[] args) {

        testConstructorYEstadoInicial();
        testVaciarYVacio();
        testRellenarNoCambiaSiCompleto();

        testAniadirCuandoHayHueco();
        testInsertarManteniendoOrdenAsc();

        testBuscarEnAscYDescYNone();

        testOrdenarAscYDescEnVectoresDistintos();
        testInvertirCambiaOrden();

        testEliminarPorIndice();
        testEliminarUltimos();
        testBorrarPorValor();

        testMediaMaxMinConVacioYNoVacio();
        testSumas();
        testObtenerCasosBorde();
    }

    // ---------- Helpers ----------
    private static void titulo(String t) {
        System.out.println("\n=== " + t + " ===");
    }

    private static void assertTrue(boolean cond, String msg) {
        System.out.println((cond ? "[OK] " : "[FAIL] ") + msg);
    }

    // ---------- Tests ----------
    private static void testConstructorYEstadoInicial() {
        titulo("Constructor / estado inicial");
        Vector v = new Vector(5);
        v.visualizarVector();
        assertTrue(v.numeroElementos() == 5, "Tras construir con tamaño 5, debe estar lleno (numeroElementos=5)");
        assertTrue(v.estaCompleto(), "estaCompleto() debe ser true");
        assertTrue(!v.estaVacio(), "estaVacio() debe ser false");
    }

    private static void testVaciarYVacio() {
        titulo("vaciar() deja el vector vacío");
        Vector v = new Vector(5);
        v.vaciar();
        v.visualizarVector();
        assertTrue(v.numeroElementos() == 0, "numeroElementos() debe ser 0 tras vaciar()");
        assertTrue(v.estaVacio(), "estaVacio() debe ser true tras vaciar()");
        assertTrue(!v.estaCompleto(), "estaCompleto() debe ser false tras vaciar()");
    }

    private static void testRellenarNoCambiaSiCompleto() {
        titulo("rellenar() no cambia si está completo");
        Vector v = new Vector(5);
        int antes = v.numeroElementos();
        v.rellenar(); // debería no hacer cambios
        int despues = v.numeroElementos();
        assertTrue(antes == despues, "numeroElementos no cambia al llamar rellenar() estando completo");
    }

    private static void testAniadirCuandoHayHueco() {
        titulo("aniadir() cuando hay hueco");
        Vector v = new Vector(5);
        v.vaciar(); // ahora hay hueco
        boolean ok = v.aniadir(10);
        v.visualizarVector();
        assertTrue(ok, "aniadir(10) debe devolver true");
        assertTrue(v.numeroElementos() == 1, "numeroElementos debe ser 1");
        assertTrue(v.obtener(0) == 10, "obtener(0) debe ser 10");
    }

    private static void testInsertarManteniendoOrdenAsc() {
        titulo("insertar() manteniendo orden ASC");
        Vector v = new Vector(6);
        v.vaciar();
        v.aniadir(1);
        v.aniadir(3);
        v.aniadir(5);
        v.ordenaMenorMayor(); // garantiza ASC
        v.visualizarVector();

        v.insertar(4); // debe quedar 1,3,4,5
        v.visualizarVector();

        assertTrue(v.buscar(4) != -1, "buscar(4) debe encontrar el elemento insertado");
    }

    private static void testBuscarEnAscYDescYNone() {
        titulo("buscar() en ASC / DESC / NONE");

        Vector vAsc = new Vector(6);
        vAsc.vaciar();
        vAsc.aniadir(1);
        vAsc.aniadir(2);
        vAsc.aniadir(4);
        vAsc.ordenaMenorMayor();
        vAsc.estaOrdenado();
        assertTrue(vAsc.buscar(2) == 1, "ASC: buscar(2) devuelve índice correcto");
        assertTrue(vAsc.buscar(3) == -1, "ASC: buscar(3) devuelve -1");

        Vector vDesc = new Vector(6);
        vDesc.vaciar();
        vDesc.aniadir(9);
        vDesc.aniadir(7);
        vDesc.aniadir(5);
        vDesc.ordenaMayorMenor();
        vDesc.estaOrdenado();
        assertTrue(vDesc.buscar(7) == 1, "DESC: buscar(7) devuelve índice correcto");
        assertTrue(vDesc.buscar(8) == -1, "DESC: buscar(8) devuelve -1");

        Vector vNone = new Vector(6);
        vNone.vaciar();
        vNone.aniadir(2);
        vNone.aniadir(9);
        vNone.aniadir(1);
        vNone.estaOrdenado(); // debería marcar NONE
        assertTrue(vNone.buscar(9) != -1, "NONE: buscar(9) encuentra por búsqueda lineal");
    }

    private static void testOrdenarAscYDescEnVectoresDistintos() {
        titulo("ordenar ASC y DESC (tests independientes)");

        Vector v1 = new Vector(7);
        v1.vaciar();
        v1.aniadir(5);
        v1.aniadir(1);
        v1.aniadir(3);
        v1.aniadir(2);
        v1.ordenaMenorMayor();
        v1.visualizarVector();
        assertTrue(v1.estaOrdenado(), "Tras ordenaMenorMayor(), debe estar ordenado");

        Vector v2 = new Vector(7);
        v2.vaciar();
        v2.aniadir(5);
        v2.aniadir(1);
        v2.aniadir(3);
        v2.aniadir(2);
        v2.ordenaMayorMenor();
        v2.visualizarVector();
        assertTrue(v2.estaOrdenado(), "Tras ordenaMayorMenor(), debe estar ordenado (descendente)");
    }

    private static void testInvertirCambiaOrden() {
        titulo("invertir() invierte el contenido");

        Vector v = new Vector(6);
        v.vaciar();
        v.aniadir(1);
        v.aniadir(2);
        v.aniadir(3);
        v.ordenaMenorMayor();
        v.visualizarVector();

        v.invertir();
        v.visualizarVector();

        assertTrue(v.obtener(0) == 3, "Tras invertir, el primer elemento debe ser el último anterior");
    }

    private static void testEliminarPorIndice() {
        titulo("eliminar(indice)");

        Vector v = new Vector(6);
        v.vaciar();
        v.aniadir(10);
        v.aniadir(20);
        v.aniadir(30);
        v.visualizarVector();

        boolean ok = v.eliminar(1); // elimina 20
        v.visualizarVector();

        assertTrue(ok, "eliminar(1) devuelve true");
        assertTrue(v.numeroElementos() == 2, "numeroElementos debe ser 2");
        assertTrue(v.buscar(20) == -1, "20 ya no debe estar");
    }

    private static void testEliminarUltimos() {
        titulo("eliminarUltimos(n)");

        Vector v = new Vector(8);
        v.vaciar();
        v.aniadir(1);
        v.aniadir(2);
        v.aniadir(3);
        v.aniadir(4);
        v.visualizarVector();

        v.eliminarUltimos(2);
        v.visualizarVector();

        assertTrue(v.numeroElementos() == 2, "Tras eliminarUltimos(2), deben quedar 2 elementos");
    }

    private static void testBorrarPorValor() {
        titulo("borrar(valor) elimina todas las apariciones");

        Vector v = new Vector(10);
        v.vaciar();
        v.aniadir(7);
        v.aniadir(1);
        v.aniadir(7);
        v.aniadir(2);
        v.aniadir(7);
        v.visualizarVector();

        int target = 7;
        System.out.println("Borrando valor: " + target);
        v.borrar(target);
        v.visualizarVector();

        assertTrue(v.buscar(7) == -1, "Tras borrar(7), no debe quedar ningún 7");
    }

    private static void testMediaMaxMinConVacioYNoVacio() {
        titulo("media/max/min con vacío y no vacío");

        Vector v = new Vector(5);
        v.vaciar();
        assertTrue(v.media() == 0.0, "media() en vacío devuelve 0.0 (según tu contrato)");

        v.aniadir(2);
        v.aniadir(4);
        v.aniadir(6);
        assertTrue(v.maximo() == 6, "maximo() debe ser 6");
        assertTrue(v.minimo() == 2, "minimo() debe ser 2");
    }

    private static void testSumas() {
        titulo("sumas (índices y paridad)");

        Vector v = new Vector(6);
        v.vaciar();
        v.aniadir(1); // idx0
        v.aniadir(2); // idx1
        v.aniadir(3); // idx2
        v.aniadir(4); // idx3

        assertTrue(v.sumaIndicePar() == (1 + 3), "sumaIndicePar() = 1 + 3");
        assertTrue(v.sumaIndiceImpar() == (2 + 4), "sumaIndiceImpar() = 2 + 4");
        assertTrue(v.sumaPares() == (2 + 4), "sumaPares() = 2 + 4");
        assertTrue(v.sumaImpares() == (1 + 3), "sumaImpares() = 1 + 3");
    }

    private static void testObtenerCasosBorde() {
        titulo("obtener(indice) casos borde");

        Vector v = new Vector(5);
        v.vaciar();
        v.aniadir(9);

        int ok = v.obtener(0);
        assertTrue(ok == 9, "obtener(0) devuelve 9");

        int fuera = v.obtener(99);
        assertTrue(fuera == Integer.MIN_VALUE, "obtener(99) devuelve MIN_VALUE (según tu contrato)");
    }
}
