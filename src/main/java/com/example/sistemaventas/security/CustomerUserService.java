package com.example.sistemaventas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sistemaventas.entity.Usuario;
import com.example.sistemaventas.services.UsuarioService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerUserService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario;
        try {
            usuario = usuarioService.findByEmail(username);
            return new CustomUser(usuario);
        } catch (Exception ex) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email: ");
        }
        
        
        //Usuario usuario = usuarioService.findByEmail(username);
        //if (usuario == null) {
        //    throw new UsernameNotFoundException("Usuario no encontrado con el email: " + username);
        //}
        //return new CustomUser(usuario);
    }

}
