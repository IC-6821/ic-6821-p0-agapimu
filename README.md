[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/UThZxUa6)
IC-6821 Diseño de Software  
Prof. Diego Munguia Molina  
2024-II  
IC-AL  
---
# Proyecto 1

## Objetivos de aprendizaje

1. Explicar las mejores prácticas de nomenclatura en código limpio. (II)
2. Diseñar código partiendo de los principios de programación orientada a objetos (VI)

## Descripción

Queremos construir un juego de gato (también conocido como tic-tac-toe o equis-cero). La interacción solicitada es la siguiente:

```
$ ./gato -n f

   |   |
-----------
   |   |
-----------
   |   |

> abajo izquierda

   |   | O
-----------
   |   |
-----------
 X |   | 

> abajo derecha

   |   | O
-----------
   |   |
-----------
 X | O | X

> arriba izquierda

 X |   | O
-----------
 O |   |
-----------
 X | O | X

> medio centro

 X |   | O
-----------
 O | X |
-----------
 X | O | X

Has ganado!
```

### Requerimientos

* El usuario juega con las fichas X y mueve primero. El usuario juega contra el programa.
* El usuario realiza su jugada indicando adónde quiere colocar su ficha, especificando primero la fila (arriba, abajo, medio) y luego la columna (izquierda, centro, derecha).
* El programa coloca la ficha según lo indicado e inmediatamente responde con su propia jugada.
* Para esta versión, el software realizará sus jugadas con base en una estrategia totalmente aleatoria (que llamaremos nivel fácil -n f). En el futuro queremos implementar la dificultad media (nivel medio -n m) usando una estrategia que intente tomar primero las esquinas, luego el medio centro y finalmente el resto de los bloques centrales en ese orden. También en el futuro utilizaremos una estrategia de inteligencia artificial basada en el algoritmo minimax para el nivel más difícil (-n d).
* Cuando el jugador gana recibe un mensaje indicativo, lo mismo cuando pierde y cuando empata.
* En el futuro queremos reutilizar la misma lógica del juego con una interfaz de usuario web.


## Metodología

* El proyecto se trabajará en equipos.
* Cada equipo designará una persona con el rol de líder, este rol tiene tres responsabilidades: 
  - Coordinar reuniones de equipo
  - Coordinar asignación de tareas
  - Resolución de conflictos en la toma de decisiones
* Cada equipo designará dos personas con el rol de relatoras, estas personas tendrán la responsabilidad de tomar notas durante las reuniones de revisión que serán utilizadas posteriormente para hacer mejoras al código.
* El proyecto se desarrollará en el transcurso de dos semanas y tendrá dos entregas, una entrega parcial después de la primera semana de trabajo, y una entrega final después de la segunda semana de trabajo.
* El proyecto se desarrollará en Java siguiendo el paradigma de programación orientada a objetos.

## Rúbricas de evaluación

Disponible en el siguiente enlace:

https://docs.google.com/spreadsheets/d/1USg26rYw8OIymI4fb8bySdMU5kLPNxZVZ-fStmvigdQ


