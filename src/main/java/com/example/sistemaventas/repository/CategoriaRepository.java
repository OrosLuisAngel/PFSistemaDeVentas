package com.example.sistemaventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistemaventas.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
