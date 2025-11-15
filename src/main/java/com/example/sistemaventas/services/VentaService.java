package com.example.sistemaventas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaventas.entity.Venta;
import com.example.sistemaventas.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> selectAll() {
        return ventaRepository.findAll();
    }

    public Venta selectById(Integer id_venta) {
        return ventaRepository.findById(id_venta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id_venta));
    }

    public Venta insertVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void deleteVenta(Integer id_venta) {
        if (!ventaRepository.existsById(id_venta)) {
            throw new RuntimeException("Venta no encontrada con ID: " + id_venta);
        }
        ventaRepository.deleteById(id_venta);
    }

    public void updateVenta(Venta venta) {
        if (!ventaRepository.existsById(venta.getId_venta())) {
            throw new RuntimeException("Venta no encontrada con ID: " + venta.getId_venta());
        }
        ventaRepository.save(venta);
    }
}
