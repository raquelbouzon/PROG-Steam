package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoCuentaEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UsuarioDto(
        Long id,
        String nombreUsuario,
        String email,
        String nombreReal,
        String pais,
        LocalDate fechaNacimiento,
        LocalDateTime fechaRegistro,
        String avatar,
        Double saldo,
        EstadoCuentaEnum.Estado estado
) {
}