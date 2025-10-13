package com.example.sistemaventas.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    private Integer ventaID;
    private String fecha;
    private Double total;
    private Integer clienteID;
    private Integer empleadoID;
}
