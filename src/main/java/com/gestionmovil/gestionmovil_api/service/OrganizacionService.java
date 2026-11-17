package com.gestionmovil.gestionmovil_api.service;

import com.gestionmovil.gestionmovil_api.model.Organizacion;
import com.gestionmovil.gestionmovil_api.repository.OrganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizacionService {
    @Autowired
    private OrganizacionRepository organizacionRepository;

    public List<Organizacion> getOrganizaciones() {
        return organizacionRepository.findAll();
    }

    public Optional<Organizacion> getOrganizacionById(int id) {
        return organizacionRepository.findById(id);
    }

    public Organizacion saveOrganizacion(Organizacion organizacion) {
        return organizacionRepository.save(organizacion);
    }

    public void deleteOrganizacion(int id) {
        if (organizacionRepository.existsById(id)) {
            organizacionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Organizacion no encontrada");
        }
    }

    public Organizacion updateOrganizacion(Organizacion organizacion, int id) {
        Optional<Organizacion> existe = getOrganizacionById(id);
        if (existe.isEmpty()) {
            throw new RuntimeException("Organizacion no encontrada");
        } else {
            organizacion.setId(id); // Aseguramos que se actualice el correcto
            return organizacionRepository.save(organizacion);
        }
    }
}
