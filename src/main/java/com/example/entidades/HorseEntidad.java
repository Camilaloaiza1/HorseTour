package com.example.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Horse")
public class HorseEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el ID automáticamente
    private Long id;

    @Column(name = "nombre", nullable = false) // Nombre del caballo
    private String name;

    @Column(name = "raza") // Raza del caballo
    private String breed;

    @Column(name = "edad") // Edad del caballo (opcional)
    private Integer age;

    @Column(name = "descripcion") // Descripción adicional del caballo (opcional)
    private String description;

    // Constructor por defecto
    public HorseEntidad() {
    }

    // Constructor con parámetros
    public HorseEntidad(String name, String breed, Integer age, String description) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.description = description;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
