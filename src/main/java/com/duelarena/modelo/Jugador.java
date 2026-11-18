package com.duelarena.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Representa a un duelista y administra sus puntos de vida y monstruos. */
public class Jugador {
    public static final int LP_INICIALES = 8000;

    private String nombre = "Jugador";
    private int puntosVida = LP_INICIALES;
    private final List<CartaMonstruo> cartas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del jugador es obligatorio.");
        }
        this.nombre = nombre.trim();
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        if (puntosVida < 0 || puntosVida > LP_INICIALES) {
            throw new IllegalArgumentException("Los LP deben estar entre 0 y " + LP_INICIALES + ".");
        }
        this.puntosVida = puntosVida;
    }

    /** Sobrecarga 1: aplica daño sin registrar un motivo. */
    public int recibirDanio(int cantidad) {
        return recibirDanio(cantidad, "Daño de combate");
    }

    /** Sobrecarga 2: aplica daño y recibe el motivo para el registro. */
    public int recibirDanio(int cantidad, String motivo) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("El daño no puede ser negativo.");
        }
        int aplicado = Math.min(cantidad, puntosVida);
        puntosVida -= aplicado;
        return aplicado;
    }

    public void agregarCarta(CartaMonstruo carta) {
        if (carta == null) {
            throw new IllegalArgumentException("No se puede agregar una carta nula.");
        }
        if (cartas.contains(carta)) {
            throw new IllegalArgumentException("La carta ya pertenece a este jugador.");
        }
        cartas.add(carta);
    }

    public List<CartaMonstruo> getCartas() {
        return Collections.unmodifiableList(cartas);
    }

    public boolean contieneCarta(CartaMonstruo carta) {
        return cartas.contains(carta);
    }

    public boolean tieneMonstruosActivos() {
        return cartas.stream().anyMatch(carta -> !carta.isDestruido());
    }

    public List<CartaMonstruo> getMonstruosActivos() {
        return cartas.stream().filter(carta -> !carta.isDestruido()).toList();
    }
}
