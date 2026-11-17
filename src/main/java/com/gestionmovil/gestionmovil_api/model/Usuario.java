package com.gestionmovil.gestionmovil_api.model;

import com.gestionmovil.gestionmovil_api.model.enums.RolUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id = 0;
    private String nombre;
    private String correo;
    private String contrasena; // Contraseña ficticia
    private RolUsuario rol; // Enum: EJECUTIVO o SUPERVISOR
}
