package com.example.Contraladores;

import com.example.entidades.HorseEntidad;
import com.example.repositorio.HorseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horse")
public class Caballos {

    @Autowired
    private HorseRepositorio horserepositorio;

    // Obtener todos los caballos
    @GetMapping
    public List<HorseEntidad> getAllHorses() {
        return horserepositorio.findAll();
    }

    // Obtener un caballo por ID
    @GetMapping("/{id}")
    public ResponseEntity<HorseEntidad> getHorseById(@PathVariable Long id) {
        Optional<HorseEntidad> horse = horserepositorio.findById(id);
        if (horse.isPresent()) {
            return ResponseEntity.ok(horse.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo caballo
    @PostMapping
    public HorseEntidad createHorse(@RequestBody HorseEntidad newHorse) {
        return horserepositorio.save(newHorse);
    }

    // Actualizar un caballo existente
    @PutMapping("/{id}")
    public ResponseEntity<HorseEntidad> updateHorse(@PathVariable Long id, @RequestBody HorseEntidad horseDetails) {
        Optional<HorseEntidad> optionalHorse = horserepositorio.findById(id);
        if (optionalHorse.isPresent()) {
            HorseEntidad existingHorse = optionalHorse.get();
            existingHorse.setName(horseDetails.getName());
            existingHorse.setBreed(horseDetails.getBreed());
            HorseEntidad updatedHorse = horserepositorio.save(existingHorse);
            return ResponseEntity.ok(updatedHorse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un caballo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorse(@PathVariable Long id) {
        if (horserepositorio.existsById(id)) {
            horserepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
