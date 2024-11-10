package com.example.repositorio;

import com.example.entidades.ReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepositorio extends JpaRepository<ReservaEntidad, Long> {


}
