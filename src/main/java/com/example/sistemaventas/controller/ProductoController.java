package com.example.sistemaventas.controller;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoController {

    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private String descripcion;

}
