package com.gestionmovil.gestionmovil_api.model;

import com.gestionmovil.gestionmovil_api.model.enums.RolUsuario;

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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String correo;
    private String contrasena; // Contraseña ficticia

    @Enumerated(EnumType.STRING)
    private RolUsuario rol; // Enum: EJECUTIVO o SUPERVISOR
}
