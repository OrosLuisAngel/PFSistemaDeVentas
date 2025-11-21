package com.example.sistemaventas.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sistemaventas.controller.AuthResponse;
import com.example.sistemaventas.controller.LoginRequest;
import com.example.sistemaventas.controller.RegisterRequest;
import com.example.sistemaventas.entity.Rol;
import com.example.sistemaventas.entity.Usuario;
import com.example.sistemaventas.repository.RolRepository;
import com.example.sistemaventas.repository.UsuarioRepository;
import com.example.sistemaventas.security.CustomUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado.");
        }

        Rol rolPorDefecto = rolRepository.findById(2)
            .orElseThrow(() -> new IllegalArgumentException("Rol por defecto no encontrado"));

        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .telefono(request.getTelefono())
                .ciudad(request.getCiudad())
                .pais(request.getPais())
                .rol(rolPorDefecto)
                .build();

        usuarioRepository.save(usuario);

        CustomUser customUser = CustomUser.builder()
                .usuario(usuario)
                .build();

        return AuthResponse.builder()
                .token(jwtService.getToken(customUser))
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
        UserDetails userDetails = CustomUser.builder().usuario(usuario).build();
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
