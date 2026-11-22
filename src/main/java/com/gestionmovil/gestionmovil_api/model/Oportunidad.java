package com.gestionmovil.gestionmovil_api.model;

import com.gestionmovil.gestionmovil_api.model.enums.EstadoOportunidad;
import com.gestionmovil.gestionmovil_api.model.enums.PotencialComercial;
import com.gestionmovil.gestionmovil_api.model.enums.Prioridad;
import com.gestionmovil.gestionmovil_api.model.enums.TipoOportunidad;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoOportunidad tipo;

    private String descripcion;
    private String fuenteInformacion;
    private long fechaDeteccion; // epoch millis
    private String responsable;  // responsable interno (ficticio)

    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @Enumerated(EnumType.STRING)
    private PotencialComercial potencialComercial;

    @Enumerated(EnumType.STRING)
    private EstadoOportunidad estado = EstadoOportunidad.EVENTO_IDENTIFICADO;

    private long fechaActualizacion; // epoch millis
    private String observaciones = "";
    private String fotoPath = null;
}
