package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoInstalacionEnum;

import java.time.LocalDate;

public record BibliotecaDto(
        Long id,
        Long usuarioId,
        Long juegoId,
        LocalDate fechaAdquisicion,
        Double tiempoJuegoTotal,
        LocalDate ultimaFechaJuego,
        EstadoInstalacionEnum.Estado estadoInstalacion
){

}
