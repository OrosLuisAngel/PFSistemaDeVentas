package com.example.sistemaventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistemaventas.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    
}
