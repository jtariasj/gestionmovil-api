package com.gestionmovil.gestionmovil_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contacto {
    private int id = 0;
    private String nombre;
    private String cargo;
    private String telefono;
    private String correo;
    private int organizacionId; // Clave foránea
}
