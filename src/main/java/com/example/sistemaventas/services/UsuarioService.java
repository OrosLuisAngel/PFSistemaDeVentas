package com.example.sistemaventas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaventas.entity.Usuario;
import com.example.sistemaventas.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> selectAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));
    }

    public Usuario selectById(Integer id_usuario){
        return usuarioRepository.findById(id_usuario).orElse(new Usuario());
    }
    
    public Usuario insertUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Integer id_usuario){
        usuarioRepository.deleteById(id_usuario);
    }
    public void updateUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    // -------------------------------SECURITY-------------------------------------- //
    // para el security
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow();
    }
}
