package com.gestionmovil.gestionmovil_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organizacion {
    private int id = 0;
    private String nombreEmpresa;
    private String rut;
    private String direccion;
}
