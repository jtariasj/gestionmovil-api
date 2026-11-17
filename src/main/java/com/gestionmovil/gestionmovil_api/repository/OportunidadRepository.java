package com.gestionmovil.gestionmovil_api.repository;

import com.gestionmovil.gestionmovil_api.model.Oportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadRepository extends JpaRepository<Oportunidad, Integer> {
}
