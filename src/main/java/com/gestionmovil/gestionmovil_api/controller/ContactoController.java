package com.gestionmovil.gestionmovil_api.controller;

import com.gestionmovil.gestionmovil_api.model.Contacto;
import com.gestionmovil.gestionmovil_api.service.ContactoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Contacto", description = "Operaciones relacionadas con los contactos de las distintas empresas")
@RestController
@RequestMapping("api/v1/contacto")
public class ContactoController {

    @Autowired
    private ContactoService service;

    @Operation(summary = "Obtiene todos los contactos existentes")
    @GetMapping
    public ResponseEntity<List<Contacto>> listar() {
        List<Contacto> contactos = service.getContactos();
        if (contactos.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            return ResponseEntity.ok(contactos); // 200
        }
    }

    @Operation(summary = "Obtiene todos los detalles de un contacto en específico")
    @GetMapping("/{id}")
    public ResponseEntity<Contacto> buscar(@PathVariable int id) {
        Contacto cont = service.getContactoById(id).orElseThrow();
        return ResponseEntity.ok(cont); // 200
    }

    @Operation(summary = "Crea un nuevo contacto")
    @PostMapping
    public ResponseEntity<Contacto> crear(@RequestBody Contacto contacto) {
        Contacto nuevoContacto = service.saveContacto(contacto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoContacto); // 201
    }

    @Operation(summary = "Borra un contacto en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Contacto> borrar(@PathVariable int id) {
        try {
            service.deleteContacto(id);
            return ResponseEntity.noContent().build(); // 404
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @Operation(summary = "Modifica el detalle de un contacto en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Contacto> modificar(@PathVariable int id, @RequestBody Contacto contacto) {
        Optional<Contacto> existe = service.getContactoById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            contacto.setId(id);
            Contacto actualizado = service.saveContacto(contacto);
            return ResponseEntity.ok(actualizado); // 200
        }
    }

}
