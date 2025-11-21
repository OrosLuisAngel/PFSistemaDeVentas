package com.example.sistemaventas.services;


import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.sistemaventas.entity.Categoria;
import com.example.sistemaventas.repository.CategoriaRepository;

@Service
public class CategoriaService {


    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> selectAll(){
        return categoriaRepository.findAll();
    }

    public Categoria selectById(Integer id_categoria){
        return categoriaRepository.findById(id_categoria).orElse(new Categoria());
    }
    
    public Categoria insertCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Integer id_categoria){
        categoriaRepository.deleteById(id_categoria);
    }
    public void updateCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }
}
