package com.example.sistemaventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistemaventas.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

}
