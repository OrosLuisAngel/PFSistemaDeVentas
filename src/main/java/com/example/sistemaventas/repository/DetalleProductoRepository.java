package com.example.sistemaventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistemaventas.entity.DetalleProducto;


public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Integer> {

}
