# 03_POO.activities

> En este paquete se encuentran los **enunciados** de las actividades de la Unidad 4 (POO).

---

## Actividad 1. Punto2D

Crear un paquete de nombre: `actividad1`

1. Crear una nueva clase **Punto2D** dentro del paquete creado. Esta clase representa las coordenadas `(x,y)` de la localización de un punto en el espacio 2D, especificado con una precisión entera (`int`). **No tendrá método `main`.**

   Esta clase debe tener (entre paréntesis se indica el nombre del método):

   - Un método que muestre la localización de la coordenada X del punto (**coordenadaX**).
   - Un método que muestre la localización de la coordenada Y del punto (**coordenadaY**).
   - Un método que cambie la localización del punto a una nueva localización `(x2,y2)`, donde `x2` e `y2` son valores enteros pasados como parámetro (**cambiarLocalizacion**).
   - Un método que traslade `dx` y `dy` unidades el punto (**trasladar**). `dx` y `dy` serán pasados como parámetros.

     Ejemplo: si un punto `p` tiene las coordenadas `(1,2)` → `p(1,2)` y se llama al método `trasladar(2,-5)` moverá el punto a las coordenadas `(3,-3)`  
     `(x+dx, y+dy) → 1+2=3 ; 2+(-5)=-3`

   - Un método que determine si dos puntos son iguales (**iguales**). Se pasará una variable de tipo `Punto2D` como parámetro.
   - Un método que devuelva la coordenada X (**getX**).
   - Un método que devuelva la coordenada Y (**getY**).
   - Un método que retorne un `String` que representa al punto (**mostrarPunto**).

     Ejemplo: si el punto tiene coordenadas `2,7` el mensaje a mostrar será:  
     «El punto tiene de coordenadas (x,y) → (2,7)»

2. Crea una nueva clase con método `main` (recuerda establecer el nombre según las instrucciones al comienzo de este boletín: iniciales de tus apellidos…) y realiza lo siguiente:

   - Crea un punto de nombre `p`.
   - Llama a los métodos `coordenadaX` y `coordenadaY`.
   - Establece una nueva localización para el punto `(1,1)`.
   - Traslada el punto 3 unidades en el eje x y 3 unidades en el eje y.
   - Crea una variable `x` y devuelve en ella la coordenada x del punto `p`, luego muestra el valor de `x`.
   - Crea una variable `y` y devuelve en ella la coordenada y del punto `p`, luego muestra el valor de `y`.
   - Crea un nuevo punto `p2` y asígnale las coordenadas de las variables `x+1` e `y+1` creadas anteriormente.
   - Determina si los puntos `p` y `p2` son iguales.
   - Cambia la localización de `p2` a las coordenadas de `p`.
   - Llama al método `mostrarPunto` para el punto `p2`.
   - Determina si los puntos `p` y `p2` son iguales.

---

## Actividad 2. Cafetera

Crear un paquete de nombre: `actividad2`

Define una clase **Cafetera** que controle la capacidad máxima de la misma y la cantidad que tiene en un momento dado. Inicialmente estará vacía.

Métodos:

- `capacidadMaxima(int cc)`: establece la capacidad máxima de la cafetera.
- `llenarCafetera()`: la cantidad se llena a la capacidad máxima.
- `vaciarCafetera()`: dejar sin café la cafetera.
- `cantidadActual()`: muestra la cantidad de café actual.
- `agregarCafe(int cc)`: añadir `cc` a la cantidad. Tenemos que controlar que no desborde.
- `servirCafe(int cc)`: donde `cc` indicará la cantidad de café que se quiere servir. Mostrará un mensaje que debe ser uno de los siguientes:
  - «Café servido»
  - «No hay café en la cafetera»
  - «No hay suficiente café»

Crea una nueva clase con método `main()` y realiza:

- Crear 1 objeto cafetera.
- Establecer la capacidad máxima.
- Llenar la cafetera.
- Mostrar cantidad actual.
- Vaciar la cafetera.
- Mostrar cantidad actual.
- Agregar café a una cafetera.
- Servir café:
  - Con una cantidad mayor que lo que tiene la cafetera.
  - Con una cantidad inferior.
  - Con la misma.
- Muestra la cantidad actual. Si no tiene café, agregarlo.
- Servir café con la cantidad actual.
- Servir café.

---

## Actividad 3. Matemáticas (atributos y métodos estáticos)

Crear un paquete de nombre: `actividad3`

Define un clase **MatesXY** que permita trabajar con 2 números `(x,y)` enteros (`int`). **Sin utilizar la clase `Math`.** Se pide que permita realizar y devolver el resultado de las operaciones planteadas. Además de devolver el resultado, debe también mostrar por pantalla un mensaje con la operación realizada y dicho resultado.

Consideraciones:

1. No será necesario crear objetos de esta clase para trabajar con ella.
2. El usuario puede introducir (dentro de los números enteros) cualquier valor. Será nuestra responsabilidad controlar posibles errores.
3. Ningún método debe tener parámetros.
4. Inicialmente ambos enteros tomarán el valor 0.

