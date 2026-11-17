package com.gestionmovil.gestionmovil_api.service;

import com.gestionmovil.gestionmovil_api.model.Seguimiento;
import com.gestionmovil.gestionmovil_api.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguimientoService {
    @Autowired
    private SeguimientoRepository seguimientoRepository;

    public List<Seguimiento> getSeguimientos() {
        return seguimientoRepository.findAll();
    }

    public Optional<Seguimiento> getSeguimientoById(int id) {
        return seguimientoRepository.findById(id);
    }

    public Seguimiento saveSeguimiento(Seguimiento seguimiento) {
        return seguimientoRepository.save(seguimiento);
    }

    public void deleteSeguimiento(int id) {
        if (seguimientoRepository.existsById(id)) {
            seguimientoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Seguimiento no encontrado");
        }
    }

    public Seguimiento updateSeguimiento(Seguimiento seguimiento, int id) {
        Optional<Seguimiento> existe = getSeguimientoById(id);
        if (existe.isEmpty()) {
            throw new RuntimeException("Seguimiento no encontrado");
        } else {
            seguimiento.setId(id); // Aseguramos que se actualice el correcto
            return seguimientoRepository.save(seguimiento);
        }
    }
}
