package com.gestionmovil.gestionmovil_api.controller;

import com.gestionmovil.gestionmovil_api.model.Organizacion;
import com.gestionmovil.gestionmovil_api.service.OrganizacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Organizacion", description = "Operaciones relacionadas con las organizaciones o empresas")
@RestController
@RequestMapping("api/v1/organizacion")
public class OrganizacionController {

    @Autowired
    private OrganizacionService service;

    @Operation(summary = "Obtiene todas las organizaciones existentes")
    @GetMapping
    public ResponseEntity<List<Organizacion>> listar() {
        List<Organizacion> organizaciones = service.getOrganizaciones();
        if (organizaciones.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            return ResponseEntity.ok(organizaciones); // 200
        }
    }

    @Operation(summary = "Obtiene todos los detalles de una organizacion en específico")
    @GetMapping("/{id}")
    public ResponseEntity<Organizacion> buscar(@PathVariable int id) {
        Organizacion org = service.getOrganizacionById(id).orElseThrow();
        return ResponseEntity.ok(org); // 200
    }

    @Operation(summary = "Crea una nueva organizacion")
    @PostMapping
    public ResponseEntity<Organizacion> crear(@RequestBody Organizacion organizacion) {
        Organizacion nuevaOrganizacion = service.saveOrganizacion(organizacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOrganizacion); // 201
    }

    @Operation(summary = "Borra una organizacion en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Organizacion> borrar(@PathVariable int id) {
        try {
            service.deleteOrganizacion(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @Operation(summary = "Modifica el detalle de una organizacion en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Organizacion> modificar(@PathVariable int id, @RequestBody Organizacion organizacion) {
        Optional<Organizacion> existe = service.getOrganizacionById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            organizacion.setId(id);
            Organizacion actualizada = service.saveOrganizacion(organizacion);
            return ResponseEntity.ok(actualizada); // 200
        }
    }

}
