package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoCompraEnum;
import org.steam.modelo.enums.MetodoPagoEnum;

import java.time.LocalDateTime;

public class CompraDto {
    private long id;
    private long usuarioId;
    private long juegoId;
    private LocalDateTime fechaCompra;
    private MetodoPagoEnum.Metodo metodoPago;
    private double precioSinDescuento;
    private int descuentoAplicado;
    private EstadoCompraEnum.Estado estado;
}
