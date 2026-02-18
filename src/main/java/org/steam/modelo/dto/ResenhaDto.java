package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoResenaEnum;

import java.time.LocalDateTime;

public class ResenhaDto {
    private long id;
    private long usuarioId;
    private long juegoId;
    private boolean recomendado;
    private String textoResena;
    private double horasJugadas;
    private LocalDateTime fechaPublicacion;
    private LocalDateTime fechaUltimaEdicion;
    private EstadoResenaEnum.Estado estado;

    public ResenhaDto(long id, long usuarioId, long juegoId, boolean recomendado,
                      String textoResena, double horasJugadas, LocalDateTime fechaPublicacion,
                      LocalDateTime fechaUltimaEdicion, EstadoResenaEnum.Estado estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.juegoId = juegoId;
        this.recomendado = recomendado;
        this.textoResena = textoResena;
        this.horasJugadas = horasJugadas;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaUltimaEdicion = fechaUltimaEdicion;
        this.estado = estado;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(long usuarioId) { this.usuarioId = usuarioId; }

    public long getJuegoId() { return juegoId; }
    public void setJuegoId(long juegoId) { this.juegoId = juegoId; }

    public boolean isRecomendado() { return recomendado; }
    public void setRecomendado(boolean recomendado) { this.recomendado = recomendado; }

    public String getTextoResena() { return textoResena; }
    public void setTextoResena(String textoResena) { this.textoResena = textoResena; }

    public double getHorasJugadas() { return horasJugadas; }
    public void setHorasJugadas(double horasJugadas) { this.horasJugadas = horasJugadas; }

    public LocalDateTime getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDateTime fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public LocalDateTime getFechaUltimaEdicion() { return fechaUltimaEdicion; }
    public void setFechaUltimaEdicion(LocalDateTime fechaUltimaEdicion) { this.fechaUltimaEdicion = fechaUltimaEdicion; }

    public EstadoResenaEnum.Estado getEstado() { return estado; }
    public void setEstado(EstadoResenaEnum.Estado estado) { this.estado = estado; }
}
