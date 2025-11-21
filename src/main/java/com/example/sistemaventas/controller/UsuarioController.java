package com.example.sistemaventas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.sistemaventas.entity.Rol;
import com.example.sistemaventas.entity.Usuario;
import com.example.sistemaventas.services.RolService;
import com.example.sistemaventas.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.selectAll());
        model.addAttribute("roles", rolService.selectAll());
        model.addAttribute("usuario", new Usuario());
        return "usuarios";
    }

    @PostMapping("nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.selectAll());
        return "usuarios";
    }

    @PostMapping("actualizar/{id_usuario}")
    public String actualizarUsuario(@PathVariable Integer id_usuario, @ModelAttribute Usuario usuario, @RequestParam Integer id_rol) {
        Usuario existingUsuario = usuarioService.selectById(id_usuario);
        if (existingUsuario != null) {
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setApellido(usuario.getApellido());
            existingUsuario.setEmail(usuario.getEmail());
            existingUsuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            existingUsuario.setTelefono(usuario.getTelefono());
            existingUsuario.setCiudad(usuario.getCiudad());
            existingUsuario.setPais(usuario.getPais());

            Rol rol = rolService.selectById(id_rol);
            existingUsuario.setRol(rol);

            usuarioService.updateUsuario(existingUsuario);
        }
        return "redirect:/usuarios";
    }

    @PostMapping("guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario, @RequestParam Integer id_rol) {
        Rol rol = rolService.selectById(id_rol);
        usuario.setRol(rol);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        usuarioService.insertUsuario(usuario);
        return "redirect:/usuarios";
    }

    @DeleteMapping("eliminar/{id_usuario}")
    public String eliminarUsuario(@PathVariable Integer id_usuario) {
        usuarioService.deleteUsuario(id_usuario);
        return "redirect:/usuarios";
    }
}
