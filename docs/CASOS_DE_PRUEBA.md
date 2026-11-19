# Casos de prueba funcionales

Este documento resume los escenarios que valida la suite JUnit 5 incluida en `src/test/java`.

| Caso | Preparación | Acción | Resultado esperado |
|---|---|---|---|
| ATQ vs ATQ con diferencia positiva | Atacante 2500 ATQ, defensor 1800 ATQ | Resolver ataque | Se destruye el defensor y pierde 700 LP |
| ATQ vs ATQ empatado | Ambos monstruos con 2000 ATQ | Resolver ataque | Ambos monstruos son destruidos; ningún jugador pierde LP |
| ATQ vs DEF con ATQ mayor | Atacante 2500 ATQ, defensor 2000 DEF | Resolver ataque | Se destruye el defensor; no hay daño a LP |
| ATQ vs DEF con DEF mayor | Atacante 1500 ATQ, defensor 2000 DEF | Resolver ataque | El atacante sobrevive y su jugador pierde 500 LP |
| Ataque directo | Rival sin monstruos activos; atacante con 3000 ATQ | Resolver ataque directo | El rival pierde 3000 LP |
| Ataque directo bloqueado | Rival con al menos un monstruo activo | Intentar ataque directo | El motor rechaza la acción con excepción |
| Monstruo en defensa | Carta atacante en posición DEFENSA | Intentar atacar | El motor rechaza la acción |
| LP iniciales | Crear un jugador | Consultar puntos de vida | 8000 LP |
| Daño mayor que LP restantes | Jugador con 8000 LP | Aplicar 9000 de daño | El jugador queda en 0 LP, nunca negativo |
| Estadísticas inválidas | Carta con ATQ/DEF dentro del rango | Asignar valor negativo o superior a 9999 | Se lanza `IllegalArgumentException` |
| Persistencia | Resultado de combate y archivo temporal | Guardar y leer historial | Se recupera una línea con carta y daño |

## Ejecución

En NetBeans, clic derecho sobre el proyecto y selecciona **Test**. Desde terminal ejecuta `mvn test`.
