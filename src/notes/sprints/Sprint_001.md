# Sprint UD5-01
Unidad 5 – Herencia y Polimorfismo

---

## 1. Contexto

Este sprint forma parte del módulo de Programación (DAM) y tiene como finalidad aplicar de forma estructurada y profesional los conceptos de:

- Herencia
- Sobrescritura de métodos
- Uso de `super`
- Clases abstractas
- Polimorfismo
- Uso de `instanceof`
- Interfaces
- Colecciones con objetos polimórficos

Las actividades corresponden a la Unidad 5 del módulo (la Unidad 1 fue únicamente de configuración del entorno y no forma parte del proyecto).

Este sprint forma parte de la adopción de un enfoque ágil personal basado en Scrum para organizar el desarrollo académico con estándares profesionales.

---

## 2. Sprint Goal

Implementar correctamente los principios de herencia y polimorfismo mediante la resolución completa y profesional de las actividades 1 a 10 de la Unidad 5, asegurando:

- Código estructurado y legible
- Uso correcto de herencia
- Aplicación real de polimorfismo
- Implementación de clases abstractas
- Uso de interfaces
- Documentación mínima con Javadoc
- Organización profesional del repositorio

---

## 3. Duración del Sprint

- Duración estimada: 7 días
- Inicio: 25/02/2026
- Fin prevista: 03/03/2026

---

## 4. Alcance del Sprint

Este sprint incluye la implementación completa de las siguientes actividades:

- Actividad 1 – Curso
- Actividad 2 – Vehículo
- Actividad 3 – Vehículo (ampliación)
- Actividad 4 – Banco
- Actividad 5 – Empleados
- Actividad 6 – Empleados (ampliación con lista y menú)
- Actividad 7 – Electrodomésticos
- Actividad 8 – Sonidos de animales v1
- Actividad 9 – Sonidos de animales v2
- Actividad 10 – Pila

---

## 5. Resumen Técnico de las Actividades

### Actividad 1 – Curso

- Clase `Persona`
- Clase `Alumno` que hereda de `Persona`
- Clase `Profesor` que hereda de `Persona`
- Clase principal para pruebas

Conceptos aplicados:
- Herencia básica
- Acceso a atributos heredados
- Métodos propios y heredados

---

### Actividad 2 – Vehículo

- Clase `Vehiculo` con múltiples constructores
- Clase `Coche` que hereda de `Vehiculo`
- Sobrescritura de `toString`

Conceptos aplicados:
- Uso de `super`
- Sobrecarga de constructores
- Sobrescritura de métodos

---

### Actividad 3 – Moto

- Clase `Moto` que hereda de `Vehiculo`
- Ampliación de la jerarquía

Conceptos aplicados:
- Especialización
- Reutilización de constructores base

---

### Actividad 4 – Banco

- Clase `Titular`
- Clase `CuentaCorriente`
- Clase `CuentaAhorro` que hereda de `CuentaCorriente`
- Cálculo de intereses

Conceptos aplicados:
- Especialización de clases
- Encapsulación
- Sobrescritura

---

### Actividad 5 – Empleados

- Clase abstracta `Empleado`
- Clases `EContratado` y `EDestajo`
- Implementación de método abstracto `getSalario()`

Conceptos aplicados:
- Clases abstractas
- Polimorfismo
- Implementación obligatoria de métodos

---

### Actividad 6 – ListaEmpleados

- Uso de `ArrayList<Empleado>`
- Registro dinámico
- Eliminación por DNI
- Menú interactivo

Conceptos aplicados:
- Polimorfismo real
- Colecciones de objetos base
- Gestión dinámica

---

### Actividad 7 – Electrodomésticos

- Clase base `Electrodomestico`
- Subclases `Lavadora` y `Television`
- Método `precioFinal()` sobrescrito
- Uso de `instanceof`

Conceptos aplicados:
- Polimorfismo
- Sobrescritura acumulativa
- Jerarquía de clases

---

### Actividad 8 – Sonidos v1

- Clase `Animal`
- Subclases: `Perro`, `Gato`, `Canario`
- Método `emiteSonido()`

Conceptos aplicados:
- Polimorfismo simple

---

### Actividad 9 – Sonidos v2

- Clase `RelojCucu`
- Generalización del emisor de sonidos

Conceptos aplicados:
- Abstracción
- Desacoplamiento

---

### Actividad 10 – Pila

- Interfaz `Pila`
- Implementación `PilaVector`
- Implementación `PilaLista`
- Clase `AppPila`

Conceptos aplicados:
- Interfaces
- Múltiples implementaciones
- Sustitución polimórfica

---

## 6. Sprint Backlog

Durante este sprint se desarrollará:

- Implementación completa de todas las clases
- Organización por paquetes independientes
- Añadido de Javadoc mínimo obligatorio
- Uso correcto de `@Override`
- Commits estructurados por actividad
- Pull Requests documentados
- Actualización de documentación del proyecto

---

## 7. Definition of Done

Una actividad se considera completada cuando:

- Compila sin errores
- No presenta warnings
- Usa correctamente herencia
- Implementa correctamente `super`
- Métodos sobrescritos marcados con `@Override`
- Clases abstractas implementadas correctamente
- Polimorfismo funcional
- Javadoc añadido en clases y métodos públicos
- Clase `main` funcional
- Commit documentado correctamente
- Pull Request creado y cerrado

---

## 8. Estrategia de Branching

Se utilizará la siguiente convención:

- `feature/ud5-actividad1`
- `feature/ud5-actividad2`
- ...
- `feature/ud5-actividad10`

Cada rama deberá:

- Incluir commits descriptivos
- Tener código funcional antes del PR
- Ser mergeada tras revisión personal

---

## 9. Riesgos Identificados

- Gestión de polimorfismo en listas (Actividad 6)
- Cálculo acumulativo de precios en Electrodomésticos
- Diseño correcto de interfaz en Pila
- Gestión de lógica en menú interactivo

---

## 10. Métricas del Sprint

Se evaluará:

- Número de actividades completadas
- Tiempo real invertido frente a estimado
- Calidad de commits
- Calidad de documentación
- Nivel de coherencia en arquitectura

---

## 11. Resultado Esperado

Al finalizar este sprint se habrá consolidado:

- Dominio práctico de herencia
- Uso correcto de clases abstractas
- Aplicación real de polimorfismo
- Uso correcto de interfaces
- Organización profesional del proyecto académico
- Aplicación formal de metodología ágil a desarrollo personal