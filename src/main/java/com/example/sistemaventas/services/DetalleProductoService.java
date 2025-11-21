package com.example.sistemaventas.services;

import com.example.sistemaventas.entity.DetalleProducto;
import com.example.sistemaventas.repository.DetalleProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleProductoService {

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

    public List<DetalleProducto> selectAll() {
        List<DetalleProducto> detalles = detalleProductoRepository.findAll();
        System.out.println("Detalles obtenidos desde el repositorio: " + detalles);
        return detalles;
    }

    public DetalleProducto selectById(Integer id_detalle_producto) {
        return detalleProductoRepository.findById(id_detalle_producto).orElse(new DetalleProducto());
    }

    public DetalleProducto insertDetalleProducto(DetalleProducto detalleProducto) {
        return detalleProductoRepository.save(detalleProducto);
    }

    public void deleteDetalleProducto(Integer id_detalle_producto) {
        detalleProductoRepository.deleteById(id_detalle_producto);
    }

    public void updateDetalleProducto(DetalleProducto detalleProducto) {
        detalleProductoRepository.save(detalleProducto);
    }
}
