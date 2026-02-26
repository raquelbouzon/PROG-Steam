package org.steam.modelo.form;

import org.steam.modelo.enums.EstadoInstalacionEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record BibliotecaForm(
        Long usuarioId,
        Long juegoId,
        LocalDate fechaAdquisicion,
        Double tiempoJuegoTotal,
        LocalDate ultimaFechaJuego,
        EstadoInstalacionEnum.Estado estadoInstalacion
) {

    public List<ErrorDto> validar() {

        List<ErrorDto> errores = new ArrayList<>();

        if (usuarioId == null || usuarioId <= 0) {
            errores.add(new ErrorDto("usuarioId", ErrorType.REQUERIDO));
        }

        if (juegoId == null || juegoId <= 0) {
            errores.add(new ErrorDto("juegoId", ErrorType.REQUERIDO));
        }

        if (fechaAdquisicion == null) {
            errores.add(new ErrorDto("fechaAdquisicion", ErrorType.REQUERIDO));
        } else if (fechaAdquisicion.isAfter(LocalDate.now())) {
            errores.add(new ErrorDto("fechaAdquisicion", ErrorType.VALOR_DEMASIADO_ALTO));
        }

        if (tiempoJuegoTotal == null) {
            errores.add(new ErrorDto("tiempoJuegoTotal", ErrorType.REQUERIDO));
        } else {
            if (tiempoJuegoTotal < 0) {
                errores.add(new ErrorDto("tiempoJuegoTotal", ErrorType.VALOR_DEMASIADO_BAJO));
            }
            if (tiempoJuegoTotal > 100000) {
                errores.add(new ErrorDto("tiempoJuegoTotal", ErrorType.VALOR_DEMASIADO_ALTO));
            }
        }

        if (ultimaFechaJuego != null) {

            if (ultimaFechaJuego.isAfter(LocalDate.now())) {
                errores.add(new ErrorDto("ultimaFechaJuego", ErrorType.VALOR_DEMASIADO_ALTO));
            }

            if (fechaAdquisicion != null && ultimaFechaJuego.isBefore(fechaAdquisicion)) {
                errores.add(new ErrorDto("ultimaFechaJuego", ErrorType.VALOR_DEMASIADO_BAJO));
            }
        }

        if (estadoInstalacion == null) {
            errores.add(new ErrorDto("estadoInstalacion", ErrorType.REQUERIDO));
        }

        return errores;
    }
}
