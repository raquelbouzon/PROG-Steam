package org.steam.modelo.form;

public enum ErrorType{

    REQUERIDO("El campo es obligatorio"),
    FORMATO_INVALIDO("El formato es inválido"),
    LONGITUD_INVALIDA("La longitud del campo es inválida"),
    VALOR_DEMASIADO_ALTO("El valor es demasiado alto"),
    VALOR_DEMASIADO_BAJO("El valor es demasiado bajo");

    private final String mensaje;
    private ErrorType(String mensaje){
        this.mensaje = mensaje;
    }
}
