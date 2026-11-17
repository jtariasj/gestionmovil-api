package com.gestionmovil.gestionmovil_api.model;

import com.gestionmovil.gestionmovil_api.model.enums.EstadoOportunidad;
import com.gestionmovil.gestionmovil_api.model.enums.PotencialComercial;
import com.gestionmovil.gestionmovil_api.model.enums.Prioridad;
import com.gestionmovil.gestionmovil_api.model.enums.TipoOportunidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oportunidad {
    private int id = 0;
    private String nombre;
    private TipoOportunidad tipo;
    private String descripcion;
    private String fuenteInformacion;
    private long fechaDeteccion; // epoch millis
    private String responsable;  // responsable interno (ficticio)
    private Prioridad prioridad;
    private PotencialComercial potencialComercial;
    private EstadoOportunidad estado = EstadoOportunidad.EVENTO_IDENTIFICADO;
    private long fechaActualizacion; // epoch millis
    private String observaciones = "";
    private String fotoPath = null;
}
