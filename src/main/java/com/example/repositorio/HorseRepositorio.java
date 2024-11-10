package com.example.repositorio;


import com.example.entidades.HorseEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseRepositorio extends JpaRepository<HorseEntidad, Long> {
}
