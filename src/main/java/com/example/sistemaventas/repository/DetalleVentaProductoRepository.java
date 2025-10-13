package com.example.sistemaventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistemaventas.entity.DetalleVentaProducto;

public interface DetalleVentaProductoRepository extends JpaRepository<DetalleVentaProducto, Integer> {

}
