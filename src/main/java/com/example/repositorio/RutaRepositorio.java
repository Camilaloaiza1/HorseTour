package com.example.repositorio;

import com.example.entidades.Salto_del_angel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepositorio extends JpaRepository<Salto_del_angel, Long> {
}

