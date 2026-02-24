# Unidad 5 – Herencia y Polimorfismo  
(Actividades Académicas)

Este documento describe de forma estructurada las actividades correspondientes a la Unidad 5: Utilización Avanzada de Clases – Herencia y Polimorfismo.

Las actividades tienen como objetivo aplicar conceptos fundamentales de la Programación Orientada a Objetos en Java, incluyendo:

- Herencia
- Sobrescritura de métodos
- Uso de `super`
- Clases abstractas
- Polimorfismo
- Interfaces
- Colecciones con objetos polimórficos

Las especificaciones están basadas en el documento oficial de actividades de la unidad :contentReference[oaicite:1]{index=1}.
---

## Actividad 1 – Curso

Se debe crear un paquete `actividad1`.

### Requisitos:

1. Clase `Persona`
   - Atributos: nombre, apellidos, año de nacimiento.
   - Métodos getter y setter.
   - Método `imprime()` que muestre:
     "Datos Personales: nombre nació en el año ...."

2. Clase `Alumno` (hereda de Persona)
   - Atributos protected: grupo y horario.
   - Método `grupo_turno(String grupo, String horario)` para asignarlos.
   - Método para visualizar todos los datos del alumno.

3. Clase `Curso` con método `main`
   - Crear objetos `alum1` y `alum2`.
   - Asignar datos personales y grupo/horario.
   - Mostrar información utilizando los métodos definidos.

4. Clase `Profesor` (hereda de Persona)
   - Atributos: departamento y NRP.
   - Crear objetos y mostrar todos los datos.

---

## Actividad 2 – Vehículo

Crear paquete `actividad2`.

### Clase `Vehiculo`
- Atributos: matricula, color, numeroRuedas, cilindrada, potencia.
- Constructores sobrecargados:
  - Con matrícula, color y número de ruedas.
  - Añadiendo cilindrada.
  - Añadiendo potencia.
- Métodos:
  - Setters para cilindrada y potencia.
  - Getters para todos los atributos.
  - Sobrescribir `toString()`.

### Clase `Coche` (hereda de Vehiculo)
- Atributo: numPuertas.
- Constructores que llaman a `super()` (siempre 4 ruedas).
- Getter y setter.
- Sobrescribir `toString()`.

### Clase `PruebaVehiculo`
- Crear objetos cochePepe y cocheMaria.
- Mostrar datos.

---

## Actividad 3 – Moto

Ampliación de la actividad anterior.

### Clase `Moto` (hereda de Vehiculo)
- Atributo: numPlazas.
- Constructores que llaman a `super()` (siempre 2 ruedas).
- Getter y setter.

Modificar `PruebaVehiculo`:
- Crear objeto `motoPepe`.
- Mostrar datos.
---

## Actividad 4 – Banco

Crear paquete `actividad4`.

### Clase `Titular`
- Atributos privados: nombre, apellidos, edad.
- Método que devuelva una cadena con nombre, apellidos y edad.

### Clase `CuentaCorriente`
- Atributos privados:
  - Titular titular
  - String numeroCuenta
  - Double saldo
- Métodos:
  - `setSaldo(Double saldo)`
  - `ingreso(Double cantidad)`
  - `reintegro(Double cantidad)`
  - `getSaldo()`
  - `getNumCta()`
  - Sobrescribir `toString()` mostrando toda la información.

### Clase `BancoAviles` (main)
- Crear objeto `Titular`.
- Crear cuenta corriente.
- Realizar ingresos y reintegros.
- Mostrar datos completos.

### Clase `CuentaAhorro` (hereda de CuentaCorriente)
- Atributo privado: interes.
- Métodos:
  - `setInteres(double interes)`
  - `getInteres()`
  - `calcularIntereses()` → saldo + saldo * interes / 100
  - Método para visualizar datos.

Modificar el main:
- Crear cuenta de ahorro.
- Ingresar dinero.
- Mostrar saldo antes y después de aplicar intereses.

---

## Actividad 5 – Empleados

Crear paquete `actividad5`.

### Clase abstracta `Empleado`
Atributos:
- String dni
- String nombre
- String apellidos
- int anioIngreso

Método abstracto:
- `float getSalario()`

### Clase `EContratado`
- Atributo: salario base.
- Cálculo del salario según antigüedad:
  - Incrementos progresivos del 1% al 15%.
  - Más de 12 años → 20%.

### Clase `EDestajo`
- Atributos:
  - salarioD = 130.05
  - numeroClientes
- Salario calculado en función del número de clientes.

---

## Actividad 6 – Empleados (Ampliación)

