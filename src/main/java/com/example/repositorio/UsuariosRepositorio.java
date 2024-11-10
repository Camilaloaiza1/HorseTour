package com.example.repositorio;

import com.example.entidades.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepositorio extends JpaRepository<UsuarioEntidad, Long> {
    // Método para encontrar un usuario por su nombre de usuario
    Optional<UsuarioEntidad> findByUsername(String username);
}
