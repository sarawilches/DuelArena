package com.duelarena.modelo;

/** Posiciones disponibles para un monstruo durante la fase de batalla. */
public enum Posicion {
    ATAQUE("Ataque"),
    DEFENSA("Defensa");

    private final String etiqueta;

    Posicion(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}
