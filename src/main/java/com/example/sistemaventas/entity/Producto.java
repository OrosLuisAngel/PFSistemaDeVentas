package com.example.sistemaventas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer productorID;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidad;
    private String categoriaID;
    private String proveedorID;
    private String imagenURL;
}
