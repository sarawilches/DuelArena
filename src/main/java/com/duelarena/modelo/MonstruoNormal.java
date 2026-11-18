package com.duelarena.modelo;

/** Primera subclase concreta de CartaMonstruo. */
public class MonstruoNormal extends CartaMonstruo {

    /** Constructor solicitado para una de las subclases del diagrama UML. */
    public MonstruoNormal(String nombre, int ataque, int defensa, Posicion posicion) {
        setNombre(nombre);
        setAtaque(ataque);
        setDefensa(defensa);
        setPosicion(posicion);
    }

    @Override
    public String getTipoCarta() {
        return "Normal";
    }
}
