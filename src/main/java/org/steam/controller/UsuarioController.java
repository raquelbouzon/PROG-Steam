package org.steam.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.steam.excepciones.ValidationException;
import org.steam.modelo.entity.UsuarioEntity;
import org.steam.modelo.enums.EstadoCuentaEnum;
import org.steam.modelo.form.ErrorDto;
import org.steam.modelo.form.ErrorType;
import org.steam.modelo.form.UsuarioForm;
import org.steam.repositorio.interfaces.IUsuarioRepo;

public class UsuarioController {

    private final IUsuarioRepo usuarioRepo;

    public UsuarioController(IUsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }
//registrar nuevo usuario
    public UsuarioEntity registrarNuevoUsuario(UsuarioForm form) throws ValidationException {

        List<ErrorDto> errores = form.validar();


        boolean emailExiste = usuarioRepo.obtenerTodos().stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(form.email()));
        if (emailExiste) {
            errores.add(new ErrorDto("email", ErrorType.DUPLICADO));
        }


        boolean nombreUsuarioExiste = usuarioRepo.obtenerTodos().stream()
                .anyMatch(u -> u.getNombreUsuario().equalsIgnoreCase(form.nombreUsuario()));

        if (nombreUsuarioExiste) {
            errores.add(new ErrorDto("nombreUsuario", ErrorType.DUPLICADO));
        }
        if (!errores.isEmpty()) {
            throw new ValidationException(errores);
        }

        Optional<UsuarioEntity> nuevoUsuario = usuarioRepo.crear(form);
        return nuevoUsuario.orElseThrow(() -> new IllegalStateException("No se pudo crear el usuario"));

    }
    //anhadir saldo
    public double anadirSaldo(Long usuarioId, double cantidad) throws ValidationException {
        List<ErrorDto> errores = new ArrayList<>();

        UsuarioEntity usuario = usuarioRepo.obtenerPorId(usuarioId)
                .orElse(null);
        if (usuario == null) {
            errores.add(new ErrorDto("usuarioId", ErrorType.VALOR_INVALIDO));
        } else {
            if (usuario.getEstado() != EstadoCuentaEnum.Estado.ACTIVA) {
                errores.add(new ErrorDto("estado", ErrorType.VALOR_INVALIDO));
            }
        }

        if (cantidad <= 0) {
            errores.add(new ErrorDto("cantidad", ErrorType.VALOR_DEMASIADO_BAJO));
        }
        if (cantidad < 5.00 || cantidad > 500.00) {
            errores.add(new ErrorDto("cantidad", ErrorType.VALOR_INVALIDO));
        }

        if (!errores.isEmpty()) {
            throw new ValidationException(errores);
        }

        usuario.setSaldoCartera(usuario.getSaldoCartera() + cantidad);
        return usuario.getSaldoCartera();
    }
    //consultar saldo
    public double consultarSaldo(Long usuarioId) throws ValidationException {
        UsuarioEntity usuario = usuarioRepo.obtenerPorId(usuarioId).orElse(null);
        if (usuario == null) {
            throw new ValidationException(List.of(new ErrorDto("usuarioId", ErrorType.VALOR_INVALIDO)));
        }
        return usuario.getSaldoCartera();
    }


}