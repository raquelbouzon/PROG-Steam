package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoResenaEnum;

import java.time.LocalDateTime;

public record ResenaDto(
        Long id,
        Long usuarioId,
        Long juegoId,
        Boolean recomendado,
        String texto,
        Double horasJugadas,
        LocalDateTime fechaPublicacion,
        LocalDateTime fechaUltimaEdicion,
        EstadoResenaEnum.Estado estado
) {
}

