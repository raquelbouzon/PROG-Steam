package org.steam.modelo.entity;

import org.steam.modelo.enums.EstadoResenaEnum;

import java.time.LocalDateTime;

public class ResenhaEntity {
    private long id;
    private long usuarioId;
    private long juegoId;
    private boolean recomendado;
    private String textoResena;
    private double horasJugadas;
    private LocalDateTime fechaPublicacion;
    private LocalDateTime fechaUltimaEdicion;
    private EstadoResenaEnum.Estado estado;
}
