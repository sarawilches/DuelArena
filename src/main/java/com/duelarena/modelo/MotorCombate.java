package com.duelarena.modelo;

/** Implementa las reglas de cálculo de daño de la fase de batalla. */
public class MotorCombate implements ReglasCombate {

    @Override
    public ResultadoCombate atacar(Jugador atacante, CartaMonstruo cartaAtacante,
                                   Jugador defensor, CartaMonstruo cartaDefensora) {
        validarAtaque(atacante, cartaAtacante, defensor);
        if (cartaDefensora == null || !defensor.contieneCarta(cartaDefensora) || cartaDefensora.isDestruido()) {
            throw new IllegalArgumentException("Selecciona un monstruo defensor activo del rival.");
        }

        int diferencia = cartaAtacante.getAtaque() -
                (cartaDefensora.getPosicion() == Posicion.ATAQUE
                        ? cartaDefensora.getAtaque() : cartaDefensora.getDefensa());
        int danio = 0;
        boolean atacanteDestruido = false;
        boolean defensorDestruido = false;
        String detalle;

        if (cartaDefensora.getPosicion() == Posicion.ATAQUE) {
            if (diferencia > 0) {
                cartaDefensora.marcarDestruido();
                defensorDestruido = true;
                danio = defensor.recibirDanio(diferencia, "Diferencia ATQ vs ATQ");
                detalle = cartaDefensora.getNombre() + " fue destruido. " + defensor.getNombre()
                        + " pierde " + danio + " LP.";
            } else if (diferencia < 0) {
                cartaAtacante.marcarDestruido();
                atacanteDestruido = true;
                danio = atacante.recibirDanio(-diferencia, "Diferencia ATQ vs ATQ");
                detalle = cartaAtacante.getNombre() + " fue destruido. " + atacante.getNombre()
                        + " pierde " + danio + " LP.";
            } else {
                cartaAtacante.marcarDestruido();
                cartaDefensora.marcarDestruido();
                atacanteDestruido = true;
                defensorDestruido = true;
                detalle = "Empate ATQ vs ATQ: ambos monstruos fueron destruidos. No hay daño a LP.";
            }
        } else {
            if (diferencia > 0) {
                cartaDefensora.marcarDestruido();
                defensorDestruido = true;
                detalle = cartaDefensora.getNombre() + " fue destruido en posición de defensa. No hay daño a LP.";
            } else if (diferencia < 0) {
                danio = atacante.recibirDanio(-diferencia, "Diferencia ATQ vs DEF");
                detalle = cartaAtacante.getNombre() + " no fue destruido, pero " + atacante.getNombre()
                        + " pierde " + danio + " LP.";
            } else {
                detalle = "ATQ igual a DEF: no se destruye ningún monstruo y no hay daño a LP.";
            }
        }

        return new ResultadoCombate(atacante.getNombre(), cartaAtacante.getNombre(),
                defensor.getNombre(), cartaDefensora.getNombre(), danio, detalle,
                atacanteDestruido, defensorDestruido);
    }

    /** Sobrecarga para ataques directos cuando el rival no tiene monstruos activos. */
    @Override
    public ResultadoCombate atacar(Jugador atacante, CartaMonstruo cartaAtacante, Jugador defensor) {
        validarAtaque(atacante, cartaAtacante, defensor);
        if (defensor.tieneMonstruosActivos()) {
            throw new IllegalStateException("No se permite un ataque directo: el rival tiene monstruos activos.");
        }
        int danio = defensor.recibirDanio(cartaAtacante.getAtaque(), "Ataque directo");
        String detalle = "Ataque directo: " + defensor.getNombre() + " pierde " + danio + " LP.";
        return new ResultadoCombate(atacante.getNombre(), cartaAtacante.getNombre(),
                defensor.getNombre(), "Ataque directo", danio, detalle, false, false);
    }

    private void validarAtaque(Jugador atacante, CartaMonstruo cartaAtacante, Jugador defensor) {
        if (atacante == null || defensor == null || atacante == defensor) {
            throw new IllegalArgumentException("Los jugadores del combate no son válidos.");
        }
        if (cartaAtacante == null || !atacante.contieneCarta(cartaAtacante) || cartaAtacante.isDestruido()) {
            throw new IllegalArgumentException("Selecciona un monstruo atacante activo del jugador.");
        }
        if (cartaAtacante.getPosicion() != Posicion.ATAQUE) {
            throw new IllegalStateException("Solo puede atacar un monstruo en posición de ataque.");
        }
        if (atacante.getPuntosVida() <= 0 || defensor.getPuntosVida() <= 0) {
            throw new IllegalStateException("El duelo ya terminó: un jugador llegó a 0 LP.");
        }
    }
}
