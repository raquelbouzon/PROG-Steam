package org.steam.repositorio.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.steam.modelo.entity.JuegoEntity;
import org.steam.modelo.enums.EstadoJuegoEnum;
import org.steam.modelo.form.JuegoForm;
import org.steam.repositorio.interfaces.IJuegoRepo;

public class JuegoRepoInMemory implements IJuegoRepo {

    private static final List<JuegoEntity> juegos = new ArrayList<>();
    private static Long idCounter = 1L;

    @Override
    public Optional<JuegoEntity> crear(JuegoForm form) {

        JuegoEntity juego = new JuegoEntity(
                idCounter++,
                form.titulo(),
                form.descripcion(),
                form.desarrollador(),
                form.fechaLanzamiento(),
                form.precioBase(),
                form.descuentoActual(),
                form.categoria(),
                form.clasificacionEdad(),
                form.idiomas(),
                form.estado()
        );

        juegos.add(juego);
        return Optional.of(juego);
    }

    @Override
    public Optional<JuegoEntity> obtenerPorId(Long id) {
        return juegos.stream()
                .filter(j -> id.equals(j.getId()))
                .findFirst();
    }

    @Override
    public List<JuegoEntity> obtenerTodos() {
        return new ArrayList<>(juegos);
    }

    @Override
    public Optional<JuegoEntity> actualizar(Long id, JuegoForm form) {

        Optional<JuegoEntity> juegoOpt = obtenerPorId(id);

        if (juegoOpt.isEmpty()) {
            throw new IllegalArgumentException("Juego no encontrado");
        }

        JuegoEntity existente = juegoOpt.get();


        Integer descuentoActual = form.descuentoActual();
        if (descuentoActual== null) {
            descuentoActual = existente.getDescuentoActual();
        }

        EstadoJuegoEnum.Estado estado = form.estado();
        if (estado == null) {
            estado = existente.getEstado();
        }

        JuegoEntity juegoActualizado = new JuegoEntity(id, form.titulo(), form.descripcion(), form.desarrollador(), form.fechaLanzamiento(), form.precioBase(),
                descuentoActual,
                form.categoria(),
                form.clasificacionEdad(),
                form.idiomas(),
                estado
        );

        juegos.removeIf(j -> id.equals(j.getId()));
        juegos.add(juegoActualizado);

        return Optional.of(juegoActualizado);
    }

    @Override
    public boolean eliminar(Long id) {
        return juegos.removeIf(j -> id.equals(j.getId()));
    }
}