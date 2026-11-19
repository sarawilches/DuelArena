package com.duelarena.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotorCombateTest {
    private MotorCombate motor;
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    void preparar() {
        motor = new MotorCombate();
        jugador1 = new Jugador();
        jugador1.setNombre("Yugi");
        jugador2 = new Jugador();
        jugador2.setNombre("Kaiba");
    }

    @Test
    void ataqueContraAtaqueDestruyeAlMenorYAplicaDiferencia() {
        CartaMonstruo atacante = new MonstruoNormal("Mago", 2500, 2100, Posicion.ATAQUE);
        CartaMonstruo defensor = new MonstruoNormal("Dragon", 1800, 1500, Posicion.ATAQUE);
        jugador1.agregarCarta(atacante);
        jugador2.agregarCarta(defensor);

        ResultadoCombate resultado = motor.atacar(jugador1, atacante, jugador2, defensor);

        assertTrue(defensor.isDestruido());
        assertFalse(atacante.isDestruido());
        assertEquals(7300, jugador2.getPuntosVida());
        assertEquals(700, resultado.getDanioLP());
    }

    @Test
    void ataqueContraAtaqueEmpateDestruyeAmbosSinDanio() {
        CartaMonstruo atacante = new MonstruoNormal("Mago", 2000, 1000, Posicion.ATAQUE);
        CartaMonstruo defensor = new MonstruoNormal("Guerrero", 2000, 1200, Posicion.ATAQUE);
        jugador1.agregarCarta(atacante);
        jugador2.agregarCarta(defensor);

        ResultadoCombate resultado = motor.atacar(jugador1, atacante, jugador2, defensor);

        assertTrue(atacante.isDestruido());
        assertTrue(defensor.isDestruido());
        assertEquals(8000, jugador1.getPuntosVida());
        assertEquals(8000, jugador2.getPuntosVida());
        assertEquals(0, resultado.getDanioLP());
    }

    @Test
    void ataqueContraDefensaDestruyeDefensorSinDanioCuandoAtaqueEsMayor() {
        CartaMonstruo atacante = new MonstruoNormal("Mago", 2500, 2100, Posicion.ATAQUE);
        CartaMonstruo defensor = new MonstruoNormal("Muro", 500, 2000, Posicion.DEFENSA);
        jugador1.agregarCarta(atacante);
        jugador2.agregarCarta(defensor);

        ResultadoCombate resultado = motor.atacar(jugador1, atacante, jugador2, defensor);

        assertTrue(defensor.isDestruido());
        assertFalse(atacante.isDestruido());
        assertEquals(8000, jugador1.getPuntosVida());
        assertEquals(0, resultado.getDanioLP());
    }

    @Test
    void ataqueContraDefensaAplicaDiferenciaAlAtacanteSinDestruirlo() {
        CartaMonstruo atacante = new MonstruoNormal("Mago", 1500, 2100, Posicion.ATAQUE);
        CartaMonstruo defensor = new MonstruoNormal("Muro", 500, 2000, Posicion.DEFENSA);
        jugador1.agregarCarta(atacante);
        jugador2.agregarCarta(defensor);

        ResultadoCombate resultado = motor.atacar(jugador1, atacante, jugador2, defensor);

        assertFalse(atacante.isDestruido());
        assertFalse(defensor.isDestruido());
        assertEquals(7500, jugador1.getPuntosVida());
        assertEquals(500, resultado.getDanioLP());
    }

    @Test
    void ataqueDirectoSoloSePermiteSinMonstruosActivos() {
        CartaMonstruo atacante = new MonstruoNormal("Dragon", 3000, 2500, Posicion.ATAQUE);
        jugador1.agregarCarta(atacante);

        ResultadoCombate resultado = motor.atacar(jugador1, atacante, jugador2);

        assertEquals(5000, jugador2.getPuntosVida());
        assertEquals(3000, resultado.getDanioLP());
        jugador2.agregarCarta(new MonstruoNormal("Defensor", 100, 1000, Posicion.DEFENSA));
        assertThrows(IllegalStateException.class, () -> motor.atacar(jugador1, atacante, jugador2));
    }

    @Test
    void monstruoEnDefensaNoPuedeAtacar() {
        CartaMonstruo atacante = new MonstruoNormal("Tortuga", 500, 2000, Posicion.DEFENSA);
        jugador1.agregarCarta(atacante);
        assertThrows(IllegalStateException.class, () -> motor.atacar(jugador1, atacante, jugador2));
    }
}