Operaciones:

- Consultar los valores actuales de ambos enteros.
- Intercambiar los valores de ambos enteros (**intercambiar**).
- Suma (**sumar**).
- Resta del primero el segundo entero (**restar**).
- Multiplicación (**multiplicar**).
- División entera (**divEntera**).
- Resto de la división entera (**resDivEntera**).
- Valor absoluto del primer entero (**abs**).
- Mayor de los dos números enteros (**mayor**).
- Determinar si ambos enteros son iguales (**sonIguales**).

Ejemplo de utilización:

- `int resultado;`
- `MateXY.x=1;`
- `MateXY.y=-2;`
- `resultado=MateXY.sumar();`
  - La variable `resultado` tendrá el valor `-1`.
  - El método `sumar()`, además de devolver el resultado de la operación, muestra el siguiente mensaje: «1+(-2) = -1»

Crear una clase con método `main` que trabaje con dicha clase. Utiliza, al menos, una vez cada una de las operaciones.

## Actividad 4. Cuenta corriente

Crear un paquete de nombre: `actividad4`

Define una clase **CuentaCorriente** que almacena los datos: DNI y nombre del titular, así como el saldo.

Las operaciones típicas con una cuenta corriente son (entre paréntesis se indica el nombre del método cuando proceda):

- Crear una cuenta: se necesita el DNI, nombre y saldo inicial.
- Crear una cuenta: se necesita el DNI y nombre del titular. El saldo inicial será 0.
- Sacar dinero: el método debe indicar si ha sido posible llevar a cabo la operación, si existe saldo suficiente (**sacarDinero**).
- Ingresar dinero: se incrementa el saldo (**ingreso**).
- Mostrar información: muestra la información disponible de la cuenta corriente: nombre, DNI y saldo actual (**mostrarInformacion**).

Crear una clase con método `main` que:

- Cree una cuenta corriente al cliente de nombre **Pepe** y DNI **11000000C**.
- Ingresa **1000€**.
- Saca **300€**.
- Muestra información de la cuenta.
- Muestra un mensaje al sacar **700€** indicando si se pudo o no realizar dicha operación.
- Repetir esta última acción al retirar **500€**.

---

## Actividad 5. Libro

Crear un paquete de nombre: `actividad5`

Crea una clase llamada **Libro** que guarde la información de cada uno de los libros de una biblioteca.

La clase debe guardar:
- título del libro
- autor
- número de ejemplares del libro
- número de ejemplares prestados

La clase contendrá los siguientes métodos:

- Constructor por defecto y otro constructor con parámetros.
- Método **prestamo** que incremente el atributo correspondiente cada vez que se realice un préstamo del libro. No se podrán prestar libros de los que no queden ejemplares disponibles para prestar. Devuelve `true` si se ha podido realizar la operación y `false` en caso contrario.
- Método **devolucion** que decremente el atributo correspondiente cuando se produzca la devolución de un libro. No se podrán devolver libros que no se hayan prestado. Devuelve `true` si se ha podido realizar la operación y `false` en caso contrario.
- Método `toString` para mostrar los datos de los libros.

Escribe una aplicación para probar el funcionamiento de la clase `Libro`. Para ello:

- Crear un libro `libro1` con los valores: **El Quijote**, **Cervantes**, **1** ejemplares y **0** prestados.
- Crear un libro `libro2` con los siguientes valores introduciéndolos por teclado:
  - Título: **Problemas de Java**
  - Autor: **Jose María Pérez**
  - Ejemplares: **4**

- Realizar préstamos del `libro1` y devoluciones comprobando que no se puede prestar el libro cuando no quedan ejemplares y prestándolo siempre que `prestados < número de ejemplares`. Mostrar los mensajes necesarios y el valor de los atributos del `libro1` para comprobar que funciona.
- Hacer lo mismo con el `libro2`, realizando alguna operación de préstamo o devolución.

---

## Actividad 6. Cuenta corriente v.2

Crear un paquete de nombre: `actividad6`

Define una clase **CuentaCorriente2**.

Copia el código de la actividad 4 y realiza las modificaciones necesarias para que todo el código sea válido en esta nueva clase. Además:

1. Modifica la visibilidad de esta clase para que sea visible desde clases externas y la visibilidad de sus atributos para que:
   - `saldo` no sea visible para otras clases.
   - `nombre` sea visible para cualquier clase.
   - `dni` solo sea visible por clases del mismo paquete (también llamadas vecinas).

2. Todas las cuentas corrientes con las que se va a trabajar pertenecen al mismo banco.
   - Añadir un atributo que almacene el nombre del banco (que es único) en esta clase y su acceso solo esté permitido en dicha clase.
   - Diseñar un método que permita recuperar y modificar el nombre del banco (al que pertenecen todas las cuentas corrientes).
   - Modifica el método `mostrarInformacion` para que muestre también el nombre del banco.
   - Crear una nueva clase con método `main` que cree dos cuentas, una para **Ana** y otra para **Pepe**.
   - Establecer el nombre del banco «Banco QueTQuito».
   - Mostrar información tanto de la cuenta de Ana como la de Pepe.
   - Modificar el nombre del banco a «Banco Aun+Malo».
   - Volver a mostrar información de las dos cuentas creadas.

