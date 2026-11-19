package com.duelarena.modelo;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

class HistorialCombateTest {
    @TempDir
    Path carpetaTemporal;

    @Test
    void guardaYLeeElResultadoDeCombate() throws Exception {
        HistorialCombate historial = new HistorialCombate();
        Path archivo = carpetaTemporal.resolve("historial_combate.txt");
        historial.setArchivo(archivo);
        ResultadoCombate resultado = new ResultadoCombate(
                "Yugi", "Mago Oscuro", "Kaiba", "Dragon Blanco", 500,
                "El defensor perdió 500 LP", false, true);

        historial.guardarResultado(resultado);

        assertEquals(1, historial.leerRegistros().size());
        assertTrue(historial.leerRegistros().get(0).contains("Mago Oscuro"));
        assertTrue(historial.leerRegistros().get(0).contains("Daño LP: 500"));
    }
}
