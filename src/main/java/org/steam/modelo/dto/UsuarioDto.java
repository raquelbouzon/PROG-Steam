package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoCuentaEnum;

import java.time.LocalDate;

public record UsuarioDto(
        Long id,
        String nombreUsuario,
        String email,
        String nombreReal,
        String pais,
        LocalDate fechaNacimiento,
        LocalDate fechaRegistro,
        String avatar,
        Double saldo,
        EstadoCuentaEnum.Estado estado
) {
}