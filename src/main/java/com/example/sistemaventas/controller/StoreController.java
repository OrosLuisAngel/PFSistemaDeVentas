package com.example.sistemaventas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sistemaventas.entity.Producto;
import com.example.sistemaventas.services.ProductoService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class StoreController {

    private final ProductoService productoService;

    @Autowired
    public StoreController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/store")
    public String store(Model model) {
            List<Producto> productos = productoService.selectAll();
    model.addAttribute("productos", productos);


        return "store";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/sign")
    public String sign() {
        return "sign";
    }

}