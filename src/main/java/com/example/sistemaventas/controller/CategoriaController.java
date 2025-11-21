package com.example.sistemaventas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sistemaventas.entity.Categoria;
import com.example.sistemaventas.services.CategoriaService;




@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String usuarios() {
        return "categorias";
    }

    @GetMapping()
    public String ListCategoria(Model model) {
        model.addAttribute("categorias", categoriaService.selectAll());
        return "categorias";
    } //esto bien porque solo muestras

    @PostMapping("nuevo")
    public String newCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    @PutMapping("actualizar/{id_categoria}")
    public String updateCategoria(@PathVariable Integer id_categoria, @ModelAttribute Categoria categoria) {
        Categoria existingCategoria = categoriaService.selectById(id_categoria);
        if (existingCategoria != null) {
            existingCategoria.setNombre(categoria.getNombre());
            existingCategoria.setDescripcion(categoria.getDescripcion());
            categoriaService.updateCategoria(existingCategoria);
        }
        return "redirect:/categorias";
    }

    @PostMapping("guardar")
    public String saveCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.insertCategoria(categoria);
        return "redirect:/categorias";
    }

    @DeleteMapping("eliminar/{id_categoria}")
    public String deleteCategoria(@PathVariable Integer id_categoria) {
        categoriaService.deleteCategoria(id_categoria);
        return "redirect:/categorias";
    }
    
}
