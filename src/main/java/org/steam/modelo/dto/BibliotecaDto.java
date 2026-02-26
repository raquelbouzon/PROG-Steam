package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoInstalacionEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BibliotecaDto(
        Long id,
        Long usuarioId,
        Long juegoId,
        LocalDate fechaAdquisicion,
        Double tiempoJuegoTotal,
        LocalDateTime ultimaFechaJuego,
        EstadoInstalacionEnum.Estado estadoInstalacion
){

}
