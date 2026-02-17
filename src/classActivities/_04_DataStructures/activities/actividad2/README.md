# Actividad 2 · Tabla (Array bidimensional)

## Descripción general

Esta actividad consiste en la implementación de una estructura de datos denominada **Tabla**, basada en un **array bidimensional de enteros**.  
Como ampliación de la Actividad 1 (`Vector`), esta clase incorpora un modelo de **ocupación lógica** que permite reutilizar la mayoría de los métodos del vector adaptándolos a una estructura 2D.

Aunque la tabla es físicamente bidimensional, su contenido se gestiona de forma **lógica y secuencial**, lo que facilita operaciones como añadir, eliminar, buscar, invertir u ordenar elementos.

---

## Estructura del proyecto

- **Paquete:** `actividad2`
- **Clase principal:** `Tabla`
- **Clase auxiliar:** `Main` (pruebas manuales por consola)

---

## Enunciado oficial

### Actividad 2. Tabla

1. La clase tendrá como atributo un **array bidimensional de enteros** (`int[][]`) accesible únicamente desde la propia clase.
2. Constructor que recibe por parámetro el número de **filas** y **columnas**, inicializando la tabla con valores enteros aleatorios entre **0 y 100**.

### Métodos obligatorios

3. `rellenar()`  
   Rellena toda la tabla con números enteros aleatorios entre 0 y 100, sustituyendo cualquier información previa.

4. `visualizarTabla()`  
   Muestra por pantalla el contenido completo de la tabla con el siguiente formato:

```text
t[0][0]=valor, t[0][1]=valor, ... , t[0][columnas-1]=valor
t[1][0]=valor, t[1][1]=valor, ... , t[1][columnas-1]=valor
...
t[filas-1][0]=valor, ... , t[filas-1][columnas-1]=valor
```

5. `buscar(int numero)`  
Retorna `true` si el número se encuentra en la tabla, `false` en caso contrario.

6. `media()`  
Retorna la media aritmética de los valores almacenados en la tabla con precisión decimal.

7. `obtener(int fila, int columna)`  
Retorna el valor almacenado en la posición indicada.

---

## Modelo de ocupación lógica

Para poder aplicar los mismos métodos que en la Actividad 1 (`Vector`), la tabla se gestiona mediante un **modelo lógico de ocupación**.

### Atributos lógicos

- `filaVacia`: fila de la siguiente posición libre.
- `columnaVacia`: columna de la siguiente posición libre.

La combinación de ambos indica el **próximo lugar de escritura**.

---

### Recorrido lógico (row-major)

El contenido lógico de la tabla se interpreta en orden **por filas**:

```text
t[0][0], t[0][1], ..., t[0][columnas-1],
t[1][0], t[1][1], ..., t[1][columnas-1],
...
```

Todas las posiciones anteriores a `(filaVacia, columnaVacia)` se consideran **ocupadas**.  
El resto se consideran **vacías lógicas**.

---

### Estados de la tabla

- **Tabla vacía:**  
  `filaVacia == 0 && columnaVacia == 0`

- **Tabla completa:**  
  No quedan posiciones libres para insertar nuevos elementos.

---

## Métodos de la ampliación (equivalentes al Vector)

### `aniadir(int elemento)`
Añade un nuevo elemento en la posición indicada por `(filaVacia, columnaVacia)`.

- Retorna `true` si se ha podido añadir.
- Retorna `false` si la tabla está completa.
- Actualiza correctamente los punteros lógicos.

---

### `numeroElementos()`
Retorna el número de elementos almacenados de forma lógica en la tabla.

---

### `estaVacia()`
Retorna `true` si la tabla no contiene ningún elemento lógico.

---

### `estaCompleta()`
Retorna `true` si la tabla no dispone de más posiciones libres.

---

### `vaciar()`
Vacía la tabla de forma **lógica**, reiniciando los punteros `filaVacia` y `columnaVacia`.

El contenido físico puede mantenerse o sobrescribirse, ya que no afecta al estado lógico.

---

### Métodos de búsqueda y cálculo

Estos métodos recorren **únicamente las posiciones ocupadas lógicamente**, siguiendo el recorrido row-major:

- `buscar(int elemento)`
- `media()`
- `maximo()`
- `minimo()`
- `sumaIndicePar()`
- `sumaIndiceImpar()`
- `sumaPares()`
- `sumaImpares()`

---

### `invertir()`
Invierte el orden lógico de los elementos de la tabla.

El primer elemento lógico pasa a ser el último y viceversa, manteniendo el recorrido por filas.

---

## Métodos de ordenación

### `ordenaMenorMayor()`
Ordena los elementos lógicos de la tabla de menor a mayor.

- La ordenación se aplica al conjunto completo de elementos.
- Tras la ordenación, los valores se redistribuyen siguiendo el recorrido row-major.

---

### `ordenaMayorMenor()`
Ordena los elementos lógicos de la tabla de mayor a menor, utilizando el mismo criterio.

---

## Eliminación de elementos

### `eliminar(...)`
Elimina elementos del contenido lógico de la tabla.

- Si la tabla estaba ordenada, tras la eliminación debe seguir ordenada.
- Si no estaba ordenada, el orden posterior no es relevante.
- Los punteros lógicos se actualizan correctamente.

---

## Consideraciones de diseño

- El modelo lógico permite reutilizar los métodos del `Vector` de forma coherente en una estructura 2D.
- La separación entre **capacidad física** y **contenido lógico** mejora la claridad del diseño y la testabilidad.
- La ordenación se define de forma global para evitar ambigüedades entre filas y columnas.
- Todas las decisiones de diseño están documentadas para facilitar su defensa técnica.

---

## Clase `Main`

Se incluye una clase con método `main` que invoca, al menos una vez, todos los métodos implementados, con el objetivo de validar su funcionamiento mediante pruebas manuales por consola.
