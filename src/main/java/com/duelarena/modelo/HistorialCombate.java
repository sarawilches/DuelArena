package com.duelarena.modelo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/** Persistencia simple del historial de ataques en un archivo de texto. */
public class HistorialCombate {
    private Path archivo = Path.of("historial_combate.txt");

    public Path getArchivo() {
        return archivo;
    }

    /** Permite inyectar una ruta temporal durante las pruebas unitarias. */
    public void setArchivo(Path archivo) {
        if (archivo == null) {
            throw new IllegalArgumentException("La ruta del historial no puede ser nula.");
        }
        this.archivo = archivo;
    }

    public void guardarResultado(ResultadoCombate resultado) throws IOException {
        if (resultado == null) {
            throw new IllegalArgumentException("No se puede guardar un resultado nulo.");
        }
        Path absoluto = archivo.toAbsolutePath();
        Path carpeta = absoluto.getParent();
        if (carpeta != null) {
            Files.createDirectories(carpeta);
        }
        Files.writeString(absoluto, resultado.toLineaHistorial() + System.lineSeparator(),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }

    public List<String> leerRegistros() throws IOException {
        if (Files.notExists(archivo)) {
            return List.of();
        }
        return Files.readAllLines(archivo, StandardCharsets.UTF_8);
    }
}
