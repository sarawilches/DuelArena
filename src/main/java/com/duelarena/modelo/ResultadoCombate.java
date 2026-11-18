package com.duelarena.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Resultado inmutable de un ataque, usado por la interfaz y la persistencia. */
public class ResultadoCombate {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final LocalDateTime fecha;
    private final String jugadorAtacante;
    private final String cartaAtacante;
    private final String jugadorDefensor;
    private final String cartaDefensora;
    private final int danioLP;
    private final String resultado;
    private final boolean atacanteDestruido;
    private final boolean defensorDestruido;

    public ResultadoCombate(String jugadorAtacante, String cartaAtacante,
                            String jugadorDefensor, String cartaDefensora,
                            int danioLP, String resultado,
                            boolean atacanteDestruido, boolean defensorDestruido) {
        this.fecha = LocalDateTime.now();
        this.jugadorAtacante = jugadorAtacante;
        this.cartaAtacante = cartaAtacante;
        this.jugadorDefensor = jugadorDefensor;
        this.cartaDefensora = cartaDefensora;
        this.danioLP = danioLP;
        this.resultado = resultado;
        this.atacanteDestruido = atacanteDestruido;
        this.defensorDestruido = defensorDestruido;
    }

    public LocalDateTime getFecha() { return fecha; }
    public String getJugadorAtacante() { return jugadorAtacante; }
    public String getCartaAtacante() { return cartaAtacante; }
    public String getJugadorDefensor() { return jugadorDefensor; }
    public String getCartaDefensora() { return cartaDefensora; }
    public int getDanioLP() { return danioLP; }
    public String getResultado() { return resultado; }
    public boolean isAtacanteDestruido() { return atacanteDestruido; }
    public boolean isDefensorDestruido() { return defensorDestruido; }

    public String toLineaHistorial() {
        return FORMATO.format(fecha) + " | " + jugadorAtacante + " / " + cartaAtacante
                + " -> " + jugadorDefensor + " / " + cartaDefensora
                + " | Daño LP: " + danioLP
                + " | " + resultado;
    }

    @Override
    public String toString() {
        return toLineaHistorial();
    }
}
