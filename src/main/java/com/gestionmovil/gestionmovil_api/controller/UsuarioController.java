package com.gestionmovil.gestionmovil_api.controller;

import com.gestionmovil.gestionmovil_api.model.Usuario;
import com.gestionmovil.gestionmovil_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Usuario", description = "Operaciones relacionadas con los usuarios del sistema")
@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Operation(summary = "Obtiene todos los usuarios existentes")
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = service.getUsuarios();
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            return ResponseEntity.ok(usuarios); // 200
        }
    }

    @Operation(summary = "Obtiene todos los detalles de un usuario en específico")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable int id) {
        Usuario usr = service.getUsuarioById(id).orElseThrow();
        return ResponseEntity.ok(usr); // 200
    }

    @Operation(summary = "Crea un nuevo usuario")
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = service.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario); // 201
    }

    @Operation(summary = "Borra un usuario en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> borrar(@PathVariable int id) {
        try {
            service.deleteUsuario(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @Operation(summary = "Modifica el detalle de un usuario en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable int id, @RequestBody Usuario usuario) {
        Optional<Usuario> existe = service.getUsuarioById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        } else {
            usuario.setId(id);
            Usuario actualizado = service.saveUsuario(usuario);
            return ResponseEntity.ok(actualizado); // 200
        }
    }

}
