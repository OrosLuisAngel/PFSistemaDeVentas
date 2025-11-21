package com.example.sistemaventas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaventas.entity.Rol;
import com.example.sistemaventas.repository.RolRepository;


@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public List<Rol> selectAll(){
        return rolRepository.findAll();
    }

    public Rol selectById(Integer id_rol){
        return rolRepository.findById(id_rol).orElse(new Rol());
    }
    
    public Rol insertRol(Rol rol){
        return rolRepository.save(rol);
    }

    public void deleteRol(Integer id_rol){
        rolRepository.deleteById(id_rol);
    }
    public void updateRol(Rol rol){
        rolRepository.save(rol);
    }
    
}
