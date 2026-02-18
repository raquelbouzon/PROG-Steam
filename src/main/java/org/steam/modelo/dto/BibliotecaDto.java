package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoInstalacionEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BibliotecaDto {

    private long id;
    private long usuarioId;
    private long juegoId;
    private LocalDate fechaAdquisicion;
    private double tiempoJuegoTotal;
    private LocalDateTime ultimaFechaJuego;
    private EstadoInstalacionEnum.Estado estadoInstalacion;

}
