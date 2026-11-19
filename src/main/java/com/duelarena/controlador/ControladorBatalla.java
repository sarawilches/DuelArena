package com.duelarena.controlador;

import com.duelarena.modelo.CartaMonstruo;
import com.duelarena.modelo.HistorialCombate;
import com.duelarena.modelo.Jugador;
import com.duelarena.modelo.MonstruoEfecto;
import com.duelarena.modelo.MonstruoNormal;
import com.duelarena.modelo.MotorCombate;
import com.duelarena.modelo.Posicion;
import com.duelarena.modelo.ResultadoCombate;
import com.duelarena.vista.VistaPrincipal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Coordina la vista con las clases del modelo (patrón MVC). */
public class ControladorBatalla {
    private final VistaPrincipal vista;
    private final MotorCombate motor = new MotorCombate();
    private final HistorialCombate historial = new HistorialCombate();
    private final List<ResultadoCombate> resultados = new ArrayList<>();
    private Jugador jugador1;
    private Jugador jugador2;

    public ControladorBatalla(VistaPrincipal vista) {
        this.vista = vista;
        conectarEventos();
    }

    private void conectarEventos() {
        vista.onIniciar(e -> iniciarDuelo());
        vista.onAgregarCarta(e -> agregarCarta());
        vista.onCambioJugadorAtacante(e -> actualizarListasCombate());
        vista.onAtacar(e -> atacarMonstruo());
        vista.onAtaqueDirecto(e -> atacarDirectamente());
        vista.onReportes(e -> mostrarReportes());
    }

