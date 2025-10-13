package com.example.sistemaventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistemaventas.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
