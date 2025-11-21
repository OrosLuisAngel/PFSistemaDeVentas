package com.example.sistemaventas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;

    @Column(nullable = false)
    private String rol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> usuarios;
    public Integer getId_rol() {
        return id_rol;
    }
    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
