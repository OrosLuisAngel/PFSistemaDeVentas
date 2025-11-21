package com.example.sistemaventas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "promociones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promocion {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_promocion;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private Double descuento;
    @Column
    private String fecha_inicio;
    @Column
    private String fecha_fin;

    public Integer getId_promocion() {
        return id_promocion;
    }
    public void setId_promocion(Integer id_promocion) {
        this.id_promocion = id_promocion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getDescuento() {
        return descuento;
    }
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    public String getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public String getFecha_fin() {
        return fecha_fin;
    }
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
}
