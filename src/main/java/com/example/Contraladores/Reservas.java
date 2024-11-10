package com.example.Contraladores;

import com.example.entidades.ReservaEntidad;
//import com.example.model.Reserva;
import com.example.repositorio.ReservaRepositorio;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class Reservas {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    @GetMapping
    public List<ReservaEntidad> obtenerReservas() {
        return reservaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaEntidad> obtenerReservaPorId(@PathVariable Long id) {
        return reservaRepositorio.findById(id)
                .map(reserva -> ResponseEntity.ok().body(reserva))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ReservaEntidad> crearReserva(@RequestBody ReservaEntidad reservaEntidad) {
         ReservaEntidad reservaGuardada = reservaRepositorio.save(reservaEntidad);
        return ResponseEntity.ok(reservaGuardada);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ReservaEntidad> actualizarReserva(@PathVariable Long id, @RequestBody ReservaEntidad detallesReserva) {
        return reservaRepositorio.findById(id)
                .map(reserva -> {
                    reserva.setNombreCliente(detallesReserva.getNombreCliente());
                    reserva.setCedula(detallesReserva.getCedula());
                    reserva.setFechaReserva(detallesReserva.getFechaReserva());
                    reserva.setRuta(detallesReserva.getRuta());
                    reserva.setEstado(detallesReserva.getEstado());
                    ReservaEntidad reservaActualizada = reservaRepositorio.save(reserva);
                    return ResponseEntity.ok().body(reservaActualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        return reservaRepositorio.findById(id)
                .map(reserva -> {
                    reservaRepositorio.delete(reserva);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
