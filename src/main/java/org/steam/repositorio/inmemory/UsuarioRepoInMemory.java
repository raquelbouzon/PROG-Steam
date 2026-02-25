package org.steam.repositorio.inmemory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.steam.modelo.entity.UsuarioEntity;
import org.steam.modelo.enums.EstadoCuentaEnum;
import org.steam.modelo.form.UsuarioForm;
import org.steam.repositorio.interfaces.IUsuarioRepo;

public class UsuarioRepoInMemory implements IUsuarioRepo {

    private static final List<UsuarioEntity> usuarios = new ArrayList<>();
    private static Long idCounter = 1L;

    @Override
    public Optional<UsuarioEntity> crear(UsuarioForm form) {

        UsuarioEntity usuario = new UsuarioEntity( idCounter++, form.nombreReal(), form.nombreUsuario(), form.email(), form.contrasenha(), form.pais(), form.fechaNacimiento(), 0.0, EstadoCuentaEnum.Estado.ACTIVA, form.avatar(), LocalDateTime.now());
        usuarios.add(usuario);

        return Optional.of(usuario);
    }

    @Override
    public Optional<UsuarioEntity> obtenerPorId(Long id) {
        return usuarios.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst();
    }

    @Override
    public List<UsuarioEntity> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public Optional<UsuarioEntity> actualizar(Long id, UsuarioForm form) {

        Optional<UsuarioEntity> usuarioOpt = obtenerPorId(id);
        UsuarioEntity existente = usuarioOpt.get();
        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        UsuarioEntity usuarioActualizado = new UsuarioEntity(id, form.nombreReal(), form.nombreUsuario(), form.email(), form.contrasenha(), form.pais(), form.fechaNacimiento(), existente.getSaldoCartera(), existente.getEstado(), form.avatar(), existente.getFechaRegistro()
        );
        usuarios.removeIf(u -> id.equals(u.getId()));
        usuarios.add(usuarioActualizado);

        return Optional.of(usuarioActualizado);
    }

    @Override
    public boolean eliminar(Long id) {
        return usuarios.removeIf(u -> id.equals(u.getId()));
    }}
