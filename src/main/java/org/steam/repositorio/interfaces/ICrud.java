package org.steam.repositorio.interfaces;

import java.util.List;
import java.util.Optional;


//Definición de una interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
//E representa la entidad, F el DTO (Data Transfer Object) y ID el tipo del identificador de la entidad.

//Usar esta interfaz para definir contratos claros para los repositorios que manejarán diferentes tipos de entidades y sus correspondientes DTOs.

public interface ICrud<E, F, ID> {
    /**
     * Crea una nueva entidad a partir de un Formulario.
     * @param form Objeto de transferencia de datos con la información a persistir.
     * @return La entidad creada.
     */
    Optional<E> crear(F form);

    /**
     * Obtiene una entidad por su identificador único.
     * @param id Identificador de la entidad.
     * @return Un Optional con la entidad encontrada, o vacío si no existe.
     */
    Optional<E> obtenerPorId(ID id);

    /**
     * Obtiene todas las entidades existentes.
     * @return Lista de todas las entidades.
     */
    List<E> obtenerTodos();

    /**
     * Actualiza una entidad existente a partir de su identificador y un DTO.
     * @param id Identificador de la entidad a actualizar.
     * @param form Objeto de transferencia de datos con la información actualizada.
     * @return La entidad actualizada.
     */
    Optional<E> actualizar(ID id, F form);

    /**
     * Elimina una entidad por su identificador único.
     * @param id Identificador de la entidad a eliminar.
     * @return true si la entidad fue eliminada, false en caso contrario.
     */
    boolean eliminar(ID id);
}
