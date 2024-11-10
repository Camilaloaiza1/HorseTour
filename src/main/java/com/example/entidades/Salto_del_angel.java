package com.example.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rutas")
public class Salto_del_angel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String duracion;
    private String dificultad;
    private String descripcion;
    private String horarios;
    private Integer precio;

    @ElementCollection
    private List<String> incluye;

    // Constructor vacío para JPA
    public Salto_del_angel() {
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public List<String> getIncluye() {
        return incluye;
    }

    public void setIncluye(List<String> incluye) {
        this.incluye = incluye;
    }
}