Crear paquete `actividad6`.

### Clase `ListaEmpleados`
- Contiene un `ArrayList<Empleado>`.
- Métodos necesarios para:
  - Añadir empleado.
  - Eliminar empleado por DNI.
  - Buscar empleado.
  - Mostrar empleados.

### Clase `AppEmpleado`
- Introducción de datos por teclado.
- Añadir empleados al ArrayList.
- Implementar menú con opciones:

1. Registrar empleado contratado.
2. Registrar empleado a destajo.
3. Mostrar salarios.
4. Eliminar empleado por DNI.
5. Mostrar datos de un empleado por DNI.
6. Salir.

Se aplica polimorfismo al trabajar con `Empleado` como tipo base.

---

## Actividad 7 – Electrodomésticos

Crear paquete `actividad7`.

### Clase `Electrodomestico`
Atributos:
- precioBase
- color
- consumoEnergetico (A–F)
- peso

Valores por defecto:
- blanco
- F
- 100 €
- 5 kg

Constructores:
- Por defecto.
- Con precio y peso.
- Con todos los atributos.

Métodos:
- Getters.
- `comprobarConsumoEnergetico()`
- `comprobarColor()`
- `precioFinal()`:
  - Incremento según consumo energético.
  - Incremento según peso.

### Clase `Lavadora` (hereda de Electrodomestico)
- Atributo: carga.
- Si carga > 30 kg → +50 €.
- Sobrescribe `precioFinal()` llamando al método padre.

### Clase `Television` (hereda de Electrodomestico)
- Atributos:
  - resolucion
  - sintonizadorTDT
- Si resolución > 40" → +30%.
- Si tiene TDT → +50 €.
- Sobrescribe `precioFinal()`.

### Clase ejecutable
- Crear array de 10 Electrodomesticos.
- Llenarlo con objetos.
- Calcular precio final.
- Mostrar:
  - Total electrodomésticos.
  - Total lavadoras.
  - Total televisiones.
- Uso obligatorio de `instanceof`.
---

## Actividad 8 – Sonidos de animales v.1

Crear paquete `actividad8`.

### Clase `Animal`
- Método: `emiteSonido()`

### Clases que heredan de `Animal`
- `Perro`
- `Gato`
- `Canario`

Cada una implementa `emiteSonido()` mostrando su sonido correspondiente.

### Clase `EmisorSonidos`
- Recibe un parámetro de tipo `Animal`.
- Invoca el método `emiteSonido()`.

### Aplicación principal
- Crear tres animales (uno de cada tipo).
- Reproducir sus sonidos utilizando `EmisorSonidos`.

Conceptos aplicados:
- Herencia
- Polimorfismo
- Desacoplamiento básico

---

## Actividad 9 – Sonidos de animales v.2

Crear paquete `actividad9`.

### Clase `RelojCucu`
- Método `emiteSonido()` que devuelve "Cu... Cu".

### Modificación del diseño anterior
- Generalizar `EmisorSonidos` para que pueda emitir el sonido de cualquier clase que tenga el método correspondiente.
- Aplicar diseño más flexible (mayor desacoplamiento).

Conceptos aplicados:
- Generalización
- Diseño más abierto
- Principio de sustitución

---

## Actividad 10 – Pila

Crear paquete `actividad10`.

### Interfaz `Pila`

Debe definir los siguientes métodos:

- `insertar()`
- `quitar()`
- `pilaVacia()`
- `pilaLlena()`
- `limpiarPila()`
- `tamano()`

La pila debe comportarse como una estructura LIFO (Last In, First Out).

---

### Clase `PilaVector`

- Implementa la interfaz `Pila`.
- Utiliza un array como estructura interna.

---

### Clase `PilaLista`

- Implementa la interfaz `Pila`.
- Utiliza un `ArrayList` como estructura interna.

---

### Clase `AppPila`

- Método `main`.
- Permite probar ambas implementaciones.
- Verifica el correcto funcionamiento de la interfaz.

Conceptos aplicados:
- Interfaces
- Implementaciones múltiples
- Sustitución polimórfica
- Diseño por contrato
---

## Objetivo global de la Unidad

Esta unidad tiene como finalidad consolidar:

- Diseño de jerarquías de clases
- Uso correcto de herencia
- Sobrescritura de métodos
- Aplicación de polimorfismo real
- Uso de clases abstractas
- Implementación de interfaces
- Trabajo con colecciones de objetos polimórficos

Además, se busca reforzar:

- Organización del código
- Diseño estructurado
- Separación de responsabilidades
- Buenas prácticas en Programación Orientada a Objetos