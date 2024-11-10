package com.example.Contraladores;

import org.springframework.ui.Model;
import com.example.entidades.Salto_del_angel;
import com.example.repositorio.RutaRepositorio; // Asegúrate de tener este repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rutas")
public class ControladorRutas {
    @Autowired
    private RutaRepositorio rutaRepositorio;

    // Método para obtener ruta por ID y devolver la vista con Thymeleaf
    @GetMapping("/ruta/{id}")
    public String obtenerRutaPorId(@PathVariable Long id, Model model) {
        Salto_del_angel ruta = rutaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));
        model.addAttribute("ruta", ruta);
        return "vistaUsuarioRuta";  // Vista donde el usuario verá los detalles de la ruta
    }

    // Método para obtener todas las rutas (para la API REST)
    @GetMapping
    public ResponseEntity<List<Salto_del_angel>> getAllRutas() {
        List<Salto_del_angel> rutas = rutaRepositorio.findAll();
        return new ResponseEntity<>(rutas, HttpStatus.OK);
    }

    // Método para crear una nueva ruta (API REST)
    @PostMapping
    public ResponseEntity<Salto_del_angel> crearRuta(@RequestBody Salto_del_angel ruta) {
        Salto_del_angel nuevaRuta = rutaRepositorio.save(ruta);
        return new ResponseEntity<>(nuevaRuta, HttpStatus.CREATED);
    }

    // Método para obtener ruta por ID (API REST)
    @GetMapping("/{id}")
    public ResponseEntity<Salto_del_angel> obtenerRutaPorIdJSON(@PathVariable Long id) {
        return rutaRepositorio.findById(id)
                .map(ruta -> new ResponseEntity<>(ruta, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Método para actualizar ruta por ID (API REST)
    @PutMapping("/{id}")
    public ResponseEntity<Salto_del_angel> actualizarRuta(@PathVariable Long id, @RequestBody Salto_del_angel rutaActualizada) {
        return rutaRepositorio.findById(id)
                .map(ruta -> {
                    ruta.setNombre(rutaActualizada.getNombre());
                    ruta.setDuracion(rutaActualizada.getDuracion());
                    ruta.setDificultad(rutaActualizada.getDificultad());
                    ruta.setDescripcion(rutaActualizada.getDescripcion());
                    ruta.setHorarios(rutaActualizada.getHorarios());
                    ruta.setPrecio(rutaActualizada.getPrecio());
                    ruta.setIncluye(rutaActualizada.getIncluye());
                    Salto_del_angel rutaGuardada = rutaRepositorio.save(ruta);
                    return new ResponseEntity<>(rutaGuardada, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Método para eliminar ruta por ID (API REST)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRuta(@PathVariable Long id) {
        if (rutaRepositorio.existsById(id)) {
            rutaRepositorio.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}