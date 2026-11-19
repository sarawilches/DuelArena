package com.duelarena;

import com.duelarena.modelo.CartaMonstruo;
import com.duelarena.modelo.Jugador;
import com.duelarena.modelo.MonstruoNormal;
import com.duelarena.modelo.Posicion;
import com.duelarena.modelo.ResultadoCombate;
import com.duelarena.controlador.ControladorBatalla;
import com.duelarena.vista.VistaPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Punto de entrada. También genera dos reportes sobre colecciones dinámicas. */
public class Main {

    public static void main(String[] args) {
        imprimirReportesDeEjemplo();
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
                // Se conserva el Look & Feel por defecto si el sistema no permite cambiarlo.
            }
            VistaPrincipal vista = new VistaPrincipal();
            new ControladorBatalla(vista);
            vista.setVisible(true);
        });
    }

    /**
     * Reporte 1: información de jugadores almacenados en una ArrayList.
     * Reporte 2: inventario/estadísticas de cartas almacenadas en otra ArrayList.
     */
    public static List<String> generarDosReportes(List<Jugador> jugadores,
                                                   List<CartaMonstruo> cartas,
                                                   List<ResultadoCombate> resultados) {
        List<String> reportes = new ArrayList<>();
        StringBuilder reporteJugadores = new StringBuilder("REPORTE 1 - JUGADORES\n");
        for (Jugador jugador : jugadores) {
            reporteJugadores.append(jugador.getNombre()).append(" | LP: ")
                    .append(jugador.getPuntosVida()).append(" | Cartas: ")
                    .append(jugador.getCartas().size()).append('\n');
        }
        reportes.add(reporteJugadores.toString());

        double promedioAtaque = cartas.isEmpty() ? 0.0
                : cartas.stream().mapToInt(CartaMonstruo::getAtaque).average().orElse(0.0);
        long monstruosDestruidos = cartas.stream().filter(CartaMonstruo::isDestruido).count();
        String reporteCartas = "REPORTE 2 - CARTAS Y COMBATES\n"
                + "Cartas registradas: " + cartas.size() + "\n"
                + "Promedio ATQ: " + String.format(java.util.Locale.US, "%.2f", promedioAtaque) + "\n"
                + "Monstruos destruidos: " + monstruosDestruidos + "\n"
                + "Turnos registrados: " + resultados.size();
        reportes.add(reporteCartas);
        return reportes;
    }

    private static void imprimirReportesDeEjemplo() {
        List<Jugador> jugadores = new ArrayList<>();
        List<CartaMonstruo> cartas = new ArrayList<>();
        List<ResultadoCombate> resultados = new ArrayList<>();

        Jugador yugi = new Jugador();
        yugi.setNombre("Yugi Muto");
        Jugador kaiba = new Jugador();
        kaiba.setNombre("Seto Kaiba");
        CartaMonstruo mago = new MonstruoNormal("Mago Oscuro", 2500, 2100, Posicion.ATAQUE);
        CartaMonstruo dragon = new MonstruoNormal("Dragon Blanco", 3000, 2500, Posicion.ATAQUE);
        yugi.agregarCarta(mago);
        kaiba.agregarCarta(dragon);
        jugadores.add(yugi);
        jugadores.add(kaiba);
        cartas.add(mago);
        cartas.add(dragon);

        System.out.println("========== REPORTES DE EJEMPLO ==========");
        for (String reporte : generarDosReportes(jugadores, cartas, resultados)) {
            System.out.println(reporte);
            System.out.println();
        }
    }
}
