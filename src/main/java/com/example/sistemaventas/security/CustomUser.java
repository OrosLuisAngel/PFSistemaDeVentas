package com.example.sistemaventas.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sistemaventas.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


public class CustomUser implements UserDetails{
    
    private Usuario usuario;

    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (usuario.getRol() == null || usuario.getRol().getRol() == null) {
            throw new IllegalArgumentException("el rol del usuario no puede ser nulo");
        }
        return List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getRol()));
    }


    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    public String getNombre() {
    return usuario.getNombre();
}

public String getApellido() {
    return usuario.getApellido();
}

public String getTelefono() {
    return usuario.getTelefono();
}


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }

   

}
