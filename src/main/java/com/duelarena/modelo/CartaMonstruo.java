package com.duelarena.modelo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase base abstracta para las cartas de monstruo.
 * Centraliza el encapsulamiento, validaciones, getters, setters y toString.
 */
public abstract class CartaMonstruo {
    private static final AtomicInteger SECUENCIA = new AtomicInteger(1);
    public static final int MAX_ESTADISTICA = 9999;

    private final int id = SECUENCIA.getAndIncrement();
    private String nombre = "Monstruo sin nombre";
    private int ataque;
    private int defensa;
    private Posicion posicion = Posicion.ATAQUE;
    private boolean destruido;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la carta es obligatorio.");
        }
        this.nombre = nombre.trim();
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        validarEstadistica(ataque, "ATQ");
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        validarEstadistica(defensa, "DEF");
        this.defensa = defensa;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException("La posición no puede ser nula.");
        }
        this.posicion = posicion;
    }

    public boolean isDestruido() {
        return destruido;
    }

    public void marcarDestruido() {
        destruido = true;
    }

    public abstract String getTipoCarta();

    private void validarEstadistica(int valor, String atributo) {
        if (valor < 0 || valor > MAX_ESTADISTICA) {
            throw new IllegalArgumentException(atributo + " debe estar entre 0 y " + MAX_ESTADISTICA + ".");
        }
    }

    @Override
    public String toString() {
        String estado = destruido ? " - DESTRUIDO" : "";
        return nombre + " | ATQ " + ataque + " | DEF " + defensa + " | " + posicion + " | " + getTipoCarta() + estado;
    }
}
