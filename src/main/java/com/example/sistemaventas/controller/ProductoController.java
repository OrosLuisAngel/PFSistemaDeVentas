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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sistemaventas.entity.Categoria;
import com.example.sistemaventas.entity.Producto;
import com.example.sistemaventas.services.CategoriaService;
import com.example.sistemaventas.services.ProductoService;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String selectAll(Model model) {
        model.addAttribute("productos", productoService.selectAll());
        model.addAttribute("categorias", categoriaService.selectAll());
        model.addAttribute("producto", new Producto());
        return "productos";
    }

    @PostMapping("nuevo")
    public String newProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos";
    }

    @PostMapping("/actualizar/{id_producto}")
    public String updateProducto(@PathVariable Integer id_producto, @ModelAttribute Producto producto, @RequestParam Integer id_categoria) {
        Producto existingProducto = productoService.selectById(id_producto);
        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setPrecio(producto.getPrecio());
            existingProducto.setStock(producto.getStock());
            existingProducto.setTamaño(producto.getTamaño());
            existingProducto.setImagen_url(producto.getImagen_url());

            Categoria categoria = categoriaService.selectById(id_categoria);
            existingProducto.setCategoria(categoria);

            productoService.updateProducto(existingProducto);
        }
        return "redirect:/productos";
    }

    @PostMapping("/guardar")
    public String saveProducto(@ModelAttribute Producto producto, @RequestParam Integer id_categoria) {
        Categoria categoria = categoriaService.selectById(id_categoria);
        producto.setCategoria(categoria);
        productoService.insertProducto(producto);
        return "redirect:/productos";
    }

    @DeleteMapping("eliminar/{id_producto}")
    public String deleteProducto(@PathVariable Integer id_producto) {
        productoService.deleteProducto(id_producto);
        return "redirect:/productos";
    }
}
