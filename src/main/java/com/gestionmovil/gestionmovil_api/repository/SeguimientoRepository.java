package com.gestionmovil.gestionmovil_api.repository;

import com.gestionmovil.gestionmovil_api.model.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {
}
