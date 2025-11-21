package com.example.sistemaventas.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sistemaventas.entity.Producto;
import com.example.sistemaventas.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> selectAll() {
        return productoRepository.findAll();
    }
    
    public Producto selectById(Integer id_producto){
        return productoRepository.findById(id_producto).orElse(new Producto());
    }
    
    public Producto insertProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteProducto(Integer id_producto){
        productoRepository.deleteById(id_producto);
    }
    public void updateProducto(Producto producto){
        productoRepository.save(producto);
    }
}