    private void iniciarDuelo() {
        try {
            String nombre1 = vista.getNombreJugador1().trim();
            String nombre2 = vista.getNombreJugador2().trim();
            if (nombre1.isBlank() || nombre2.isBlank()) {
                throw new IllegalArgumentException("Debes escribir el nombre de los dos jugadores.");
            }
            if (nombre1.equalsIgnoreCase(nombre2)) {
                throw new IllegalArgumentException("Los jugadores deben tener nombres diferentes.");
            }
            jugador1 = new Jugador();
            jugador2 = new Jugador();
            jugador1.setNombre(nombre1);
            jugador2.setNombre(nombre2);
            resultados.clear();
            vista.setPuntosVida(jugador1.getNombre(), jugador1.getPuntosVida(),
                    jugador2.getNombre(), jugador2.getPuntosVida());
            actualizarListasCombate();
            vista.agregarAlHistorial("Duelo iniciado: " + nombre1 + " vs " + nombre2 + ". Ambos comienzan con 8000 LP.");
        } catch (IllegalArgumentException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void agregarCarta() {
        if (!dueloIniciado()) return;
        try {
            String nombre = vista.getNombreCarta().trim();
            int ataque = Integer.parseInt(vista.getAtaqueTexto().trim());
            int defensa = Integer.parseInt(vista.getDefensaTexto().trim());
            Posicion posicion = vista.getIndicePosicion() == 0 ? Posicion.ATAQUE : Posicion.DEFENSA;

            CartaMonstruo carta;
            if (vista.getIndiceTipo() == 0) {
                carta = new MonstruoNormal(nombre, ataque, defensa, posicion);
            } else {
                MonstruoEfecto efecto = new MonstruoEfecto();
                efecto.setNombre(nombre);
                efecto.setAtaque(ataque);
                efecto.setDefensa(defensa);
                efecto.setPosicion(posicion);
                efecto.setDescripcionEfecto(vista.getEfectoTexto());
                carta = efecto;
            }

            Jugador dueno = vista.getIndiceDueno() == 0 ? jugador1 : jugador2;
            dueno.agregarCarta(carta);
            vista.agregarAlHistorial("Carta agregada para " + dueno.getNombre() + ": " + carta);
            actualizarListasCombate();
        } catch (NumberFormatException ex) {
            vista.mostrarError("ATQ y DEF deben ser números enteros. No escribas letras ni decimales.");
        } catch (IllegalArgumentException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void atacarMonstruo() {
        if (!dueloIniciado()) return;
        try {
            Jugador atacante = obtenerJugadorAtacante();
            Jugador defensor = obtenerJugadorDefensor();
            ResultadoCombate resultado = motor.atacar(atacante, vista.getCartaAtacanteSeleccionada(),
                    defensor, vista.getCartaDefensoraSeleccionada());
            procesarResultado(resultado);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void atacarDirectamente() {
        if (!dueloIniciado()) return;
        try {
            ResultadoCombate resultado = motor.atacar(obtenerJugadorAtacante(),
                    vista.getCartaAtacanteSeleccionada(), obtenerJugadorDefensor());
            procesarResultado(resultado);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void procesarResultado(ResultadoCombate resultado) {
        resultados.add(resultado);
        try {
            historial.guardarResultado(resultado);
        } catch (IOException ex) {
            vista.agregarAlHistorial("ADVERTENCIA: el ataque se calculó, pero no se pudo escribir el archivo: " + ex.getMessage());
        }
        vista.agregarAlHistorial(resultado.toLineaHistorial());
        actualizarPuntosVida();
        actualizarListasCombate();
        if (jugador1.getPuntosVida() == 0 || jugador2.getPuntosVida() == 0) {
            Jugador ganador = jugador1.getPuntosVida() > 0 ? jugador1 : jugador2;
            vista.mostrarInformacion("¡Duelo terminado! Ganador: " + ganador.getNombre() + ".");
        }
    }

    private void actualizarListasCombate() {
        if (!dueloIniciado()) {
            vista.setCartasAtacantes(List.of());
            vista.setCartasDefensoras(List.of());
            return;
        }
        Jugador atacante = obtenerJugadorAtacante();
        Jugador defensor = obtenerJugadorDefensor();
        List<CartaMonstruo> cartasAtacantes = atacante.getMonstruosActivos().stream()
                .filter(carta -> carta.getPosicion() == Posicion.ATAQUE).toList();
        vista.setCartasAtacantes(cartasAtacantes);
        vista.setCartasDefensoras(defensor.getMonstruosActivos());
    }

    private void actualizarPuntosVida() {
        vista.setPuntosVida(jugador1.getNombre(), jugador1.getPuntosVida(),
                jugador2.getNombre(), jugador2.getPuntosVida());
    }

    private Jugador obtenerJugadorAtacante() {
        return vista.getIndiceJugadorAtacante() == 0 ? jugador1 : jugador2;
    }

    private Jugador obtenerJugadorDefensor() {
        return vista.getIndiceJugadorAtacante() == 0 ? jugador2 : jugador1;
    }

    private boolean dueloIniciado() {
        if (jugador1 == null || jugador2 == null) {
            vista.mostrarError("Primero inicia el duelo y registra los dos jugadores.");
            return false;
        }
        return true;
    }

    private void mostrarReportes() {
        if (!dueloIniciado()) return;
        StringBuilder reporte = new StringBuilder();
        reporte.append("REPORTE 1 - ESTADO DE JUGADORES\n")
                .append(jugador1.getNombre()).append(": ").append(jugador1.getPuntosVida())
                .append(" LP | Monstruos activos: ").append(jugador1.getMonstruosActivos().size()).append('\n')
                .append(jugador2.getNombre()).append(": ").append(jugador2.getPuntosVida())
                .append(" LP | Monstruos activos: ").append(jugador2.getMonstruosActivos().size()).append("\n\n")
                .append("REPORTE 2 - RESUMEN DE COMBATES\n")
                .append("Turnos registrados: ").append(resultados.size()).append('\n');
        int danoTotal = resultados.stream().mapToInt(ResultadoCombate::getDanioLP).sum();
        long destrucciones = resultados.stream().filter(r -> r.isAtacanteDestruido() || r.isDefensorDestruido()).count();
        reporte.append("Daño total aplicado a LP: ").append(danoTotal).append('\n')
                .append("Combates con al menos un monstruo destruido: ").append(destrucciones).append('\n');
        vista.agregarAlHistorial("\n" + reporte);
        vista.mostrarInformacion(reporte.toString());
    }
}
