# Duel Arena - Simulador de la fase de batalla Yu-Gi-Oh!

Proyecto de escritorio Java para el examen de Programación Orientada a Objetos. Está organizado con arquitectura **Modelo-Vista-Controlador (MVC)** y usa Swing mediante un formulario `JFrame` asociado a NetBeans.

## Requisitos

- Apache NetBeans 17 o superior (con soporte para proyectos Maven).
- JDK 17 o superior.
- Maven integrado en NetBeans.

## Abrir y ejecutar en NetBeans

1. Descomprime la carpeta `DuelArenaNetBeans`.
2. Abre NetBeans y selecciona **File > Open Project**.
3. Selecciona la carpeta que contiene `pom.xml`.
4. Espera a que NetBeans resuelva las dependencias de Maven.
5. Ejecuta **Clean and Build** y luego **Run** (la clase principal es `com.duelarena.Main`).
6. Para abrir el formulario, navega a `Source Packages > com.duelarena.vista > VistaPrincipal.java` y usa **Design**. El archivo de formulario asociado es `VistaPrincipal.form`; los 38 componentes están descritos con `GridBagLayout` para editarlos desde el diseñador visual.

También se puede ejecutar desde una terminal ubicada en la carpeta del proyecto:

```bash
mvn clean test
mvn clean package
java -jar target/duel-arena-yugioh-1.0.0.jar
```

## Uso de la aplicación

1. Escribe dos nombres distintos en **Jugador 1** y **Jugador 2**, y pulsa **Iniciar / reiniciar duelo**. Cada jugador comienza con 8000 LP.
2. Registra los monstruos indicando nombre, ATQ, DEF, dueño, posición y tipo. Para los monstruos de efecto puedes incluir una descripción.
3. En **Fase de batalla**, elige el jugador atacante y un monstruo en posición de ataque.
4. Selecciona un monstruo defensor para resolver ATQ vs ATQ o ATQ vs DEF. Usa **Ataque directo** solamente cuando el rival no tenga monstruos activos.
5. Los LP se muestran debajo de los controles; cada ataque se agrega al historial y se persiste en `historial_combate.txt`, en el directorio desde el cual se ejecuta el programa.
6. Pulsa **Generar reportes** para consultar el estado de los jugadores y el resumen de combates.

## Reglas implementadas

- **ATQ vs ATQ:** se destruye el monstruo con menor ATQ y su controlador pierde la diferencia de LP. Si empatan, ambos son destruidos y no hay daño.
- **ATQ vs DEF:** si ATQ supera DEF, se destruye el defensor sin daño a LP. Si ATQ es menor, el atacante no se destruye y su controlador pierde la diferencia. Si son iguales, no hay destrucción ni daño.
- **Ataque directo:** solo procede si el defensor no tiene monstruos activos; el defensor pierde LP iguales al ATQ del atacante.
- Los LP nunca bajan de cero. Solo atacan monstruos activos en posición de ataque.

## Arquitectura y requisitos del examen

| Requisito | Implementación |
|---|---|
| MVC | `modelo`, `vista` y `controlador` separados en paquetes |
| 5 o más clases | 10 clases principales, una interfaz y un enum |
| Herencia y dos subclases | `CartaMonstruo` abstracta; `MonstruoNormal` y `MonstruoEfecto` |
| Interface implementada | `ReglasCombate`, implementada por `MotorCombate` |
| Sobrecarga | `MotorCombate.atacar(...)` y `Jugador.recibirDanio(...)` |
| Sobreescritura | `getTipoCarta()` en las dos subclases |
| `static`, `final`, `abstract` | Constantes y secuencia estática; atributos finales; `CartaMonstruo` abstracta |
| Getters, setters y `toString` | Centralizados en `CartaMonstruo` (además de accesores específicos en otras clases) |
| Reportes en colecciones dinámicas | `Main.generarDosReportes(...)` procesa `ArrayList` de jugadores, cartas y resultados |
| Persistencia | `HistorialCombate` crea y amplía `historial_combate.txt` |
| JUnit | Pruebas para combate, LP, validaciones y persistencia |
| Diagrama UML | `diagrama_clases.pdf`, `diagramas/diagrama_clases.png` y fuente `.dot` |

## Pruebas unitarias

Las pruebas están en `src/test/java/com/duelarena/modelo`. En NetBeans, clic derecho al proyecto y selecciona **Test**. Desde consola:

```bash
mvn test
```

La dependencia JUnit 5 está declarada en `pom.xml`.

## Estructura

```text
DuelArenaNetBeans/
├── pom.xml
├── diagrama_clases.pdf
├── diagramas/
│   ├── diagrama_clases.dot
│   └── diagrama_clases.png
├── historial_combate.txt
├── src/
│   ├── main/java/com/duelarena/
│   │   ├── Main.java
│   │   ├── modelo/
│   │   ├── vista/
│   │   └── controlador/
│   └── test/java/com/duelarena/modelo/
└── docs/
```

## Git y GitHub

El proyecto incluye un historial Git local con cinco commits de implementación en la rama `feature/duel-arena` (autor local genérico: `Local Project Setup`). Para que también quede evidencia de tu participación personal, configura tu nombre/correo en Git y agrega tus propios commits antes de publicar. Para cumplir la parte remota del examen, crea un repositorio vacío en tu cuenta de GitHub y sigue `docs/GITHUB.md`. No se inventa un enlace remoto: el repositorio y el Pull Request deben crearse desde tu cuenta.

> El archivo `historial_combate.txt` incluye una línea de demostración para mostrar el formato de persistencia. La aplicación agrega al final los ataques reales de cada partida.
