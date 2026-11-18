package com.duelarena.modelo;

/** Segunda subclase concreta de CartaMonstruo. */
public class MonstruoEfecto extends CartaMonstruo {
    private String descripcionEfecto = "Sin efecto descrito";

    public String getDescripcionEfecto() {
        return descripcionEfecto;
    }

    public void setDescripcionEfecto(String descripcionEfecto) {
        if (descripcionEfecto == null || descripcionEfecto.isBlank()) {
            this.descripcionEfecto = "Sin efecto descrito";
        } else {
            this.descripcionEfecto = descripcionEfecto.trim();
        }
    }

    @Override
    public String getTipoCarta() {
        return "Efecto";
    }
}
