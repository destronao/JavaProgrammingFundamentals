# Unidad 5 – Actividades (Estructuras de datos)

Enunciados oficiales de las actividades de la Unidad 5.

## Actividad 1. Vector
Crear un paquete de nombre: `actividad1`.

Crear una clase llamada `Vector` con las siguientes características:

1. Como atributo tendrá un Array unidimensional (v) de enteros solo accesible desde la propia clase y otro atributo (posVacia) que será la primera posición vacía del vector donde podemos introducir un valor (solo accesible desde la propia clase).  
   Nota: recuerda mantener siempre actualizado el atributo posVacia.
2. Constructor que reciba por parámetro el tamaño del vector y lo rellene con números enteros aleatorios entre 0 y 20.

**Métodos:**
3. `rellenar`: rellena el vector con números enteros aleatorios entre 0 y 100. Hay que tener en cuenta que si el vector ya tiene elementos, estos se deben de mantener, solo rellenando las posiciones vacías.
4. `vaciar`: “vacía” el vector de elementos.
5. `numeroElementos`: retorna el número de elementos que actualmente tiene el vector (posiciones no vacías).
6. `visualizarVector`: muestra por pantalla el contenido del vector (solo posiciones no vacías) con el formato: `v[0]=valor, v[1]=valor, ….. v[n]=valor`
7. `estaCompleto`: retorna cierto si el vector está completo, falso en caso contrario.
8. `estaOrdenado`: retorna cierto si el vector está ordenado de menor a mayor, falso en caso contrario. Si está vacío consideraremos que está ordenado.
9. `buscar(int num)`: retorna la posición (índice) donde se encuentra la primera ocurrencia de num, o `-1` si no se encuentra. Ojo: ten en cuenta si el vector se encuentra ordenado o no.
10. `media`: retorna la media de los números almacenados con precisión con decimales.
11. `sumaIndicePar`: retorna la suma de los elementos situados en índice par.
12. `sumaIndiceImpar`: retorna la suma de los elementos situados en índice impar.
13. `sumaPares`: retorna la suma de todos los elementos pares del vector.
14. `sumaImpares`: retorna la suma de todos los elementos impares del vector.
15. `invertir`: invierte los elementos del vector.
16. `aniadir(int elemento)`: añade un nuevo elemento en la primera posición libre. Retorna cierto si ha podido añadirlo, falso en caso contrario.
17. `eliminarUltimos(int numElementos)`: “elimina” los numElementos finales del vector, independientemente si el vector tiene o no ese número de elementos.
18. `eliminar(int indice)`: elimina el elemento de la posición indicada. Retorna cierto si se ha podido eliminar, falso en caso contrario. Ojo: ten en cuenta si el vector está o no ordenado antes. Si estaba ordenado, después de eliminar debe seguir ordenado.
19. `obtener(int indice)`: retorna el elemento en el índice. Si está vacío o fuera de rango, informar con mensaje y retornar `Integer.MIN_VALUE`.
20. `maximo`: retorna el máximo valor almacenado. Si el vector está vacío retornar `Integer.MIN_VALUE`.
21. `minimo`: retorna el mínimo valor almacenado. Si el vector está vacío retornar `Integer.MAX_VALUE`.
22. `ordena`: ordena los elementos del vector de menor a mayor.

**Métodos propuestos / ampliación:**
- `insertar(int elemento)`: inserta un nuevo elemento. Si el vector está ordenado, debe seguir ordenado al finalizar. No puede usar el método ordenar ni ordenar el vector desde cero.
- `borrar(int elemento)`: elimina todas las entradas del vector que coincidan con el elemento.
- Renombrar `ordena` por `ordenaMenorMayor`. Crear `ordenaMayorMenor`. Modificar métodos para aprovechar el nuevo método y mejorar eficacia.
- `estaVacio`: retorna true si el vector está vacío, false en caso contrario. Modifica los métodos que puedan hacer uso de este nuevo método.

**Consideraciones:**
- Siempre que sea posible y exista un método que resuelve una determinada tarea se debe de utilizar.
- Crear una clase con método `main` para que llame, al menos, una vez a cada método. :contentReference[oaicite:7]{index=7}

## Actividad 2. Tabla
Crear un paquete de nombre: `actividad2`.

Crear una clase llamada `Tabla` con las siguientes características:
1. Como atributo tendrá un Array bidimensional (t) de enteros solo accesible desde la propia clase.
2. Constructor que reciba por parámetro el tamaño de la tabla (filas y columnas) y lo rellene con números enteros aleatorios entre 0 y 100.

**Métodos:**
3. `rellenar`: rellena toda la tabla con números aleatorios entre 0 y 100. Si la tabla ya tuviese información, esta será sustituida.
4. `visualizarTabla`: muestra el contenido con el formato:
   - `t[0][0]=valor, t[0][1]=valor, ….. t[0][columnas-1]=valor`
   - `t[1][0]=valor, t[1][1]=valor, ….. t[1][columnas-1]=valor`
   - …
5. `buscar(int numero)`: retorna cierto si el número está en la tabla, falso en caso contrario.
6. `media`: retorna la media de los números almacenados con precisión con decimales.
7. `obtener(int fila, int columna)`: retorna el elemento de la posición determinada por los parámetros.

Crear una clase con método `main` para que llame, al menos, una vez a cada método.
Nota: se propone como ampliación la realización de los mismos métodos que la actividad 1.

## Actividad 3. Lista dinámica
Crear un paquete de nombre: `actividad3`. 

Crear una clase llamada `ListaDinamica` con las siguientes características:
1. Como atributo tendrá un `ArrayList<Integer>` de enteros solo accesible desde la propia clase.
2. Constructor: recibirá como parámetro el tamaño de la lista e inicializará cada posición con un entero aleatorio entre 0 y 200.
3. `obtener(int indice)`: retorna el valor indicado en el índice. Si el índice está fuera de rango retornará `Integer.MIN_VALUE`.
4. `modificar(int indice, Integer nuevoValor)`: modifica la posición indicada estableciendo el valor `nuevoValor`. Se mostrará un mensaje aclaratorio.
5. `contenidoTradicional`: muestra el contenido con `for`.
6. `contenidoRecomendable`: muestra el contenido con `foreach`.
7. `eliminar(int indice)`: elimina el elemento en el índice si es posible. Se mostrará un mensaje aclaratorio.
8. `eliminar(Integer valor)`: elimina la primera ocurrencia del valor. Se mostrará un mensaje aclaratorio.
9. `insertar(Integer valor)`: inserta un elemento al final.
10. `insertar(int indice, Integer valor)`: inserta en el índice si es posible; si no, lo añade al final.
11. `copiar(ArrayList<Integer> lista)`: copia los elementos en la lista pasada por argumento (si tuviese elementos, se borran previamente).
12. `borrarTodos(Integer valor)`: elimina todos los elementos que coincidan con el valor.
13. `ordenar()`: ordena la lista de menor a mayor.
