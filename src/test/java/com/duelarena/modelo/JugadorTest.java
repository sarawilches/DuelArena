package com.duelarena.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    @Test
    void jugadorIniciaConOchoMilLP() {
        Jugador jugador = new Jugador();
        assertEquals(8000, jugador.getPuntosVida());
    }

    @Test
    void recibirDanioNoPermitePuntosNegativos() {
        Jugador jugador = new Jugador();
        assertEquals(8000, jugador.recibirDanio(9000, "Prueba"));
        assertEquals(0, jugador.getPuntosVida());
    }

    @Test
    void validaEstadisticasDeCarta() {
        CartaMonstruo carta = new MonstruoNormal("Carta", 100, 100, Posicion.ATAQUE);
        assertThrows(IllegalArgumentException.class, () -> carta.setAtaque(10000));
        assertThrows(IllegalArgumentException.class, () -> carta.setDefensa(-1));
    }

    @Test
    void obtieneColeccionDeCartasNoModificable() {
        Jugador jugador = new Jugador();
        CartaMonstruo carta = new MonstruoNormal("Carta", 100, 100, Posicion.ATAQUE);
        jugador.agregarCarta(carta);
        assertThrows(UnsupportedOperationException.class,
                () -> jugador.getCartas().add(new MonstruoNormal("Otra", 1, 1, Posicion.ATAQUE)));
    }
}
