package com.example.sistemaventas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ventas")
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;

    @Column
    private String fecha_venta;

    @Column
    private Double total_venta;

    @ManyToOne(fetch = FetchType.EAGER) // Carga siempre el usuario asociado
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;

    public Integer getId_venta() {
        return id_venta;
    }
    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }
    public String getFecha_venta() {
        return fecha_venta;
    }
    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    public Double getTotal_venta() {
        return total_venta;
    }
    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
