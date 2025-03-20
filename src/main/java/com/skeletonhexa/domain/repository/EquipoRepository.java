package com.skeletonhexa.domain.repository;

import java.util.List;

import com.skeletonhexa.domain.entities.Equipo;

public interface EquipoRepository {
    void guardar(Equipo equipo);
    Equipo buscarPorId(int id);
    List<Equipo> listarTodos();
    void actualizar(Equipo equipo);
    void eliminar(int id);
}
