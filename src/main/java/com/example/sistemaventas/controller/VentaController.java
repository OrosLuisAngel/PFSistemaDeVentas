package com.example.sistemaventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.sistemaventas.entity.Usuario;
import com.example.sistemaventas.entity.Venta;
import com.example.sistemaventas.services.UsuarioService;
import com.example.sistemaventas.services.VentaService;



@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String selectAll(Model model) {
        model.addAttribute("ventas", ventaService.selectAll());
        model.addAttribute("usuarios", usuarioService.selectAll());
        model.addAttribute("venta", new Venta()); // IMPORTANTEEEE agrega una venta vacía para inicializar el formulario
        return "ventas";
    }

    @PostMapping("/guardar")
    public String saveVenta(@ModelAttribute Venta venta, @RequestParam Integer id_usuario) {
        Usuario usuario = usuarioService.findById(id_usuario);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id_usuario);
        }
        venta.setUsuario(usuario);
        ventaService.insertVenta(venta);
        return "redirect:/ventas";
    }

    @PutMapping("/actualizar/{id_venta}")
    public String updateVenta(@PathVariable Integer id_venta, @ModelAttribute Venta venta, @RequestParam Integer id_usuario) {
        Venta existingVenta = ventaService.selectById(id_venta);
        if (existingVenta == null) {
            throw new RuntimeException("Venta no encontrada con ID: " + id_venta);
        }

        Usuario usuario = usuarioService.findById(id_usuario);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id_usuario);
        }

        existingVenta.setUsuario(usuario);
        existingVenta.setFecha_venta(venta.getFecha_venta());
        existingVenta.setTotal_venta(venta.getTotal_venta());

        ventaService.updateVenta(existingVenta);
        return "redirect:/ventas";
    }
}
