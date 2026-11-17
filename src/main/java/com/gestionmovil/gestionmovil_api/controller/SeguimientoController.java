package com.gestionmovil.gestionmovil_api.controller;

import com.gestionmovil.gestionmovil_api.model.Seguimiento;
import com.gestionmovil.gestionmovil_api.service.SeguimientoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Seguimiento", description = "Operaciones relacionadas con los seguimientos de las oportunidades")
@RestController
@RequestMapping("api/v1/seguimiento")
public class SeguimientoController {

    @Autowired
    private SeguimientoService service;

    @Operation(summary = "Obtiene todos los seguimientos existentes")
    @GetMapping
    public ResponseEntity<List<Seguimiento>> listar() {
        List<Seguimiento> seguimientos = service.getSeguimientos();
        if (seguimientos.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            return ResponseEntity.ok(seguimientos); // 200
        }
    }

    @Operation(summary = "Obtiene todos los detalles de un seguimiento en específico")
    @GetMapping("/{id}")
    public ResponseEntity<Seguimiento> buscar(@PathVariable int id) {
        Seguimiento seg = service.getSeguimientoById(id).orElseThrow();
        return ResponseEntity.ok(seg); // 200
    }

    @Operation(summary = "Crea un nuevo seguimiento")
    @PostMapping
    public ResponseEntity<Seguimiento> crear(@RequestBody Seguimiento seguimiento) {
        Seguimiento nuevoSeguimiento = service.saveSeguimiento(seguimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoSeguimiento); // 201
    }

    @Operation(summary = "Borra un seguimiento en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Seguimiento> borrar(@PathVariable int id) {
        try {
            service.deleteSeguimiento(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @Operation(summary = "Modifica el detalle de un seguimiento en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Seguimiento> modificar(@PathVariable int id, @RequestBody Seguimiento seguimiento) {
        Optional<Seguimiento> existe = service.getSeguimientoById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            seguimiento.setId(id);
            Seguimiento actualizado = service.saveSeguimiento(seguimiento);
            return ResponseEntity.ok(actualizado); // 200
        }
    }

}
