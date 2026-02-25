package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoCompraEnum;
import org.steam.modelo.enums.MetodoPagoEnum;

import java.time.LocalDateTime;

public record CompraDto(
        Long id,
        Long usuarioId,
        Long juegoId,
        LocalDateTime fechaCompra,
        MetodoPagoEnum.Metodo metodoPago,
        Double precioSinDescuento,
        int descuentoAplicado,
        Double precioFinal,
        EstadoCompraEnum.Estado estado
) {
}
