package org.steam.modelo.entity;

import org.steam.modelo.enums.ClasificacionEdadEnum;

import org.steam.modelo.enums.EstadoJuegoEnum;

import java.time.LocalDate;

public class JuegoEntity {

    private long id;
    private String titulo;
    private String descripcion;
    private String desarrollador;
    private LocalDate fechaLanzamiento;
    private Double precioBase;
    private Integer descuentoActual;
    private String categoria;
    private ClasificacionEdadEnum.ClasificacionEdad clasificacionEdad;
    private String[] idiomas;
    private EstadoJuegoEnum.Estado estado;

    public JuegoEntity(long id, String titulo, String descripcion, String desarrollador, LocalDate fechaLanzamiento, double precioBase, int descuentoActual, String categoria, ClasificacionEdadEnum.ClasificacionEdad clasificacionEdad, String[] idiomas, EstadoJuegoEnum.Estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.desarrollador = desarrollador;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precioBase = precioBase;
        this.categoria = categoria;
        this.clasificacionEdad = clasificacionEdad;
        this.idiomas = idiomas;
        this.estado = estado;

        this.descuentoActual = descuentoActual;
        if (this.descuentoActual == null) {
            this.descuentoActual = 0;
        }
        this.estado = estado;
        if (this.estado == null) {
            this.estado = EstadoJuegoEnum.Estado.DISPONIBLE;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getDescuentoActual() {
        return descuentoActual;
    }

    public void setDescuentoActual(int descuentoActual) {
        this.descuentoActual = descuentoActual;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ClasificacionEdadEnum.ClasificacionEdad getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(ClasificacionEdadEnum.ClasificacionEdad clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    public EstadoJuegoEnum.Estado getEstado() {
        return estado;
    }

    public void setEstado(EstadoJuegoEnum.Estado estado) {
        this.estado = estado;
    }
}
