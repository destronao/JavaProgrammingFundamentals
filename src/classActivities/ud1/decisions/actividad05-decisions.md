# Defensa de decisiones técnicas  
## Actividad 5 – Cálculo del volumen de una esfera

Este documento recoge las **decisiones técnicas tomadas** durante la implementación del ejercicio **Actividad 5 – Esfera**, así como la justificación de cada una de ellas.  
El objetivo no es solo explicar *qué* se hizo, sino *por qué* se hizo de ese modo.

---

## 1. Separación entre entrada de datos y lógica de cálculo

**Decisión**  
La validación del radio (no permitir valores negativos) se realiza en el método de cálculo del volumen y no en el método de entrada por teclado.

**Justificación**  
Se tomó esta decisión para separar claramente la **entrada de datos** de la **lógica del dominio**.  
El hecho de que el radio no pueda ser negativo es una regla propia del problema matemático, no de cómo se obtiene el dato.

De este modo:
- el método de cálculo es seguro independientemente del origen del dato
- se evita duplicar validaciones si el método se reutiliza en otro contexto
- se mejora la claridad y mantenibilidad del código

---

## 2. Uso de `IllegalArgumentException` para radios negativos

**Decisión**  
Se lanza una `IllegalArgumentException` cuando el radio es negativo.

**Justificación**  
El tipo del parámetro (`double`) es correcto, pero su **valor no cumple las reglas del método**.  
Por tanto, `IllegalArgumentException` es la excepción estándar y más adecuada para este caso.

Esta decisión deja claro que:
- el error no es de formato ni de entrada
- el método no acepta ciertos valores por definición
- la responsabilidad del error recae en quien invoca el método con un valor inválido

---

## 3. Cálculo de la potencia sin usar `Math.pow`

**Decisión**  
La potencia del radio se calcula mediante multiplicaciones (`radius * radius * radius`) en lugar de usar `Math.pow`.

**Justificación**  
El enunciado del ejercicio indicaba explícitamente no utilizar la clase `Math`.  
El objetivo didáctico era practicar:
- el uso de constantes
- operaciones básicas
- comprensión de fórmulas matemáticas

Aunque `Math.pow` mejoraría la legibilidad, en este contexto se priorizó **respetar el enunciado y su intención didáctica**.  
Soy consciente de que en un entorno real podría ser preferible usar `Math.pow`.

---

## 4. Uso de un bucle con `try-catch` para la lectura del radio

**Decisión**  
Se utiliza un bucle `while` con `try-catch` para asegurar una entrada válida del usuario.

**Justificación**  
El objetivo era garantizar que el programa no finalizara ante una entrada incorrecta y que el usuario pudiera corregirla.  
Este enfoque permite:
- capturar errores de formato
- limpiar la entrada inválida
- solicitar el dato de nuevo de forma controlada

En consola, métodos como `hasNextDouble()` no siempre evitan problemas como tokens inválidos persistentes, por lo que el uso de excepciones resulta más robusto en este contexto.

---

## 5. Uso de una constante `PI = 3.14`

**Decisión**  
Se define una constante `PI` con valor `3.14`.

**Justificación**  
El enunciado indicaba explícitamente el valor de PI y no permitía el uso de `Math.PI`.  
En este contexto, el objetivo no es la máxima precisión matemática, sino:
- aprender a definir constantes
- utilizarlas correctamente en cálculos

Aumentar la precisión habría alterado el resultado esperado y se habría desviado del propósito del ejercicio.  
En un entorno real o científico, sería imprescindible usar una constante más precisa.

---

## 6. Cierre del `Scanner` asociado a `System.in`

**Decisión**  
El `Scanner` se cierra al final del método `main`.

**Justificación**  
En este programa:
- el `Scanner` vive durante todo el ciclo de vida de la aplicación
- cerrar el recurso no genera conflictos

El cierre se incluyó como **buena práctica didáctica**, reforzando la idea de que los recursos abiertos deben cerrarse.  
Soy consciente de que en aplicaciones más complejas o con una CLI persistente no sería recomendable cerrar un `Scanner` asociado a `System.in`, ya que impediría futuras lecturas.

---

## 7. Inclusión de validaciones y excepciones en un ejercicio básico

**Decisión**  
Se añadieron validaciones y control de errores aunque no eran estrictamente necesarios para resolver el ejercicio.

**Justificación**  
El objetivo principal del ejercicio se mantuvo simple y acorde al nivel solicitado.  
Las mejoras añadidas:
- no aumentan la complejidad del cálculo
- refuerzan la claridad del código
- permiten practicar buenas prácticas desde ejercicios básicos

Se trata de una decisión consciente orientada al aprendizaje, no de sobreingeniería.

---

## Conclusión

Las decisiones tomadas buscan un equilibrio entre:
- cumplir estrictamente el enunciado
- mantener el ejercicio accesible
- practicar buenas prácticas de programación

El foco no ha sido solo “que funcione”, sino **entender y justificar cada decisión técnica** dentro del contexto del ejercicio.
