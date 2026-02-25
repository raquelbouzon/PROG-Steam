package org.steam.modelo.dto;

import org.steam.modelo.enums.ClasificacionEdadEnum;
import org.steam.modelo.enums.EstadoJuegoEnum;

import java.time.LocalDate;
import java.util.List;

public record JuegoDto(
        Long id,
        String titulo,
        String descripcion,
        String desarrollador,
        LocalDate fechaLanzamiento,
        Double precioBase,
        int descuentoActual,
        String categoria,
        ClasificacionEdadEnum.ClasificacionEdad clasificacionEdad,
        String[] idiomasDisponibles,
        EstadoJuegoEnum.Estado estado
) {
}
