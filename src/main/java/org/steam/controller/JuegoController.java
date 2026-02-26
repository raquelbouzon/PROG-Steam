package org.steam.controller;

import org.steam.excepciones.ValidationException;
import org.steam.modelo.entity.JuegoEntity;
import org.steam.modelo.form.ErrorDto;
import org.steam.modelo.form.ErrorType;
import org.steam.modelo.form.JuegoForm;
import org.steam.repositorio.interfaces.IJuegoRepo;

import java.util.List;

public class JuegoController {
    private final IJuegoRepo juegoRepo;

    public JuegoController(IJuegoRepo juegoRepo) {
        this.juegoRepo = juegoRepo;
    }

    public JuegoEntity registrarNuevoJuego(JuegoForm form) throws ValidationException {

        List<ErrorDto> errores = form.validar();

        boolean tituloExiste = juegoRepo.obtenerTodos().stream()
                .anyMatch(j -> j.getTitulo().equalsIgnoreCase(form.titulo()));

        if (tituloExiste) {
            errores.add(new ErrorDto("titulo", ErrorType.DUPLICADO));
        }

        if (!errores.isEmpty()) {
            throw new ValidationException(errores);
        }


    }
}


