package com.example.sistemaventas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaventas.entity.Promocion;
import com.example.sistemaventas.entity.PromocionRepository;


@Service
public class PromocionService {

    @Autowired
    PromocionRepository promocionRepository;

    public List<Promocion> selectAll(){
        return promocionRepository.findAll();
    }

    public Promocion selectById(Integer id_promocion){
        return promocionRepository.findById(id_promocion).orElse(new Promocion());
    }
    
    public Promocion insertPromocion(Promocion promocion){
        return promocionRepository.save(promocion);
    }

    public void deletePromocion(Integer id_promocion){
        promocionRepository.deleteById(id_promocion);
    }
    public void updatePromocion(Promocion promocion){
        promocionRepository.save(promocion);
    }
}
