package org.steam.modelo.form;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.steam.modelo.enums.ClasificacionEdadEnum;
import org.steam.modelo.enums.EstadoJuegoEnum;

public record  JuegoForm(
        String titulo,
        String descripcion,
        String desarrollador,
        LocalDate fechaLanzamiento,
        Double precioBase,
        Integer descuentoActual,
        ClasificacionEdadEnum.ClasificacionEdad clasificacionEdad,
        String idiomas,
        EstadoJuegoEnum.Estado estado
) {

    public List<ErrorDto> validar() {

        List<ErrorDto> errores = new ArrayList<>();


        if (titulo == null || titulo.isBlank()) {
            errores.add(new ErrorDto("titulo", ErrorType.REQUERIDO));
        }
        if (titulo != null && (titulo.length() < 1 || titulo.length() > 100)) {
            errores.add(new ErrorDto("titulo", ErrorType.LONGITUD_INVALIDA));
        }

        if (descripcion != null && descripcion.length() > 2000) {
            errores.add(new ErrorDto("descripcion", ErrorType.LONGITUD_INVALIDA));
        }


        if (desarrollador == null || desarrollador.isBlank()) {
            errores.add(new ErrorDto("desarrollador", ErrorType.REQUERIDO));
        }

        if (desarrollador != null &&
                (desarrollador.length() < 2 || desarrollador.length() > 100)) {
            errores.add(new ErrorDto("desarrollador", ErrorType.LONGITUD_INVALIDA));
        }


        if (fechaLanzamiento == null) {
            errores.add(new ErrorDto("fechaLanzamiento", ErrorType.REQUERIDO));
        }


        if (precioBase == null) {
            errores.add(new ErrorDto("precioBase", ErrorType.REQUERIDO));
        }

        if (precioBase != null && precioBase < 0.00) {
            errores.add(new ErrorDto("precioBase", ErrorType.VALOR_DEMASIADO_BAJO));
        }

        if (precioBase != null && precioBase > 999.99) {
            errores.add(new ErrorDto("precioBase", ErrorType.VALOR_DEMASIADO_ALTO));
        }

        if (precioBase != null) {
            double redondeado = Math.round(precioBase * 100) / 100.0;
            if (Math.abs(precioBase - redondeado) > 1e-9) {
                errores.add(new ErrorDto("precioBase", ErrorType.FORMATO_INVALIDO));
            }
        }

        if (descuentoActual != null && descuentoActual < 0) {
            errores.add(new ErrorDto("descuentoActual", ErrorType.VALOR_DEMASIADO_BAJO));
        }
        if (descuentoActual != null && descuentoActual > 100) {
            errores.add(new ErrorDto("descuentoActual", ErrorType.VALOR_DEMASIADO_ALTO));
        }

        if (clasificacionEdad == null) {
            errores.add(new ErrorDto("clasificacionEdad", ErrorType.REQUERIDO));
        }


        if (idiomas != null && idiomas.isBlank()) {
            errores.add(new ErrorDto("idiomas", ErrorType.REQUERIDO));
        }

        if (idiomas != null && idiomas.length() > 200) {
            errores.add(new ErrorDto("idiomas", ErrorType.LONGITUD_INVALIDA));
        }

        if (estado == null) {
            errores.add(new ErrorDto("estado", ErrorType.REQUERIDO));
        }


        return errores;
    }
}
