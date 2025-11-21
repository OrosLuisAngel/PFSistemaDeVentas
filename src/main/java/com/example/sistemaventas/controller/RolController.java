package com.example.sistemaventas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.sistemaventas.entity.Rol;
import com.example.sistemaventas.services.RolService;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public String listarRoles(Model model) {
        model.addAttribute("roles", rolService.selectAll());
        return "roles";
    }

    @PostMapping("nuevo")
    public String nuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles";
    }

    @PutMapping("actualizar/{id_rol}")
    public String updateRol(@PathVariable Integer id_rol, @ModelAttribute Rol rol) {
        Rol existingRol = rolService.selectById(id_rol);
        if (existingRol != null) {
            existingRol.setRol(rol.getRol());
            rolService.updateRol(existingRol);
        }
        return "redirect:/roles";
    }

    @PostMapping("guardar")
    public String insertRol(@ModelAttribute Rol rol) {
        rolService.insertRol(rol);
        return "redirect:/roles";
    }

    @DeleteMapping("eliminar/{id_rol}")
    public String deleteRol(@PathVariable Integer id_rol) {
        rolService.deleteRol(id_rol);
        return "redirect:/roles";
    }
}
