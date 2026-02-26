package org.steam.modelo.entity;

import org.steam.modelo.enums.EstadoInstalacionEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BibliotecaEntity {

    private Long id;
    private Long usuarioId;
    private Long juegoId;
    private LocalDate fechaAdquisicion;
    private Double tiempoJuegoTotal;
    private LocalDateTime ultimaFechaJuego;
    private EstadoInstalacionEnum.Estado estadoInstalacion;


    public BibliotecaEntity(long id, long usuarioId, long juegoId, LocalDate fechaAdquisicion, double tiempoJuegoTotal, LocalDateTime ultimaFechaJuego, EstadoInstalacionEnum.Estado estadoInstalacion) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.juegoId = juegoId;
        this.fechaAdquisicion = fechaAdquisicion;
        this.tiempoJuegoTotal = tiempoJuegoTotal;
        this.ultimaFechaJuego = ultimaFechaJuego;
        this.estadoInstalacion = estadoInstalacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getJuegoId() {
        return juegoId;
    }

    public void setJuegoId(long juegoId) {
        this.juegoId = juegoId;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public double getTiempoJuegoTotal() {
        return tiempoJuegoTotal;
    }

    public void setTiempoJuegoTotal(double tiempoJuegoTotal) {
        this.tiempoJuegoTotal = tiempoJuegoTotal;
    }

    public LocalDateTime getUltimaFechaJuego() {
        return ultimaFechaJuego;
    }

    public void setUltimaFechaJuego(LocalDateTime ultimaFechaJuego) {
        this.ultimaFechaJuego = ultimaFechaJuego;
    }

    public EstadoInstalacionEnum.Estado getEstadoInstalacion() {
        return estadoInstalacion;
    }

    public void setEstadoInstalacion(EstadoInstalacionEnum.Estado estadoInstalacion) {
        this.estadoInstalacion = estadoInstalacion;
    }
}
