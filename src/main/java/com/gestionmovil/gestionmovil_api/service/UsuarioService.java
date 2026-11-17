package com.gestionmovil.gestionmovil_api.service;

import com.gestionmovil.gestionmovil_api.model.Usuario;
import com.gestionmovil.gestionmovil_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public Usuario updateUsuario(Usuario usuario, int id) {
        Optional<Usuario> existe = getUsuarioById(id);
        if (existe.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        } else {
            usuario.setId(id); // Aseguramos que se actualice el correcto
            return usuarioRepository.save(usuario);
        }
    }
}