3. Existen gestores que administran las cuentas bancarias y atienden a sus propietarios.
   - Diseñar la clase **Gestor** de la que interesa guardar su nombre, teléfono y el importe máximo autorizado con el que pueden operar.

   Restricciones:
   - Un gestor tendrá siempre un nombre y un teléfono.
   - Si no se asigna, el importe máximo autorizado por operación será de **10000 euros**.
   - Un gestor, una vez asignado, no podrá cambiar su número de teléfono. Y todo el mundo podrá consultarlo.
   - El nombre será público y el importe máximo solo será visible por clases vecinas.

   Modificar la clase `CuentaCorriente2` para que pueda disponer de un objeto `Gestor`. Escribir los métodos necesarios.

## Actividad 7. Mascota virtual

Crear un paquete de nombre: `actividad7`

Define una clase **PerroVirtual**. La empresa «VirtualizaT» decide llevar a cabo un proyecto de diseño de una mascota virtual. La mascota elegida es un perrito.

El perro virtual aparece con las siguientes características:

1. Todos los perros tienen un nombre que les asigna su dueño cuando nacen.
2. Su estado de salud se mide en función del nivel de energía, que aumenta cuando comen o duermen y disminuye cuando hacen ejercicio.
3. Cuando nacen, los perros virtuales tienen un nivel de energía **20**.
   - Si se alimentan el nivel sube en **5** unidades.
   - Si duermen aumenta en **2** unidades.
   - Si hacen ejercicio su nivel se reduce en **3** unidades.
4. Un perro virtual se puede poner enfermo, en cuyo caso no puede realizar ninguna actividad (comer, dormir, hacer ejercicio) hasta que no visita al veterinario, lo que lo vuelve a su nivel de energía 20.
5. Si come o duerme en exceso y su nivel se pone por encima de **50** se pone enfermo y lo mismo ocurre cuando hace demasiado ejercicio y su nivel baja de **15**.
6. Además, un perro puede ponerse enfermo si la comida le sienta mal, este aspecto es totalmente aleatorio (cuando come hay una probabilidad de **3/10** de que la comida le siente mal).
7. El perro virtual se comunica con su dueño cada vez que hace una actividad, indicándole:
   - con un ladrido (**guau**) que su nivel de energía es correcto,
   - con un gemido (**ay**) que está a punto de ponerse enfermo (por ejemplo cuando está a 3 unidades de ponerse malo; recordemos que está sano entre 15 y 50),
   - y con un grito grande (**ayyyyyyyyyy**) cuando ya está enfermo.
8. Se puede controlar el nivel de energía cuando se quiera.

La entrada de datos se realizará desde la aplicación, donde se gestionará un menú con las siguientes opciones:

1.- Nacer  
2.- Comer  
3.- Hacer ejercicio  
4.- Dormir  
5.- Ir al veterinario  
6.- Consultar nivel de energía  
0.- Salir  

Crea la clase necesaria para implementar lo solicitado y crea una nueva clase con método `main` donde se gestione el menú de la aplicación.

---

## Actividad 8. Hucha

Crear un paquete de nombre: `actividad8`

Escribir el código JAVA de una clase denominada **Hucha**, con las siguientes características:

✔ Cada objeto de esta clase representará una hucha electrónica, que sólo puede contener:
- monedas de **1€**
- monedas de **2€**
- billetes de **5€**

✔ La hucha deberá almacenar información acerca de cuántos billetes y monedas de cada clase tiene en su interior.  
✔ Además, cada hucha podrá estar cerrada o no.  
✔ De una hucha cerrada no se puede sacar dinero.  
✔ No se podrán modificar directamente las monedas y/o billetes (siempre se tiene que recurrir a los métodos adecuados).

Existirán exclusivamente los siguientes métodos:

1. **Constructor**: el constructor recibirá un valor que servirá para fijar si la hucha está cerrada o no.
2. **abrirHucha**: hará que la hucha quede abierta. No importa si antes estaba abierta o cerrada.
3. **ingresar**: recibirá un número de monedas de 1€; otro de monedas de 2€, y otro de billetes de 5€, que se sumarán al contenido de la hucha.
4. **valorTotal**: devolverá el valor total en € del contenido de la hucha.
5. **hayBilletes**: devolverá `false` si no hay billetes en la hucha, `true` en caso contrario.
6. **sacarBilletes**: recibirá un número de billetes.
   - Si la hucha está cerrada debe escribir un mensaje en pantalla y no hacer nada.
   - Si el número de billetes que se desea sacar es mayor que el número de billetes que queda en la hucha también se mostrará un mensaje y no se hará nada.
   - En cualquier otro caso, se restará el número de billetes.

Crea una clase con método `main` que realice un recorrido por las diferentes posibilidades existentes, presentado un menú de opciones donde el usuario podrá elegir la opción deseada.
  