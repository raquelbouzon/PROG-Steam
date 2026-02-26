package org.steam.controller;

import java.util.List;
import java.util.Optional;

import org.steam.excepciones.ValidationException;
import org.steam.modelo.entity.UsuarioEntity;
import org.steam.modelo.form.ErrorDto;
import org.steam.modelo.form.ErrorType;
import org.steam.modelo.form.UsuarioForm;
import org.steam.repositorio.interfaces.IUsuarioRepo;

public class UsuarioController {

    private final IUsuarioRepo usuarioRepo;

    public UsuarioController(IUsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public UsuarioEntity registrarNuevoUsuario(UsuarioForm form) throws ValidationException {

        List<ErrorDto> errores = form.validar();

        // Validar si el email está duplicado
        boolean emailExiste = usuarioRepo.obtenerTodos().stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(form.email()));
        if (emailExiste) {
            errores.add(new ErrorDto("email", ErrorType.DUPLICADO));
        }

        //Validar su el nombreUsuario está dupplicado
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
}