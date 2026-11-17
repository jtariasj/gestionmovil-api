package com.gestionmovil.gestionmovil_api.service;

import com.gestionmovil.gestionmovil_api.model.Oportunidad;
import com.gestionmovil.gestionmovil_api.repository.OportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadService {
    @Autowired
    private OportunidadRepository oportunidadRepository;

    public List<Oportunidad> getOportunidades() {
        return oportunidadRepository.findAll();
    }

    public Optional<Oportunidad> getOportunidadById(int id) {
        return oportunidadRepository.findById(id);
    }

    public Oportunidad saveOportunidad(Oportunidad oportunidad) {
        return oportunidadRepository.save(oportunidad);
    }

    public void deleteOportunidad(int id) {
        if (oportunidadRepository.existsById(id)) {
            oportunidadRepository.deleteById(id);
        } else {
            throw new RuntimeException("Oportunidad no encontrada");
        }
    }

    public Oportunidad updateOportunidad(Oportunidad oportunidad, int id) {
        Optional<Oportunidad> existe = getOportunidadById(id);
        if (existe.isEmpty()) {
            throw new RuntimeException("Oportunidad no encontrada");
        } else {
            oportunidad.setId(id); // Aseguramos que se actualice el correcto
            return oportunidadRepository.save(oportunidad);
        }
    }
}
