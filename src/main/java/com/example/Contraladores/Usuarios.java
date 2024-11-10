package com.example.Contraladores;

import com.example.entidades.UsuarioEntidad;
import com.example.repositorio.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Usuarios")
public class Usuarios {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    // Método para iniciar sesión
    @PostMapping("/Inicio_sesion")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Optional<UsuarioEntidad> usuarioOpt = usuariosRepositorio.findByUsername(username);

        if (usuarioOpt.isPresent()) {
            UsuarioEntidad usuario = usuarioOpt.get();
            if (usuario.getPassword().equals(password)) {
                return ResponseEntity.ok("Inicio de sesión exitoso");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    // Método para registrar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam UsuarioEntidad.Rol rol) {

        if (usuariosRepositorio.findByUsername(username).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario ya existe");
        }

        UsuarioEntidad newUser = new UsuarioEntidad(username, password, rol);
        usuariosRepositorio.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
    }
}


