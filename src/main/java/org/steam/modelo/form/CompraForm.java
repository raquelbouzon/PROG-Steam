package org.steam.modelo.form;

import org.steam.modelo.enums.EstadoCompraEnum;
import org.steam.modelo.enums.MetodoPagoEnum;

import java.util.ArrayList;
import java.util.List;

public record CompraForm(
        Long usuarioId,
        Long juegoId,
        MetodoPagoEnum.Metodo metodoPago,
        Double precioSinDescuento,
        Integer descuentoAplicado,
        EstadoCompraEnum.Estado estado
) {

    public List<ErrorDto> validar() {

        List<ErrorDto> errores = new ArrayList<>();

        if (usuarioId == null || usuarioId <= 0) {
            errores.add(new ErrorDto("usuarioId", ErrorType.REQUERIDO));
        }

        if (juegoId == null || juegoId <= 0) {
            errores.add(new ErrorDto("juegoId", ErrorType.REQUERIDO));
        }

        if (metodoPago == null) {
            errores.add(new ErrorDto("metodoPago", ErrorType.REQUERIDO));
        }

        if (precioSinDescuento == null) {
            errores.add(new ErrorDto("precioSinDescuento", ErrorType.REQUERIDO));
        } else {
            if (precioSinDescuento < 0.00) {
                errores.add(new ErrorDto("precioSinDescuento", ErrorType.VALOR_DEMASIADO_BAJO));
            }
            if (precioSinDescuento > 9999.99) {
                errores.add(new ErrorDto("precioSinDescuento", ErrorType.VALOR_DEMASIADO_ALTO));
            }

            double redondeado = Math.round(precioSinDescuento * 100) / 100.0;
            if (Math.abs(precioSinDescuento - redondeado) > 1e-9) {
                errores.add(new ErrorDto("precioSinDescuento", ErrorType.FORMATO_INVALIDO));
            }
        }

        if (descuentoAplicado != null) {
            if (descuentoAplicado < 0) {
                errores.add(new ErrorDto("descuentoAplicado", ErrorType.VALOR_DEMASIADO_BAJO));
            }
            if (descuentoAplicado > 100) {
                errores.add(new ErrorDto("descuentoAplicado", ErrorType.VALOR_DEMASIADO_ALTO));
            }
        }

        if (estado == null) {
            errores.add(new ErrorDto("estado", ErrorType.REQUERIDO));
        }

        return errores;
    }
}