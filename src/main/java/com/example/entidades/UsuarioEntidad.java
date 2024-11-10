package com.example.entidades;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USUARIOS")
public class UsuarioEntidad {
    public enum Rol {
        ADMINISTRADOR,
        AUXILIAR,
        USUARIO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    // Relación uno a muchos con ReservaEntidad
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservaEntidad> reservas;

    // Constructor vacío
    public UsuarioEntidad() {}

    // Constructor con parámetros
    public UsuarioEntidad(String username, String password, Rol rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<ReservaEntidad> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaEntidad> reservas) {
        this.reservas = reservas;
    }
}
