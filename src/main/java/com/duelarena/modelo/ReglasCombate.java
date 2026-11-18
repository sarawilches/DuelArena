package com.duelarena.modelo;

/** Contrato de las reglas para resolver ataques entre monstruos o directos. */
public interface ReglasCombate {
    ResultadoCombate atacar(Jugador atacante, CartaMonstruo cartaAtacante,
                            Jugador defensor, CartaMonstruo cartaDefensora);

    ResultadoCombate atacar(Jugador atacante, CartaMonstruo cartaAtacante,
                            Jugador defensor);
}
