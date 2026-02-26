package org.steam.controller;

import org.steam.excepciones.ValidationException;
import org.steam.modelo.entity.JuegoEntity;
import org.steam.modelo.enums.EstadoJuegoEnum;
import org.steam.modelo.form.ErrorDto;
import org.steam.modelo.form.ErrorType;
import org.steam.modelo.form.JuegoForm;
import org.steam.repositorio.interfaces.IJuegoRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JuegoController {
    private final IJuegoRepo juegoRepo;

    public JuegoController(IJuegoRepo juegoRepo) {
        this.juegoRepo = juegoRepo;
    }
//anhadir juego
    public JuegoEntity anhadirJuegoCatalogo(JuegoForm form) throws ValidationException {

        List<ErrorDto> errores = form.validar();

        boolean tituloExiste = juegoRepo.obtenerTodos().stream()
                .anyMatch(j -> j.getTitulo().equalsIgnoreCase(form.titulo()));

        if (tituloExiste) {
            errores.add(new ErrorDto("titulo", ErrorType.DUPLICADO));
        }

        if (!errores.isEmpty()) {
            throw new ValidationException(errores);
        }
        Optional<JuegoEntity> nuevoJuego = juegoRepo.crear(form);
        return nuevoJuego.orElseThrow(() -> new IllegalStateException("No se pudo crear el juego"));

    }

    //aplicar descuento

    public double aplicarDescuento(Long juegoId, int porcentaje) throws ValidationException {
        List<ErrorDto> errores = new ArrayList<>();

        JuegoEntity juego = juegoRepo.obtenerPorId(juegoId).orElse(null);
        if (juego == null) {
            errores.add(new ErrorDto("juegoId", ErrorType.VALOR_INVALIDO));
        }

        if (porcentaje < 0 || porcentaje > 100) {
            errores.add(new ErrorDto("descuento", ErrorType.VALOR_INVALIDO));
        }

        if (!errores.isEmpty()) throw new ValidationException(errores);

        juego.setDescuentoActual(porcentaje);

        double precioFinal = juego.getPrecioBase() * (1.0 - (porcentaje / 100.0));
        return precioFinal;
    }

    //cambiar estado del juego
    public void cambiarEstado(Long juegoId, EstadoJuegoEnum nuevoEstado) throws ValidationException {
        List<ErrorDto> errores = new ArrayList<>();

        JuegoEntity juego = juegoRepo.obtenerPorId(juegoId).orElse(null);
        if (juego == null) {
            errores.add(new ErrorDto("juegoId", ErrorType.VALOR_INVALIDO));
        }

        if (nuevoEstado == null) {
            errores.add(new ErrorDto("estado", ErrorType.VALOR_INVALIDO));
        }

        if (!errores.isEmpty()) throw new ValidationException(errores);

        juego.setEstado(nuevoEstado);
    }
}


