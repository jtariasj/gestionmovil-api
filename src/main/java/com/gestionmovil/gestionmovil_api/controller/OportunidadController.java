package com.gestionmovil.gestionmovil_api.controller;

import com.gestionmovil.gestionmovil_api.model.Oportunidad;
import com.gestionmovil.gestionmovil_api.service.OportunidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Oportunidad", description = "Operaciones relacionadas con las oportunidades comerciales")
@RestController
@RequestMapping("api/v1/oportunidad")
public class OportunidadController {

    @Autowired
    private OportunidadService service;

    @Operation(summary = "Obtiene todas las oportunidades existentes")
    @GetMapping
    public ResponseEntity<List<Oportunidad>> listar() {
        List<Oportunidad> oportunidades = service.getOportunidades();
        if (oportunidades.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            return ResponseEntity.ok(oportunidades); // 200
        }
    }

    @Operation(summary = "Obtiene todos los detalles de una oportunidad en específico")
    @GetMapping("/{id}")
    public ResponseEntity<Oportunidad> buscar(@PathVariable int id) {
        Oportunidad opp = service.getOportunidadById(id).orElseThrow();
        return ResponseEntity.ok(opp); // 200
    }

    @Operation(summary = "Crea una nueva oportunidad")
    @PostMapping
    public ResponseEntity<Oportunidad> crear(@RequestBody Oportunidad oportunidad) {
        Oportunidad nuevaOportunidad = service.saveOportunidad(oportunidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOportunidad); // 201
    }

    @Operation(summary = "Borra una oportunidad en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Oportunidad> borrar(@PathVariable int id) {
        try {
            service.deleteOportunidad(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @Operation(summary = "Modifica el detalle de una oportunidad en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Oportunidad> modificar(@PathVariable int id, @RequestBody Oportunidad oportunidad) {
        Optional<Oportunidad> existe = service.getOportunidadById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            oportunidad.setId(id);
            Oportunidad actualizada = service.saveOportunidad(oportunidad);
            return ResponseEntity.ok(actualizada); // 200
        }
    }

}
