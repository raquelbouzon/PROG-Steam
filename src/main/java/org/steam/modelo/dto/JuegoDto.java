package org.steam.modelo.dto;

import org.steam.modelo.enums.ClasificacionEdadEnum;
import org.steam.modelo.enums.EstadoJuegoEnum;

import java.time.LocalDate;

public class JuegoDto {

    private long id;
    private String titulo;
    private String descripcion;
    private String desarrollador;
    private LocalDate fechaLanzamiento;
    private double precioBase;
    private int descuentoActual;
    private String categoria;
    private ClasificacionEdadEnum.ClasificacionEdad clasificacionEdad;
    private String[] idiomas;
    private EstadoJuegoEnum.Estado estado;
}
