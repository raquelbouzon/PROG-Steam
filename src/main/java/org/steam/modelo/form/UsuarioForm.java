package org.steam.modelo.form;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public record UsuarioForm(
        String nombreUsuario,
        String email,
        String contrasenha,
        String nombreReal,
        String pais,
        LocalDate fechaNacimiento,
        String avatar)
{

    public List<ErrorDto> validar() {
        List<ErrorDto> errores = new ArrayList<>();

        if (nombreUsuario == null || nombreUsuario.isBlank()) {
            errores.add(new ErrorDto("nombreUsuario", ErrorType.REQUERIDO));
        }

        if (nombreUsuario != null && (nombreUsuario.length() < 3 || nombreUsuario.length() > 20)) {
            errores.add(new ErrorDto("nombreUsuario", ErrorType.LONGITUD_INVALIDA));
        }else if (nombreUsuario != null && !nombreUsuario.matches("^[A-Za-z][A-Za-z0-9_-]*$")) {
            errores.add(new ErrorDto("nombreUsuario", ErrorType.FORMATO_INVALIDO));
        }


        if (email == null || email.isBlank()) {
            errores.add(new ErrorDto("email", ErrorType.REQUERIDO));
        }

        if (email != null && !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            errores.add(new ErrorDto("email", ErrorType.FORMATO_INVALIDO));
        }

        if (contrasenha == null || contrasenha.isBlank()) {
            errores.add(new ErrorDto("contrasenha", ErrorType.REQUERIDO));
        }

        if (contrasenha != null && contrasenha.length() < 8) {
            errores.add(new ErrorDto("contrasenha", ErrorType.LONGITUD_INVALIDA));
        }else if(contrasenha != null && !contrasenha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
            errores.add(new ErrorDto("contrasenha", ErrorType.FORMATO_INVALIDO));
        }

        if (nombreReal == null || nombreReal.isBlank()) {
            errores.add(new ErrorDto("nombreReal", ErrorType.REQUERIDO));
        }

        if (nombreReal != null && (nombreReal.length() < 2 || nombreReal.length() > 50)) {
            errores.add(new ErrorDto("nombreReal", ErrorType.LONGITUD_INVALIDA));
        }

        if (pais == null || pais.isBlank()) {
            errores.add(new ErrorDto("pais", ErrorType.REQUERIDO));
        }
        //falta paises válidos, ns como hacerlo


        if (fechaNacimiento == null) {
            errores.add(new ErrorDto("fechaNacimiento", ErrorType.REQUERIDO));
        }

        if (fechaNacimiento != null && Period.between(fechaNacimiento, LocalDate.now()).getYears() < 13) {
            errores.add(new ErrorDto("fechaNacimiento", ErrorType.VALOR_DEMASIADO_BAJO));
        }

        if (fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
            errores.add(new ErrorDto("fechaNacimiento", ErrorType.VALOR_DEMASIADO_ALTO));
        }

        if (avatar != null && avatar.length() > 100) {
            errores.add(new ErrorDto("avatar", ErrorType.LONGITUD_INVALIDA));
        }


        return errores;
    }
}