package com.skeletonhexa.application.usecase.Equipo;

import java.util.List;

import com.skeletonhexa.domain.entities.Equipo;
import com.skeletonhexa.domain.repository.EquipoRepository;

public class EquipoUseCase {
    
        private final EquipoRepository repository;
    
        public EquipoUseCase(EquipoRepository repository) {
            this.repository = repository;
        }
    
        public void registrarEquipo(int id, String name, String yearfoundation, String coach) {
            Equipo equipo = new Equipo(id, name, yearfoundation, coach);
            repository.guardar(equipo);
        }
    
        public Equipo obtenerEquipo(int id) {
            return repository.buscarPorId(id);
        }
    
        public List<Equipo> listarEquipos() {
            return repository.listarTodos();
        }
    
        public void actualizarEquipo(int id, String name, String yearfoundation, String coach) {
            Equipo equipo = new Equipo(id, name, yearfoundation, coach);
            repository.actualizar(equipo);
        }
    
        public void eliminarEquipo(int id) {
            repository.eliminar(id);
        }
    
}
