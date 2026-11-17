package com.gestionmovil.gestionmovil_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seguimiento {
    private long fecha; // Usualmente guardamos timestamps
    private String descripcion;
    private String tipoGestion; // Llamada, Correo, Reunión
    private int oportunidadId; // Clave foránea
}
