package org.steam.modelo.form;

import org.steam.modelo.enums.EstadoResenaEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record ResenhaForm(
        Long usuarioId,
        Long juegoId,
        Boolean recomendado,
        String textoResena,
        Double horasJugadas,
        LocalDateTime fechaPublicacion,
        LocalDateTime fechaUltimaEdicion,
        EstadoResenaEnum.Estado estado
) {

    public List<ErrorDto> validar() {

        List<ErrorDto> errores = new ArrayList<>();

        if (usuarioId == null || usuarioId <= 0) {
            errores.add(new ErrorDto("usuarioId", ErrorType.REQUERIDO));
        }

        if (juegoId == null || juegoId <= 0) {
            errores.add(new ErrorDto("juegoId", ErrorType.REQUERIDO));
        }

        if (recomendado == null) {
            errores.add(new ErrorDto("recomendado", ErrorType.REQUERIDO));
        }

        if (textoResena == null || textoResena.isBlank()) {
            errores.add(new ErrorDto("textoResena", ErrorType.REQUERIDO));
        } else if (textoResena.length() > 5000) {
            errores.add(new ErrorDto("textoResena", ErrorType.LONGITUD_INVALIDA));
        }

        if (horasJugadas == null) {
            errores.add(new ErrorDto("horasJugadas", ErrorType.REQUERIDO));
        } else {
            if (horasJugadas < 0) {
                errores.add(new ErrorDto("horasJugadas", ErrorType.VALOR_DEMASIADO_BAJO));
            }
            if (horasJugadas > 100000) {
                errores.add(new ErrorDto("horasJugadas", ErrorType.VALOR_DEMASIADO_ALTO));
            }

            double redondeado = Math.round(horasJugadas * 10) / 10.0;
            if (Math.abs(horasJugadas - redondeado) > 1e-9) {
                errores.add(new ErrorDto("horasJugadas", ErrorType.FORMATO_INVALIDO));
            }
        }
        if (fechaUltimaEdicion != null && fechaPublicacion != null) {

            if (!fechaUltimaEdicion.isAfter(fechaPublicacion)) {
                errores.add(new ErrorDto(
                        "fechaUltimaEdicion",
                        ErrorType.VALOR_DEMASIADO_ALTO
                ));
            }
        }

        if (estado == null) {
            errores.add(new ErrorDto("estado", ErrorType.REQUERIDO));
        }

        return errores;
    }
}